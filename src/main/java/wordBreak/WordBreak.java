package wordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangxiaomin03 on 17/8/7.
 * 题目
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * For example, given
 * s ="catsanddog",
 * dict =["cat", "cats", "and", "sand", "dog"].
 * A solution is["cats and dog", "cat sand dog"].
 */
public class WordBreak {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.isEmpty() || dict == null || dict.size() == 0) {
            return result;
        }
        String target = s.trim();
        int len = target.length();
        String[][] arr = new String[len][len];
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                String s1 = target.substring(i, j + 1);
//                if (dict.contains(s1)) {
//                    arr[i][j] = s1;
//                }
//            }
//        }
        for (int i = 0; i < len; i++) {
            String all = target.substring(0, i + 1);
            if (dict.contains(all)) {
                arr[0][i] = all;
            }
            for (int j = 0; j < i; j++) {

                String tr1 = target.substring(j + 1, i + 1);
                if (dict.contains(tr1)) {
                    arr[j + 1][i] = tr1;
                }
                if (arr[0][j] != null && arr[j + 1][i] != null) {
                    String[] temp = arr[0][j].split(";");
                    String curr = "";
                    for (String s1 : temp) {
                        if (s1.isEmpty()) {
                            continue;
                        }
                        curr += s1 + " " + arr[j + 1][i] + ";";
                    }
                    curr = curr.substring(0, curr.length() - 1);
                    if (arr[0][i] == null) {
                        arr[0][i] = curr;
                    } else {
                        arr[0][i] += ";" + curr;
                    }
                }
            }
        }
        String ss = arr[0][len - 1];
        if (ss == null) {
            return result;
        }
        String[] rsult = ss.split(";");
        for (String r : rsult) {
            if (r.isEmpty()) {
                continue;
            }
            result.add(r);
        }

        return result;
    }


    public static void main(String[] arg) {
        String s = "aaaaaaa";
        Set<String> dict = new HashSet<>();
        dict.add("aaaa");
        dict.add("aa");
        dict.add("a");
//        dict.add("sand");
//        dict.add("dog");
        ArrayList<String> result = wordBreak(s, dict);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
