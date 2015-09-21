package fanxing;

/**
 * Created by yeqf on 2015/9/21.
 */
public class Demo2 {

    /**
     * @param t
     * @param <T> 方法上泛型的声明
     *           返回也可以是泛型
     *  这里不用Object的原因是因为返回时不用强转类型。
     */
    public <T> T  test1(T t) {
        return t;
    }


    /**
     * 可以同时声明多个泛型
     * @param t
     * @param k
     * @param v
     * @param <T>
     * @param <K>
     * @param <V>
     */
    public <T,K,V> void test2(T t, K k, V v) {

    }
}
