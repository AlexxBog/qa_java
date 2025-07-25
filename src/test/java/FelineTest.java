import com.example.Feline;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class FelineTest {

    @Test
    void eatMeatReturnsExpectedFoodList() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    void getFamilyReturnsProperValue() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensReturnsDefaultOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getKittensReturnsProvidedValue() {
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3));
    }
}
