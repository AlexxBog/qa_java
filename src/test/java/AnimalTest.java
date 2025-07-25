import com.example.Animal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @ParameterizedTest
    @MethodSource("provideValidAnimalTypesAndFood")
    void getFoodReturnsCorrectFoodForAnimalType(String animalType, List<String> expectedFood) throws Exception {
        Animal animal = new Animal();
        assertEquals(expectedFood, animal.getFood(animalType));
    }

    private static Stream<Arguments> provideValidAnimalTypesAndFood() {
        return Stream.of(
                Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба")),
                Arguments.of("Травоядное", List.of("Трава", "Различные растения"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"Всеядное", "Неизвестное", ""})
    void getFoodThrowsExceptionForInvalidTypes(String animalType) {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood(animalType));
        assertTrue(exception.getMessage().contains("Неизвестный вид животного"));
    }
}
