import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Optional;
import java.util.TreeSet;

public class TimeMap {
    HashMap<String, TreeSet<Pair>> map = new HashMap<>();

    private class Pair implements Comparable{
        String value;
        int timeStamp;

        public Pair(int timeStamp, String value){
            this.value =  value;
            this.timeStamp = timeStamp;
        }

        @Override
        public int compareTo(Object o) {
            Pair other = (Pair) o;
            return other.timeStamp - this.timeStamp;
        }
    }

    public TimeMap(){
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeSet<Pair> set = map.getOrDefault(key, new TreeSet<>());
        set.add(new Pair(timestamp, value));
        map.put(key, set);
    }

    public String get(String key, int timestamp) {
        TreeSet<Pair> set = map.get(key);
        if (set != null){
            Optional<Pair> y = set.stream().filter(x -> x.timeStamp <= timestamp).findFirst();
            if (!y.isPresent()) return "";
            return y.get().value;
        } else {
            return "";
        }


    }

    public static void main(String[] args) {
        TimeMap tm = new TimeMap();
        tm.set("d", "abbf5", 5);
        tm.set("d", "abbf3", 3);
        tm.set("d", "abbf4", 4);
        tm.set("a", "bdf", 2);
        tm.set("e", "adsff", 3);
        tm.set("z", "aesdf", 2);
        tm.set("d", "addf0", 1);
        tm.set("d", "addf10", 10);
        System.out.println(tm.get("d", 3));
        System.out.println(tm.get("d", 0));
    }



}
