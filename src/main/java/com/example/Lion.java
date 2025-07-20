package com.example;

import java.util.List;

public class Lion {

    private final Feline feline;
    private final String sex;

    public Lion(String sex, Feline feline) {
        this.sex = sex;
        this.feline = feline;

        if (!sex.equals("Самец") && !sex.equals("Самка")) {
            throw new IllegalArgumentException("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public List<String> getFood() throws Exception {
        return feline.eatMeat();
    }

    public boolean doesHaveMane() {
        return "Самец".equals(sex);
    }
}
