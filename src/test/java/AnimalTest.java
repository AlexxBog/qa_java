import com.example.Animal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @ParameterizedTest
    @EnumSource(AnimalType.class)
    void getFoodForDifferentAnimalTypes(AnimalType animalType) throws Exception {
        Animal animal = new Animal();
        if (animalType == AnimalType.PREDATOR) {
            assertEquals(List.of("Животные", "Птицы", "Рыба"), animal.getFood("Хищник"));
        } else if (animalType == AnimalType.HERBIVORE) {
            assertEquals(List.of("Трава", "Различные растения"), animal.getFood("Травоядное"));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Всеядное", "Неизвестное", ""})
    void getFoodThrowsExceptionForInvalidTypes(String animalType) {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood(animalType));
        assertTrue(exception.getMessage().contains("Неизвестный вид животного"));
    }

    enum AnimalType {
        PREDATOR, HERBIVORE
    }
}
