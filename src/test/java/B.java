/**
 * Created by wangxiaomin03 on 17/6/27.
 */
public class B extends A {
    public static String b="B_static_field";
    public static final String s="B_final_static_field";
    private String bb="B_feild";
    static{
        System.out.println(b);
        System.out.println(s);
        b="bbbbb";
        System.out.println(b);
    }
    public B() {
        super();
        System.out.println("B construct");
        System.out.println(bb);
    }
    public static void main(String[] arg){
        System.out.println("start");
        B b=new B();
    }

}
