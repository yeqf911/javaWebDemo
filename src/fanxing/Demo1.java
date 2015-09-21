package fanxing;

import java.util.*;

/**
 * Created by yeqf on 2015/9/21.
 */
public class Demo1 {

    @org.junit.Test
    public void test1() {
        /**
         * 此处用LinkedHashMap是为了让存储的时候按顺序村存储
         */
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "aa");
        map.put(2, "bb");
        map.put(3, "cc");

        /**
         * 获得Map集合的每个实体，用Set集合存储
         */
        Set<Map.Entry<Integer, String>> set = map.entrySet();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry);
        }

        //迭代器
        Iterator<Map.Entry<Integer, String>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }

}
