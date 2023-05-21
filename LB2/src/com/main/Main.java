package com.main;

import com.salad.Salad;
import com.vegetable.Cabbage;
import com.vegetable.Carrot;
import com.vegetable.Vegetable;
import com.writer.WriterInfo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Salad salad = new Salad();

        // Создание овощей
        Carrot carrot1 = new Carrot("Морковь 1", 50);
        Carrot carrot2 = new Carrot("Морковь 2", 40);
        Cabbage cabbage1 = new Cabbage("Капуста 1", 30);
        Cabbage cabbage2 = new Cabbage("Капуста 2", 20);

        // Добавление овощей в салат
        salad.addVegetable(carrot1);
        salad.addVegetable(carrot2);
        salad.addVegetable(cabbage1);
        salad.addVegetable(cabbage2);

        // Вывод информации о салате
        WriterInfo.printSaladInfo(salad);

        // Сортировка овощей по калорийности
        salad.sortVegetablesByParameter();
        WriterInfo.printSaladInfo(salad);

        // Поиск овощей в заданном диапазоне калорийности
        int minCalories = 20;
        int maxCalories = 50;
        List<Vegetable> vegetablesInRange = salad.findVegetablesByCaloriesRange(minCalories, maxCalories);
        WriterInfo.printVegetableInfo(vegetablesInRange);
    }
}