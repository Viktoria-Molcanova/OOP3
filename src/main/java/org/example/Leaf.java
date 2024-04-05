package org.example;

// Класс "Лист"
public class Leaf extends java.awt.Component implements Component {
    @Override
    public void execute() {
        System.out.println("Выполняется действие в листе");
    }
}
