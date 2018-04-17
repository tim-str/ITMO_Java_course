package classworks;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

public class MapExample {


// interface Map
//    В контейнерах Map хранятся 2 объекта: ключ и значение
//    Ключи должны быть уникальны, значения могут дублироваться
//    Существует возможность искать объекты по ключу

//    interface SortedMap - элементы размещаются по возрастанию ключей
//    interface NavigableMap  - расширяет SortedMap
//    Map.Entry позволяет работать с элементами map

//    HashMap - структура данных для хранения пары ключ - значение,
//    Ключи и значения могут быть лубого типа, даже null
//    Нет гарантий  относительно неизменности порядка элементов.
//    Разрешение коллизий осуществляется методом цепочек

//    TreeMap коллекция с отсортированными ключами
//    LinkedMap - запоминается порядок, в котором добавлялись элементы
//    WeakHashMap - значения могут удаляться сборщиком мусора,
//    если они не используются
//    IdentityHashMap - ключи сравниваются с помощью ==, вместо equals

//    interface Map<K, V>

//    методы
//    void clear() удаляет все пары ключ - значение
//    boolean containsKey(Object key)
//    boolean containsValue(Object val)
//    boolean equals(Object obj)
//        true, если obj - это map, который содержит одинаковые значения
//    boolean isEmpty()
//    put(key, val)
//    putAll()
//    remove(key)
//    int size()
//    get(key)

//    Интерфейс map предоставляет три способа для доступа к данным,
//    используя:
//    set из ключей (метод getKey)
//    коллекцию из значений (метод getValues)
//    set из пары ключ-значение (entrySet)

    //    for (Map.Entry entry: mapName.entrySet()){
//        System.out.println(entry.getKey() + " : " + entry.getValue());
//    }
    final static Map<String, String> finalMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        finalMap.put("90", "90val");
        finalMap.put("9777", "9777val");
        System.out.println(finalMap.get("9777"));

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("key", "value");
        hashMap.put(null, "value");
        hashMap.put(null, "value1");

        System.out.println(hashMap.get(null));

        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() +
                    " : " + entry.getValue());
        }

//        TreeMap - для хранения элементов применяет
//        красно-черное дерево
//        Объекты сохраняются в отсортированном порядке:
//        ключи по возрастанию

        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("2", "value1");
        treeMap.put("bkey", "value2");
        treeMap.put("akey", "value3");
//        treeMap.put(null, "value4");
        for (Map.Entry entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() +
                    " : " + entry.getValue());
        }

//        TreeMap();
//        TreeMap(Comparator comp)
//        TreeMap(Map m)
//        TreeMap(SortedMap sortm)

//        class CustCompr implements Comparable{
//
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }

//        LinkedHashMap - расширяет HashMap
//        порядок хранения элементов определяется порядком установки

        Map<String, String> lnkMap = new LinkedHashMap<>();
        lnkMap.put("333", "value1");
        lnkMap.put("key", "value3");
        lnkMap.put(null, "value4");
        for (Map.Entry entry : lnkMap.entrySet()) {
            System.out.println(entry.getKey() +
                    " : " + entry.getValue());
        }

        Map<Integer, String> newMap = new HashMap<>();
        newMap.put(1, "rwrw");
        newMap.put(2, "rwrw");
        newMap.put(6, "rwrw");
        newMap.put(12, "rwrw");
        Map<Integer, String> newMap2 = Collections.unmodifiableMap(newMap);

        for (Map.Entry entry : newMap2.entrySet()) {
            System.out.println(entry.getKey() +
                    " : " + entry.getValue());

        }

//        newMap2.put(45, "rgfdsrf");

    }
}


//    1. создать map, которую нельзя изменить



