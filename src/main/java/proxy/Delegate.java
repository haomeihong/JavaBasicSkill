package proxy;


/**
 * Created by wangxiaomin03 on 17/7/28.
 */
public class Delegate extends AbstractC implements HasValue, HasName {
    private String name = this.getClass().getName();
    private int value = 12345;

    @Override
    public int callValue() {
        return this.value;
    }

    @Override
    public String callName() {
        return this.name;
    }

    @Override
    public void doSomething() {
        System.out.println("doing something???????");
    }
}
