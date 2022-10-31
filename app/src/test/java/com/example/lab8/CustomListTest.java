package com.example.lab8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @Before
    public void createList(){
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void hasCityTest() {
        list = new CustomList(null, new ArrayList<City>());
        City city = new City("Estevan", "SK");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    public void deleteCityTest() {
        list = new CustomList(null, new ArrayList<City>());
        City city = new City("Regina", "Saskatchewan");
        list.addCity(city);
        list.deleteCity(city);
        Assertions.assertFalse(list.hasCity(city));
        assertThrows( IllegalArgumentException.class, () -> {
            list.deleteCity(city); });
    }

    @Test
    public void testCountCities() {
        list = new CustomList(null, new ArrayList<City>());
        Assertions.assertEquals(1, list.countCities());
        City city = new City("Regina", "Saskatchewan");
        list.add(city);
        Assertions.assertEquals(2, list.countCities());
    }

}
