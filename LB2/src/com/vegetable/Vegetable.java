package com.vegetable;

public abstract class Vegetable implements Comparable<Vegetable> {
    private String name;
    private int calories;

    public Vegetable(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public Vegetable(String name) {
        this.name = name;
    }

    public Vegetable() {
        this.name = "";
    }

    public abstract void prepare();

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public int compareTo(Vegetable other) {
        return Integer.compare(calories, other.calories);
    }
}