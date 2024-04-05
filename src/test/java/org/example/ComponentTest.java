package org.example;

import org.example.Leaf;
import org.junit.jupiter.api.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

abstract class BaseComponentTest {
    protected Component component;

    @BeforeEach
    void setUp() {
        component = createComponent();
    }

    @AfterEach
    void tearDown() {
        component = null;
    }

    abstract Component createComponent();

    @Test
    void testExecute() {
        assertDoesNotThrow(() -> component.execute());
    }
}

class LeafTest extends BaseComponentTest {
    @Override
    Component createComponent() {
        return new Leaf();
    }
}

class CompositeTest extends BaseComponentTest {
    @Override
    Component createComponent() {
        Composite composite = new Composite();
        composite.addComponent(new Leaf());
        composite.addComponent(new Leaf());
        return (Component) composite;
    }

    @Test
    void testAddComponent() {
        Component newLeaf = new Leaf();
        ((Composite) component).addComponent(newLeaf);

        assertTrue(((Composite) component).getComponents().contains(newLeaf));
    }

    @Test
    void testRemoveComponent() {
        Component leafToRemove = ((Composite) component).getComponents().get(0);
        ((Composite) component).removeComponent(leafToRemove);

        assertFalse(((Composite) component).getComponents().contains(leafToRemove));
    }
}

class CompositePatternTest {
    @Test
    void testCompositePattern() {
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        Component leaf3 = new Leaf();

        Composite container = new Composite();
        container.addComponent(leaf1);
        container.addComponent(leaf2);

        assertDoesNotThrow(() -> container.execute());

        container.removeComponent(leaf2);
        assertDoesNotThrow(() -> container.execute());
    }
}
