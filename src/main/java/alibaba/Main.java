package alibaba;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by wangxiaomin03 on 17/4/26.
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String pattern=scanner.nextLine();
        scanner.close();
        int result=filter(s,pattern);
        System.out.println(result);

    }
    public static int filter(String s,String pattern){
        if(s==null||pattern==null||s.equals("")||pattern.equals("")){
            return 0;
        }
        pattern=pattern.replace("*",".*");
        pattern=pattern.replace("?",".");
        return Pattern.matches("$"+pattern+"^",s)?1:0;
    }
}
