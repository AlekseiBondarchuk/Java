package com.vegetable;

public class Carrot extends Vegetable {
    public Carrot(String name, int calories) {
        super(name, calories);
    }

    public Carrot(String name) {
        super(name);
    }

    public Carrot() {
        super();
    }

    @Override
    public void prepare() {
        System.out.println("Подготовка моркови");
    }
}
