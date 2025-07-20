import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    Feline felineMock;

    @Test
    void getSoundReturnsMeow() {
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodReturnsFelineFood() throws Exception {
        List<String> food = List.of("Рыба", "Молоко");
        when(felineMock.eatMeat()).thenReturn(food);
        Cat cat = new Cat(felineMock);
        assertEquals(food, cat.getFood());
        verify(felineMock).eatMeat();
    }
}

