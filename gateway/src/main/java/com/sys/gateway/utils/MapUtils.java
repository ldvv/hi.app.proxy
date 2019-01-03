package com.sys.gateway.utils;

import java.util.*;

public class MapUtils {

    /**
     * Map 按照value降序排序
     *
     * @param map 需要排序的Map
     * @return 排序结果
     *
     * @auth LD
     * @Create date 2018-12-28
     * */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDesc(Map<K, V> map){
        if (map == null || map.isEmpty()) {
            return null;
        }

        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>(){
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return -compare;
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


    /**
     * Map 按照value升序排序
     *
     * @param map 需要排序的Map
     * @return 排序结果
     *
     * @auth LD
     * @Create date 2018-12-28
     * */
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueAsc(Map<K, V> map){
        if (map == null || map.isEmpty()) {
            return null;
        }

        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>(){
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                int compare = (o1.getValue()).compareTo(o2.getValue());
                return compare;
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    /**
     * Map 按照key升序排序
     *
     * @param map 需要排序的Map
     * @return 排序结果
     *
     * @auth LD
     * @Create date 2018-12-28
     * */
    /*public static <K, V extends Comparable<? super V>> Map<K, V> sortByKeyAsc(Map<K, V> map){
        if (map == null || map.isEmpty()) {
            return null;
        }

        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>(){
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                int compare = (o1.getKey()).compareTo(o2.getKey());
                return compare;
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }*/
}
