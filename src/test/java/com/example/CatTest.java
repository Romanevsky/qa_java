package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline ;

    @Test
    public void getCatCorrectSound(){
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыбы"));
        assertEquals(cat.getFood(), List.of("Животные", "Птицы", "Рыбы"));

    }
}
