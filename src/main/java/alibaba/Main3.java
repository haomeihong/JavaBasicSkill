package alibaba;

/**
 * Created by wangxiaomin03 on 17/8/2.
 * 题目
 * 金条划分成不同n份，每次割分收取金条长度的费用，求最小总费用
 */

import java.util.*;

public class Main3 {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static int cut(Integer[] parts) {
        if (parts == null) {
            return -1;
        }
        if (parts.length == 0) {
            return 0;
        }
        List<Integer> list = Arrays.asList(parts);
        int len = parts.length;
        String s = Integer.toBinaryString(len);
        String s1 = s.substring(1);
        if (s1.equals("")) {
            s1 = "0";
        }
        int other = Integer.valueOf(s1, 2);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Integer sum = 0;
        for (Integer v : list) {
            sum += v;
        }
        int slen = s.length();
        int result = sum * (slen - 1);
        for (int i = 0; i < other; i++) {
            result += list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine().trim());
        Integer[] parts = new Integer[pieces];
        for (int i = 0; i < pieces; i++) {
            parts[i] = Integer.parseInt(in.nextLine().trim());
        }
        System.out.println(cut(parts));
    }
}
