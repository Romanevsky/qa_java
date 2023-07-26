package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest {
    private final String animalKind;
    private final List<String> expected;
    Animal animal = new Animal();

    public AnimalTest(String animalKind, List<String> expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAnimalData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }
    @Test
    public void testAnimalValidation() throws Exception {
        List<String> actual = animal.getFood(animalKind);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testIncorrectValueOfAnimal () throws Exception {
        List<String> actual = animal.getFood("Другое");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAnimalFamily() {
        String actual = animal.getFamily();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", actual);
    }
}
