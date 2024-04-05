package org.example;

import java.util.ArrayList;
import java.util.List;

// Интерфейс "Компонент"
interface Component {
    void execute();
}

// Класс "Контейнер"
class Composite implements Component {
    public final List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public void execute() {
        System.out.println("Выполняется действие в контейнере");

        for (Component component : components) {
            component.execute();
        }
    }
}

// Класс для тестирования паттерна Компоновщик
public class CompositePatternTest {
    public static void main(String[] args) {
        // Создание компонентов
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        Component leaf3 = new Leaf();

        // Создание контейнера и добавление в него компонентов
        Composite container = new Composite();
        container.addComponent(leaf1);
        container.addComponent(leaf2);

        // Выполнение действий
        container.execute();

        // Удаление компонента из контейнера и выполнение действия
        container.removeComponent(leaf2);
        container.execute();
    }
}
