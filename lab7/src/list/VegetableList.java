package list;

import exception.VegetableException;
import vegetable.Vegetable;

import java.util.*;

/**
 * Represents a typed collection implementing the List interface with a singly linked list structure.
 *
 * @param <E> the type of elements in this collection, must extend Vegetable
 */
public class VegetableList<E extends Vegetable> implements List<E> {
    private Node<E> head;
    private int size;

    /**
     * Constructs an empty VegetableList.
     */
    public VegetableList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Constructs a VegetableList containing the specified element.
     *
     * @param element the element to be added to the list
     */
    public VegetableList(E element) {
        this.head = new Node<>(element);
        this.size = 1;
    }

    /**
     * Constructs a VegetableList containing the elements of the specified collection.
     *
     * @param collection the collection whose elements are to be placed into this list
     */
    public VegetableList(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    /**
     * Node class representing a node in the linked list.
     *
     * @param <E> the type of elements in this collection
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        /**
         * Constructs a Node with the specified data.
         *
         * @param data the data to be stored in the node
         */
        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if the list contains no elements.
     *
     * @return True if the list contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if the list contains the specified element.
     *
     * @param o The element whose presence in the list is to be tested.
     * @return True if the list contains the specified element.
     * @throws VegetableException if an error occurs while checking if the list contains the element
     */
    @Override
    public boolean contains(Object o) {
        try {
            for (E element : this) {
                if (Objects.equals(o, element)) {
                    return true;
                }
            }
        } catch (Exception e) {
            throw new VegetableException("Error while checking if the list contains the element", e);
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            /**
             * Returns true if the iteration has more elements.
             *
             * @return True if the iteration has more elements, false otherwise.
             */
            @Override
            public boolean hasNext() {
                return current != null;
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return The next element in the iteration.
             * @throws VegetableException if the iteration has no more elements
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new VegetableException("No more elements in the list");
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Returns an array containing all the elements in this list in proper sequence.
     *
     * @return an array containing all the elements in this list in proper sequence
     * @throws VegetableException if an error occurs while converting the list to array
     */
    @Override
    public Object[] toArray() {
        try {
            Object[] array = new Object[size];
            int index = 0;
            for (E element : this) {
                array[index++] = element;
            }
            return array;
        } catch (Exception e) {
            throw new VegetableException("Error while converting the list to array", e);
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new VegetableException("Not supported");
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param element the element to be added
     * @return Always returns true
     * @throws VegetableException if an error occurs while adding the element
     */
    @Override
    public boolean add(E element) {
        if (element == null) {
            throw new VegetableException("Cannot add null element to the list");
        }
        try {
            if (head == null) {
                head = new Node<>(element);
            } else {
                Node<E> lastNode = getLastNode();
                lastNode.next = new Node<>(element);
            }
            size++;
            return true;
        } catch (Exception e) {
            throw new VegetableException("Error while adding the element", e);
        }
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     * @throws VegetableException if an error occurs while removing the element
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new VegetableException("Cannot remove null element from the list");
        }
        try {
            if (head == null) {
                return false;
            }

            if (Objects.equals(o, head.data)) {
                head = head.next;
                size--;
                return true;
            }

            Node<E> current = head;
            while (current.next != null) {
                if (Objects.equals(o, current.next.data)) {
                    current.next = current.next.next;
                    size--;
                    return true;
                }
                current = current.next;
            }
        } catch (Exception e) {
            throw new VegetableException("Error while removing the element", e);
        }
        return false;
    }

    /**
     * Returns {@code true} if this list contains all the elements of the specified collection.
     *
     * @param c collection to be checked for containment in this list
     * @return {@code true} if this list contains all the elements of the specified collection
     * @throws VegetableException if an error occurs while checking if the list contains all the elements
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            for (Object element : c) {
                if (!contains(element)) {
                    return false;
                }
            }
        } catch (Exception e) {
            throw new VegetableException("Error while checking if the list contains all elements of the collection", e);
        }
        return true;
    }

    /**
     * Adds all the elements in the specified collection to the end of this list.
     *
     * @param c collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws VegetableException if an error occurs while adding all the elements
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            for (E element : c) {
                add(element);
            }
            return !c.isEmpty();
        } catch (Exception e) {
            throw new VegetableException("Error while adding all the elements of the collection", e);
        }
    }

    /**
     * Inserts all the elements in the specified collection into this list at the specified position.
     *
     * @param index index at which to insert the first element from the specified collection
     * @param c     collection containing elements to be added to this list
     * @return {@code true} if this list changed as a result of the call
     * @throws VegetableException if the index is out of range
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size) {
            throw new VegetableException("Index out of range");
        }

        Node<E> beforeIndex = getNodeAtIndex(index - 1);
        Node<E> afterIndex = beforeIndex != null ? beforeIndex.next : head;

        for (E element : c) {
            Node<E> newNode = new Node<>(element);
            if (beforeIndex != null) {
                beforeIndex.next = newNode;
            } else {
                head = newNode;
            }
            beforeIndex = newNode;
        }

        if (afterIndex != null) {
            beforeIndex.next = afterIndex;
        }

        size += c.size();
        return !c.isEmpty();
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection.
     *
     * @param c collection containing elements to be removed from this list
     * @return {@code true} if this list changed as a result of the call
     * @throws VegetableException if an error occurs while removing all the elements
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            boolean modified = false;
            for (int i = 0; i < size; i++) {
                Node<E> current = getNodeAtIndex(i);
                if (c.contains(current.data)) {
                    remove(i);
                    modified = true;
                    i--;
                }
            }
            return modified;
        } catch (Exception e) {
            throw new VegetableException("Error while removing all the elements from the list", e);
        }
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return True if this list changed as a result of the call
     * @throws VegetableException if an error occurs while retaining all the elements
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            if (c == null) {
                throw new VegetableException("Collection cannot be null");
            }

            boolean modified = false;
            for (int i = 0; i < size; i++) {
                Node<E> current = getNodeAtIndex(i);
                if (!c.contains(current.data)) {
                    remove(i);
                    modified = true;
                    i--;
                }
            }
            return modified;
        } catch (Exception e) {
            throw new VegetableException("Error while retaining all the elements in the list", e);
        }
    }


    /**
     * Removes all the elements from this list.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws VegetableException if the index is out of range
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new VegetableException("Index out of range");
        }

        Node<E> node = getNodeAtIndex(index);
        return node.data;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws VegetableException if the index is out of range
     */
    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new VegetableException("Index out of range");
        }

        Node<E> node = getNodeAtIndex(index);
        E oldValue = node.data;
        node.data = element;
        return oldValue;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws VegetableException if the index is out of range
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new VegetableException("Index out of range");
        }

        Node<E> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> beforeIndex = getNodeAtIndex(index - 1);
            newNode.next = beforeIndex.next;
            beforeIndex.next = newNode;
        }

        size++;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws VegetableException if the index is out of range
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new VegetableException("Index out of range");
        }

        Node<E> removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else {
            Node<E> beforeIndex = getNodeAtIndex(index - 1);
            removedNode = beforeIndex.next;
            beforeIndex.next = removedNode.next;
        }

        size--;
        return removedNode.data;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     * @throws VegetableException if an error occurs while getting the index of the specified element in list
     */
    @Override
    public int indexOf(Object o) {
        try {
            int index = 0;
            for (E element : this) {
                if (Objects.equals(o, element)) {
                    return index;
                }
                index++;
            }
        } catch (Exception e) {
            throw new VegetableException("Error while getting the index of the element in list", e);
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     * @throws VegetableException if an error occurs while getting the last index of the specified element in list
     */
    @Override
    public int lastIndexOf(Object o) {
        try {
            int index = 0;
            int lastIndex = -1;
            for (E element : this) {
                if (Objects.equals(o, element)) {
                    lastIndex = index;
                }
                index++;
            }
            return lastIndex;
        } catch (Exception e) {
            throw new VegetableException("Error while getting the last index of the specified element in list", e);
        }
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     *
     * @return a list iterator over the elements in this list (in proper sequence)
     */
    @Override
    public ListIterator<E> listIterator() {
        return new LinkedListIterator(0);
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence),
     * starting at the specified position in the list.
     *
     * @param index the starting position of the list iterator
     * @return a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list
     * @throws VegetableException if the index is out of range
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new VegetableException("Index out of range");
        }
        return new LinkedListIterator(index);
    }

    /**
     * Returns a view of the portion of this list between the specified {@code fromIndex}, inclusive,
     * and {@code toIndex}, exclusive.
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex   high endpoint (exclusive) of the subList
     * @return a view of the specified range within this    list
     * @throws VegetableException if indexes are out of range
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new VegetableException("Index out of range");
        }

        List<E> subList = new ArrayList<>();
        Node<E> current = getNodeAtIndex(fromIndex);

        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(current.data);
            current = current.next;
        }

        return subList;
    }

    /**
     * Returns the node at the specified index.
     *
     * @param index the index of the node to return
     * @return the node at the specified index
     * @throws VegetableException if the index is out of range
     */
    private Node<E> getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new VegetableException("Index out of range");
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Returns the last node in the list.
     *
     * @return the last node in the list
     */
    private Node<E> getLastNode() {
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    /**
     * Iterator implementation for the linked list.
     */
    private class LinkedListIterator implements ListIterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        /**
         * Constructs a new iterator starting at the specified index.
         *
         * @param index the starting index of the iterator
         * @throws VegetableException if the index is out of range
         */
        LinkedListIterator(int index) {
            if (index < 0 || index > size) {
                throw new VegetableException("Index out of range");
            }

            next = (index == size) ? null : getNodeAtIndex(index);
            nextIndex = index;
        }

        /**
         * Returns true if the iteration has more elements.
         *
         * @return True if the iteration has more elements, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        /**
         * Returns the next element in the iteration.
         * @return The next element in the iteration.
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }

        /**
         * Returns true if the iteration has more previous elements.
         *
         * @return True if the iteration has more previous elements, false otherwise.
         */
        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        /**
         * Returns the previous element in the iteration.
         * @return The previous element in the iteration.
         * @throws VegetableException if the iteration has no more elements
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new VegetableException("No more elements in the list");
            }
            lastReturned = (next == null) ? getLastNode() : getNodeAtIndex(nextIndex - 2);
            nextIndex--;
            next = lastReturned.next;
            return lastReturned.data;
        }

        /**
         * Returns the index of next element.
         * @return The index of next element.
         */
        @Override
        public int nextIndex() {
            return nextIndex;
        }

        /**
         * Returns the index of previous element.
         * @return The index of previous element.
         */
        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        /**
         * Removes from the list the last element that was returned by next() or previous().
         * @throws VegetableException if the last element is null
         */
        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new VegetableException("Error while removing the last element");
            }

            if (lastReturned == head) {
                head = head.next;
                next = head;
            } else {
                Node<E> beforeLastReturned = getNodeAtIndex(nextIndex - 2);
                beforeLastReturned.next = lastReturned.next;
                next = beforeLastReturned.next;
            }

            size--;
            lastReturned = null;
        }

        /**
         * Replaces the last element with the specified element.
         * @param e the element with which to replace the last element
         * @throws VegetableException if the last element is null
         */
        @Override
        public void set(E e) {
            if (lastReturned == null) {
                throw new VegetableException("Error while replacing the last element");
            }
            lastReturned.data = e;
        }

        /**
         * Inserts the specified element into the list.
         * @param e the element to insert
         */
        @Override
        public void add(E e) {
            Node<E> newNode = new Node<>(e);
            if (lastReturned == null) {
                newNode.next = head;
                head = newNode;
                next = head;
            } else {
                newNode.next = lastReturned.next;
                lastReturned.next = newNode;
                next = newNode;
            }

            size++;
            lastReturned = null;
            nextIndex++;
        }
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        return result.toString();
    }
}