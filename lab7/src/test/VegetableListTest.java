package test;

import exception.VegetableException;
import list.VegetableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import vegetable.*;

import static org.junit.jupiter.api.Assertions.*;

class VegetableListTest {
    private VegetableList<Vegetable> vegetableList;
    private Tomato tomato;
    private Cucumber cucumber;
    private Carrot carrot;

    @BeforeEach
    void setUp() {
        vegetableList = new VegetableList<>();
        tomato = new Tomato("Tomato", 20);
        cucumber = new Cucumber("Cucumber", 15);
        carrot = new Carrot("Carrot", 30);
    }

    @Test
    void testSize() {
        assertEquals(0, vegetableList.size());
        vegetableList.add(tomato);
        vegetableList.add(cucumber);
        assertEquals(2, vegetableList.size());
        vegetableList.remove(tomato);
        assertEquals(1, vegetableList.size());
        vegetableList.clear();
        assertEquals(0, vegetableList.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(vegetableList.isEmpty());
        vegetableList.add(tomato);
        assertFalse(vegetableList.isEmpty());
    }

    @Test
    void testContains() {
        assertFalse(vegetableList.contains(tomato));
        vegetableList.add(tomato);
        assertTrue(vegetableList.contains(tomato));
    }

    @Test
    void testToArray() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));
        Object[] array = vegetableList.toArray();

        assertEquals(vegetableList.size(), array.length);
        assertTrue(Arrays.asList(array).containsAll(vegetableList));
    }

    @Test
    void testAdd() {
        assertTrue(vegetableList.add(tomato));
        assertTrue(vegetableList.add(carrot));
        assertEquals(2, vegetableList.size());
    }

    @Test
    void testAddNull() {
        Exception exception = assertThrows(VegetableException.class, () -> vegetableList.add(null));
        assertEquals("Cannot add null element to the list", exception.getMessage());
    }

    @Test
    void testRemove() {
        assertFalse(vegetableList.remove(tomato));
        vegetableList.add(cucumber);
        assertFalse(vegetableList.remove(tomato));
        assertTrue(vegetableList.remove(cucumber));
        assertFalse(vegetableList.contains(cucumber));
    }

    @Test
    void testRemoveNull() {
        Exception exception = assertThrows(VegetableException.class, () -> vegetableList.remove(null));
        assertEquals("Cannot remove null element from the list", exception.getMessage());
    }

    @Test
    void testContainsAll() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));
        assertTrue(vegetableList.containsAll(Arrays.asList(tomato, cucumber)));
        assertFalse(vegetableList.containsAll(Arrays.asList(tomato, cucumber, new Tomato("Tomato2", 20))));
    }

    @Test
    void testContainsAllNull() {
        Exception exception = assertThrows(VegetableException.class, () -> vegetableList.containsAll(null));
        assertEquals("Error while checking if the list contains all elements of the collection", exception.getMessage());
    }

    @Test
    void testAddAll() {
        List<Vegetable> vegetables = Arrays.asList(tomato, cucumber, carrot);
        assertTrue(vegetableList.addAll(vegetables));
        assertEquals(3, vegetableList.size());
        assertTrue(vegetableList.containsAll(vegetables));
    }

    @Test
    void testAddAllNull() {
        Exception exception = assertThrows(VegetableException.class, () -> vegetableList.addAll(null));
        assertEquals("Error while adding all the elements of the collection", exception.getMessage());
    }

    @Test
    void testAddAllAtIndex() {
        vegetableList.add(tomato);
        vegetableList.add(carrot);

        List<Vegetable> vegetables = Arrays.asList(cucumber, new Tomato("Tomato2", 20));
        assertTrue(vegetableList.addAll(1, vegetables));

        assertEquals(4, vegetableList.size());
        assertTrue(vegetableList.containsAll(vegetables));
    }

    @Test
    void testAddAllAtIndexInvalid() {
        Exception exception = assertThrows(VegetableException.class,
                () -> vegetableList.addAll(10, Arrays.asList(tomato, cucumber, carrot)));
        assertEquals("Index out of range", exception.getMessage());
    }

    @Test
    void testRemoveAll() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));

        List<Vegetable> toRemove = Arrays.asList(tomato, carrot);
        assertTrue(vegetableList.removeAll(toRemove));
        assertFalse(vegetableList.contains(tomato));
        assertFalse(vegetableList.contains(carrot));
    }

    @Test
    void testRetainAll() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));

        List<Vegetable> toRetain = Arrays.asList(tomato, carrot);
        assertTrue(vegetableList.retainAll(toRetain));
        assertTrue(vegetableList.contains(tomato));
        assertFalse(vegetableList.contains(cucumber));
    }

    @Test
    void testRetainAllNull() {
        Exception exception = assertThrows(VegetableException.class, () -> vegetableList.retainAll(null));
        assertEquals("Error while retaining all the elements in the list", exception.getMessage());
    }

    @Test
    void testClear() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));

        vegetableList.clear();
        assertTrue(vegetableList.isEmpty());
    }

    @Test
    void testGet() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));
        assertEquals(tomato, vegetableList.get(0));
        assertEquals(cucumber, vegetableList.get(1));
        assertEquals(carrot, vegetableList.get(2));
    }

    @Test
    void testGetInvalidIndex() {
        Exception exception = assertThrows(VegetableException.class, () -> vegetableList.get(10));
        assertEquals("Index out of range", exception.getMessage());
    }

    @Test
    void testSet() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));

        Tomato newTomato = new Tomato("newTomato", 25);
        assertEquals(tomato, vegetableList.set(0, newTomato));
        assertEquals(newTomato, vegetableList.get(0));
    }

    @Test
    void testSetInvalidIndex() {
        Exception exception = assertThrows(VegetableException.class, () -> vegetableList.set(10, tomato));
        assertEquals("Index out of range", exception.getMessage());
    }

    @Test
    void testAddAtIndex() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));

        Tomato newTomato = new Tomato("newTomato", 25);
        vegetableList.add(1, newTomato);

        assertEquals(newTomato, vegetableList.get(1));
        assertEquals(cucumber, vegetableList.get(2));
    }

    @Test
    void testAddAtIndexInvalidIndex() {
        Exception exception = assertThrows(VegetableException.class, () -> vegetableList.add(10, tomato));
        assertEquals("Index out of range", exception.getMessage());
    }

    @Test
    void testRemoveAtIndex() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));

        assertEquals(cucumber, vegetableList.remove(1));
        assertFalse(vegetableList.contains(cucumber));
    }

    @Test
    void testRemoveAtIndexInvalidIndex() {
        Exception exception = assertThrows(VegetableException.class, () -> vegetableList.remove(10));
        assertEquals("Index out of range", exception.getMessage());
    }

    @Test
    void testIndexOf() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));

        assertEquals(0, vegetableList.indexOf(tomato));
        assertEquals(1, vegetableList.indexOf(cucumber));
        assertEquals(2, vegetableList.indexOf(carrot));
    }

    @Test
    void testIndexOfNotInList() {
        assertEquals(-1, vegetableList.indexOf(tomato));
    }

    @Test
    void testLastIndexOf() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot, tomato));

        assertEquals(3, vegetableList.lastIndexOf(tomato));
    }

    @Test
    void testLastIndexOfNotInList() {
        assertEquals(-1, vegetableList.lastIndexOf(tomato));
    }

    @Test
    void testListIterator() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));

        var iterator = vegetableList.listIterator();
        assertTrue(iterator.hasNext());
        assertEquals(tomato, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(cucumber, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(carrot, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testListIteratorAtIndex() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));

        var iterator = vegetableList.listIterator(1);
        assertTrue(iterator.hasNext());
        assertEquals(cucumber, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(carrot, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testListIteratorInvalidIndex() {
        Exception exception = assertThrows(VegetableException.class, () -> vegetableList.listIterator(10));
        assertEquals("Index out of range", exception.getMessage());
    }

    @Test
    void testSubList() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber, carrot));

        List<Vegetable> subList = vegetableList.subList(1, 3);
        assertEquals(2, subList.size());
        assertEquals(cucumber, subList.get(0));
        assertEquals(carrot, subList.get(1));
    }

    @Test
    void testSubListInvalidIndex() {
        Exception exception = assertThrows(VegetableException.class, () -> vegetableList.subList(1, 10));
        assertEquals("Index out of range", exception.getMessage());
    }

    @Test
    void testToString() {
        vegetableList.addAll(Arrays.asList(tomato, cucumber));

        String expected = "Tomato - 20 calories, Cucumber - 15 calories";
        assertEquals(expected, vegetableList.toString());
    }
}
