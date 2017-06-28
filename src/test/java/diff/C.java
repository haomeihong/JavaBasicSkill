package diff;

/**
 * Created by wangxiaomin03 on 17/6/28.
 */
public class C extends B{
    public static void main(String[] arg) {
        {
//            B b = new B();
            //{}外不可见，但此时不回收
            C c=new C();
            c.fun();
        }
        fun();
        try {
            System.gc();
            Thread.sleep(6000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("测试结束");
    }
    public static void fun(){
        C c =new C();
        System.out.println("do something");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("CCCCCCC");
    }

}
