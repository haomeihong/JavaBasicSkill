package diff;

/**
 * Created by wangxiaomin03 on 17/6/28.
 */
public class B {

    public void close() throws Exception{
        System.out.println("closing");
        throw new Exception("testException");
    }
    @SuppressWarnings("unused")
   private final Object o=new Object(){
       @Override
       protected void finalize() throws Throwable {
           close();
           super.finalize();
       }
   };
}
