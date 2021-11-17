package lesson8;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
//        int x = Integer.MIN_VALUE;
//        System.out.println(x);
//        System.out.println(Math.abs(x));

//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(5, 99999999); // положили
//        System.out.println(map.get(5)); // распечатали
//        map.put(5, 7777777);
//        System.out.println(map.get(5));

//        ChainingHashMap<Integer, String> map = new ChainingHashMap<>(7);
//        for (int i = 0; i < 7 ; i++) {
//            map.put(random.nextInt(100),"a");
//        }
//        System.out.println(map);

//        LinearProbingHashMap<Integer, String> lphm = new LinearProbingHashMap<>(7);
//        lphm.put(5, "qwe");
//        lphm.put(15, "qweerwer");
//        System.out.println(lphm.get(15));

        ChainingHashMap<Integer, String> map = new ChainingHashMap<>(10);
        map.put(1,"one");
        map.put(2,"two");
        map.put(12,"12");
        map.put(15,"15");

        System.out.println(map);
        System.out.println("map.get(155): " + map.get(155));
        System.out.println("map.Delete(2): " + map.Delete(2));
        System.out.println(map);
    }
}
