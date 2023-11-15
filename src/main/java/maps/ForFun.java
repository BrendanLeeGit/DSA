package maps;

import java.util.TreeMap;

public class ForFun {
    public static void main(String[] args){
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "poo");
        System.out.println(treeMap.get(5));
        System.out.println(treeMap);
    }
}
