package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    Feline feline = new Feline();
    @Test
    public void getFamilyOfKittens() {
        String family = feline.getFamily();
        assertEquals(family, "Кошачьи");
    }
    @Test
    public void getKittensRightValue() {
        int kittens = feline.getKittens();
        assertEquals(kittens, 1);
    }
    @Test
    public void eatMeatReturnsCorrectList() throws Exception {
        List<String> felineFood = feline.eatMeat();
        assertEquals(felineFood, List.of("Животные", "Птицы", "Рыба"));
    }
    @Test
    public void getKittensNegativeValue() {
        int kittens = feline.getKittens(-1);
        assertEquals(kittens, -1);
    }
}
