package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensValue() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(lion.getKittens(), 1);
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(lion.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }

    @Test
    public void exceptionHasMane() {
        try {
            Lion lion = new Lion(new Feline(), "Самец");
            lion.doesHaveMane();
            assertTrue(lion.doesHaveMane());
            lion = new Lion(feline, "Самка");
            assertFalse(lion.doesHaveMane());
            assertThrows(Exception.class, () -> new Lion(new Feline(), "Лысый"));
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}
