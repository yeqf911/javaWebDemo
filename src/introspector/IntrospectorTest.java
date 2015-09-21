package introspector;

import org.junit.Test;
import reflect.Person;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by yeqf on 2015/9/20.
 */
public class IntrospectorTest {

    @Test
    public void test1() throws Exception {
        BeanInfo info = Introspector.getBeanInfo(Person.class, Object.class);
        PropertyDescriptor[] pds = info.getPropertyDescriptors();
        for (PropertyDescriptor bd : pds) {
            System.out.println(bd.getName());
        }
    }

    /**
     * 操作bean的属性age和name
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        //BeanInfo info = Introspector.getBeanInfo(Person.class);
        Person p = new Person();
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        Method method = pd.getWriteMethod();
        method.invoke(p, 13);
        //获取属性的值
        System.out.println(pd.getReadMethod().invoke(p));
        System.out.println(p.getAge());

        PropertyDescriptor dps = new PropertyDescriptor("name", Person.class);
        Method method1 = dps.getWriteMethod();
        method1.invoke(p, "yeqianfeng");
        System.out.println(p.getName());
    }

    /**
     * 得到属性的类型
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        PropertyDescriptor dps = new PropertyDescriptor("age", Person.class);
        System.out.println(dps.getPropertyType());
    }
}
