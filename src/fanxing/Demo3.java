package fanxing;

/**
 * Created by yeqf on 2015/9/21.
 */

/**
 * 在类上声明的泛型作用于整个类范围，除了静态方法
 *
 * @param <T>
 * @param <K>
 * @param <V>
 */
public class Demo3<T, K, V> {

    public T test1(T t) {
        return t;
    }

    public void test2(T t, K k, V v) {
    }

    /**
     * 静态方法的泛型参数要单独声明
     * @param t
     * @param <T>
     */
    public static <T> void test3(T t) {
    }
}
