/**
 * Created by wangxiaomin03 on 17/6/27.
 */
public class A {
    public static String a="A_static_field";
    public final static String s="A_final_static_field";
    static{
        System.out.println(a);
        System.out.println(s);
        a="aaaa";
//        s="sssss";
        System.out.println(a);

    }
    private String aa="A_filed";
    private String b;
    public A(){
        System.out.println("A_construct");
        System.out.println(aa);
        System.out.println(b);
    }
    static {
        System.out.println("after A");
    }
}
