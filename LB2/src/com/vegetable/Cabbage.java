package com.vegetable;

public class Cabbage extends Vegetable {
    public Cabbage(String name, int calories) {
        super(name, calories);
    }

    public Cabbage(String name) {
        super(name);
    }

    public Cabbage() {
        super();
    }

    @Override
    public void prepare() {
        System.out.println("Подготовка капусты");
    }
}