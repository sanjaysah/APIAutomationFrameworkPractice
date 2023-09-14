package com.thetestingacademy.tests.practice;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExample {
    public static void main(String[] args) {
        String response_Name = "Sanjay";
        assertThat(response_Name).isNotNull().isNotBlank().isEqualTo("Sanjay");

        List<String> names = Arrays.asList("Joe", "Jenna", "Jackson");
        assertThat(names).hasSize(3).contains("Joe").doesNotContain("Sanjay");

        Person person1 = new Person("Sanjay", 39);
        assertThat(person1).hasFieldOrPropertyWithValue("name","Sanjay")
                .hasFieldOrProperty("age");

        LocalDate date = LocalDate.now();
        assertThat(date).isAfterOrEqualTo(LocalDate.of(2023,01,01))
                .isBeforeOrEqualTo(LocalDate.of(2024,07,16))
                .isBetween(
                        LocalDate.of(2023,01,01),
                        LocalDate.of(2024,07,16)
                );

        File file = new File("TestData.json");
        assertThat(file).exists().isFile().canRead();
    }

    static class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
