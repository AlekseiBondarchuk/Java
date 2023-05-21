package com.writer;

import com.salad.Salad;
import com.vegetable.Vegetable;

import java.util.List;

public class WriterInfo {
    public static void printSaladInfo(Salad salad) {
        List<Vegetable> vegetables = salad.getVegetables();
        System.out.println("Салат содержит следующие овощи:");
        for (Vegetable vegetable : vegetables) {
            System.out.println(vegetable.getName());
        }
        System.out.println("Общая калорийность: " + salad.getCalories());
    }

    public static void printVegetableInfo(List<Vegetable> vegetables) {
        System.out.println("Овощи в заданном диапазоне калорийности:");
        for (Vegetable vegetable : vegetables) {
            System.out.println(vegetable.getName() + " - " + vegetable.getCalories() + " калорий");
        }
    }
}