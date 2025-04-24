package ru.vpankova;

public class Main {

    public static void main(String[] args) {
        Building test = new Building("Moscow", "Arbatskaya", "38", true);
        test.setFloorCount(16);

        System.out.println(test.getAddress());
    }
}
