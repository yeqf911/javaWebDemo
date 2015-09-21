package reflect;

import java.awt.datatransfer.StringSelection;

/**
 * Created by yeqf on 2015/9/19.
 */
public class Person {

    public static String name = "aaa";
    public int age;
    public String password;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person() {
        System.out.println("person");
    }

    public Person(String name) {
        System.out.println("person name");
    }

    public Person(String name, int age) {
        System.out.println("person name age");
    }

    private Person(int passwd) {
        System.out.println(passwd);
    }

    public void aa() {
        System.out.println("aa");
    }

    public void aa(String name) {
        System.out.println("aa name");
    }

    public Class[] aa(String name, int age) {
        System.out.println("aa name age");
        return new Class[]{StringSelection.class};
    }

    private int aa(int age) {
        System.out.println("aa age");
        return 911;
    }

    public static void aa(String name, int age, int as) {
        System.out.println("static aa name age as");
    }

    public static void main(String[] args) {
        System.out.println("main!");
    }

    public  String getName() {
        return name;
    }

    public  void setName(String name) {
        Person.name = name;
    }
}
