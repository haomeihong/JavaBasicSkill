package dp;

import java.util.*;

/**
 * Created by wangxiaomin03 on 17/8/1.
 * 题目
 * 一个数组长度N，需要计算x个长度为y的子数组的和的最大值（子数组不能重叠）。
 * 比如数组 [3,5,1,7,8,2,3,7,2,6,3] 计算2个长度为3的子数组的最大值 [7,8,2] + [7,2,6] = 17+15 = 32
 */
public class Solution {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        scanner.close();
        String[] vals = line.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : vals) {
            list.add(Integer.valueOf(s));
        }
        int result = fun(list, x, y);
        System.out.println(result);

    }

    public static int fun(List<Integer> list, int x, int y) {
        if (list == null || list.size() < x * y) {
            return -1;
        }
        int len = list.size() - y + 1;
        for (int i = 0; i < len; i++) {
            int v = 0;
            for (int j = i; j < i + y; j++) {
                v += list.get(j);
            }
            list.set(i, v);
        }
        int outLen = len - y * (x - 1);
        int[][] pointer = new int[outLen][x];
        int max = Integer.MIN_VALUE;

        //初始化
        for (int j = 0; j < outLen; j++) {
            int tempMax = 0;
            for (int i = 0; i < x; i++) {
                int pos = j + i * y;
                pointer[j][i] = pos;
                tempMax += list.get(pos);
            }
            if (tempMax > max) {
                max = tempMax;
            }
        }
        while (!isOver(pointer, y, len)) {
            next(pointer, y, len);
            int v = countMax(pointer, list);
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public static boolean isOver(int[][] arr, int y, int len) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j][arr[j].length - 1] < len - 1) {
                return false;
            }
            for (int i = 0; i < arr[j].length - 1; i++) {
                if (arr[j][i + 1] - arr[j][i] > y) {
                    return false;
                }

            }
        }
        return true;
    }

    public static void next(int[][] arr, int y, int len) {
        for (int j = 0; j < arr.length; j++) {

            if (arr[j][arr[j].length - 1] < len - 1) {
                arr[j][arr[j].length - 1] += 1;
                continue;
            }
            for (int i = arr[j].length - 1; i > 0; i--) {
                if (arr[j][i] - arr[j][i - 1] > y) {
                    arr[j][i - 1] += 1;
                    continue;
                }
            }
        }
    }

    public static int countMax(int[][] arr, List<Integer> list) {
        int result = Integer.MIN_VALUE;
        for (int j = 0; j < arr.length; j++) {
            int temp = 0;
            for (int pos : arr[j]) {
                temp += list.get(pos);
            }
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }


}
