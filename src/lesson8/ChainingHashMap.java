package lesson8;

import java.util.LinkedList;

import static javax.swing.UIManager.get;

public class ChainingHashMap<K, V> {
    private int capacity;  // список массивов.
    private int size;  // размер
    private LinkedList<Node>[] st;  // массив в котором хранятся узлы


    public ChainingHashMap(int capacity) {
        if (capacity <= 0) {  // проверка
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        st = new LinkedList[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }

    // внутрнний класс узел
    private class Node {
        K key;  // ключ
        V value;  // значение

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // метод получения размера.
    public int size() {
        return size;
    }

    // метод будет возращать 0 если размер равен 0
    public boolean isEmpty() {
        return size == 0;
    }


    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    // метод проверки
    public boolean contains(K key) {
        return get(key) != null;
    }

    public void checkKeyNotNull(K key) {
        if (key == null) {  // будем считать что в качестве ключа null использовать нельзя
            throw new IllegalArgumentException();
        }
    }

    // Метод вставки
    public void put(K key, V value) {
        checkKeyNotNull(key);  // проверка ключа
        int i = hash(key);  // нашли багет
        for (Node node : st[i]) { // мы по i элементу по всем его узлам пройдемся в нашем массиве i
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;  // увеличиваем размер
    }

    // Метод получения
    public V get(K key) {
        checkKeyNotNull(key);  // проверка ключа
        int i = hash(key);  // нашли багет
        for (Node node : st[i]) { // мы по i элементу по всем его узлам пройдемся в нашем массиве i
            if (key.equals(node.key)) {
                return node.value;  //вернем у этого узла значение.
            }
        }
        return null;
    }

    public V Delete(K key) {
        checkKeyNotNull(key);  // проверка ключа
        int i = hash(key);  // нашли багет
        for (int j = 0; j < st[i].size(); j++) {
            if (key.equals(st[i].get(j).key)){
                Node temp = st[i].get(j);
                st[i].remove(st[i].get(j));
                size--;
                return  temp.value;
            }
        }
        return null;
    }

    // неправельный toString, который покажет что там внутри твориться.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {  // пройдемся по всем ячейкам нашего capacity
            for (Node node : st[i]) {
                //               sb.append(node.key).append(" = ").append(node.value).append(" "); // собрали то что в одном багете находиться в одну строку
                sb.append(node.key).append(" ");
            }
            sb.append(System.lineSeparator());

        }
        return sb.toString();
    }


}
