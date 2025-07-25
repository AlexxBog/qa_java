import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline felineMock;

    @Test
    void getKittensReturnsFromFeline() {
        when(felineMock.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(2, lion.getKittens());
    }

    @Test
    void getFoodDelegatesToFeline() throws Exception {
        List<String> foodList = List.of("Мясо", "Газель");
        when(felineMock.eatMeat()).thenReturn(foodList);
        Lion lion = new Lion("Самка", felineMock);
        assertEquals(foodList, lion.getFood());
        verify(felineMock).eatMeat();
    }

    @ParameterizedTest
    @ValueSource(strings = { "Самец", "Самка" })
    void doesHaveManeBySex(String sex) {
        Lion lion = new Lion(sex, felineMock);
        boolean expected = sex.equals("Самец");
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    void throwsExceptionForInvalidSex() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lion("Детёныш", felineMock);
        });
        assertTrue(exception.getMessage().contains("допустимые значения пола"));
    }
}
