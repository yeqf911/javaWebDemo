import org.junit.Test;

/**
 * Created by yeqf on 2015/9/19.
 */
public class Enumeration {

    @Test
    public void test() {
        print(Grade.A);
    }

    @Test
    public void test2() {
        System.out.println(Grade.A.name());
        System.out.println(Grade.C.ordinal());
        String str = "B";
        Grade g = Grade.valueOf(str);
        System.out.println(g);

        Grade[] grades = Grade.values();
        for (Grade ga : grades) {
            System.out.println(ga.name());
        }
    }

    public void print(Grade grade) {
        System.out.println(grade.getValue());
        System.out.println(grade.localvalue());

    }

    enum Grade {
        A("100-90") {
            @Override
            public String localvalue() {
                return "优";
            }
        },
        B("100-90") {
            @Override
            public String localvalue() {
                return "良";
            }
        },
        C("100-90") {
            @Override
            public String localvalue() {
                return "中等";
            }
        },
        D("100-90") {
            @Override
            public String localvalue() {
                return "差";
            }
        },
        E("100-90") {
            @Override
            public String localvalue() {
                return "不及格";
            }
        };

        private String value;

        Grade(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public abstract String localvalue();
    }
}
