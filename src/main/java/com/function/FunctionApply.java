package com.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * R apply(T t)
 * T is Function argument, R is the result.
 */


public class FunctionApply {

    static class Student {

        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;

        }

        public String customShow(Function<Student, String> fun) {
            return fun.apply(this);
        }
    }

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        list.add(new Student("A", 1));
        list.add(new Student("B", 2));
        list.add(new Student("C", 3));

        // 함수를 간단히 사용
        System.out.println("\n\n함수를 간단히 사용\n\n");

        for(Student st : list) {
            System.out.println(st.customShow(s->s.name + ": " + s.age));
        }

        // 첫번째 함수 스타일
        System.out.println("\n\n첫번째 함수 스타일\n\n");

        Function<Student, String> styleOne  = s->{
            String result = "Name:"+s.name + " and Age:" + s.age;
            return result;
        };

        for(Student st : list) {
            System.out.println(st.customShow(styleOne));
        }


        // 두번째 함수 스타일
        System.out.println("\n\n두번째 함수 스타일\n\n");

        Function<Student, String> styleTwo = s->"Name:"+s.name + " and Age:" + s.age;

        for(Student st : list) {
            System.out.println(st.customShow(styleOne));
        }
    }

}

