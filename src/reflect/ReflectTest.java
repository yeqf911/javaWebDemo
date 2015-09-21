package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by yeqf on 2015/9/19.
 */
public class ReflectTest {

    @Test
    public void test() throws Exception {
        Class clazz = Class.forName("reflect.Person");
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Person person = (Person) constructor.newInstance("xoaming", 15);
        System.out.println(person.name);
    }


    @Test
    public void test1() throws Exception {
        Class clazz = Class.forName("reflect.Person");
        Constructor constructor = clazz.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Person person = (Person) constructor.newInstance(15);
        System.out.println(person.name);
    }

    @Test
    public void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("reflect.Person");
        Person person = (Person) clazz.newInstance();
        System.out.println(person);
    }

    @Test
    public void test4() throws Exception {
        Class clazz = Class.forName("reflect.Person");
        Method method = clazz.getMethod("aa", null);
        method.invoke(clazz.getConstructor().newInstance(), null);
    }

    @Test
    public void test5() throws Exception {
        Class clazz = Class.forName("reflect.Person");
        Method method = clazz.getMethod("aa", null);
        method.invoke(clazz.getConstructor().newInstance(), null);
    }

    @Test
    public void test6() throws Exception {
        Class clazz = Class.forName("reflect.Person");
        Method method = clazz.getMethod("aa", String.class, int.class);
        method.invoke(clazz.getConstructor().newInstance(), "xiaoming", 14);
    }


    @Test
    public void test7() throws Exception {
        Class clazz = Class.forName("reflect.Person");
        Method method = clazz.getDeclaredMethod("aa", int.class);
        method.setAccessible(true);
        method.invoke(new Person(), 15);
    }

    @Test
    public void test8() throws Exception {
        Class clazz = Class.forName("reflect.Person");
        Method method = clazz.getMethod("aa", String.class, int.class, int.class);
        method.invoke(null, "dsafas", 13, 44);
    }

    @Test
    public void test9() throws Exception {
        Class clazz = Class.forName("reflect.Person");
        Method method = clazz.getMethod("main", String[].class);
        method.invoke(null, (Object) new String[]{"gtt", "dsad"});
    }

}
