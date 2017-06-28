package diff;

import java.util.Date;

/**
 * Created by wangxiaomin03 on 17/6/28.
 * 区别Long和long
 * long 的效率比Long高
 * 创建实例的代价比较高
 */
public class A {
    public static void main(String[] args){
        Date start=new Date();
        long sum=0L;
//        Long sum=0L;
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum+=1;
        }
        System.out.println(sum);
        System.out.println("花费时间:"+(new Date().getTime()-start.getTime())/1000.0);

    }
}
