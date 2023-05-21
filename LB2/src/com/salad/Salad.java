package com.salad;

import com.vegetable.*;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> vegetables;

    public Salad() {
        vegetables = new ArrayList<>();
    }

    public void addVegetable(Vegetable vegetable) {
        vegetables.add(vegetable);
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public int getCalories() {
        int totalCalories = 0;
        for (Vegetable vegetable : vegetables) {
            totalCalories += vegetable.getCalories();
        }
        return totalCalories;
    }

    public void sortVegetablesByParameter() {
        vegetables.sort(Vegetable::compareTo);
    }

    public List<Vegetable> findVegetablesByCaloriesRange(int minCalories, int maxCalories) {
        List<Vegetable> result = new ArrayList<>();
        for (Vegetable vegetable : vegetables) {
            int calories = vegetable.getCalories();
            if (calories >= minCalories && calories <= maxCalories) {
                result.add(vegetable);
            }
        }
        return result;
    }
}