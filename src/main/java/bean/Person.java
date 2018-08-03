package bean;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Person {
    private String name;
    private int age;
/*
*
*
* */
/*
*
*/
/*
*
**/
/*
*asd
* sad
* asd
**/


    public String getName() {
        int i1 = 10;
        System.out.println("i1 = " + i1);
        int i2 = 20;
        System.out.println("i2 = " + i2);
        String[] strings = {"aa", "bb", "cc"};
        for (String string : strings) {
            System.out.println("string = " + string);
        }
        List list = Arrays.asList(strings);
        for (Object o : list) {
            System.out.println("o = " + o);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println("i = " + i);
        }
        if (list != null) {
        }
        if (list == null) {
        }
        if (list != null) {
        }
        if (list == null) {
        }
        if (list != null) {
        }
        return name;
    }

    public int getAge() {
        return age;
    }
}
