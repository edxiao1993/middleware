package org.kevin.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author Kevin.Zng
 * @date 2022/6/15 21:00
 */
public class Solution {

    static class Employee {

        private String name;

        private int salary;

        private String department;

        public Employee(String name, int salary, String department) {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("salary=" + salary)
                    .add("department='" + department + "'")
                    .toString();
        }
    }

    // 1、 获取所有姓名 List<String>
    static List<String> m1(List<Employee> employees) {
        return employees.stream().map(e -> e.name).collect(Collectors.toList());
    }

    // 2、 获取所有姓名并排序  List<String>
    static List<String> m2(List<Employee> employees) {
        return employees.stream().map(e -> e.name).sorted().collect(Collectors.toList());
    }

    // 3、 获取所有姓名并使用逗号拼接  zhangsan,lisi,wangwu
    static String m3(List<Employee> employees) {
        return employees.stream().map(e -> e.name).collect(Collectors.joining(","));
    }

    // 4、 计算所有员工薪资的和
    static int m4(List<Employee> employees) {
        return employees.stream().mapToInt(e -> e.salary).sum();
    }

    // 5、 根据部门对员工分组
    static Map<String, List<Employee>> m5(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(e -> e.department));
    }

    // 6、 计算每个部门员工薪资总和  Map<String, Integer>
    static Map<String, Integer> m6(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(e -> e.department, Collectors.summingInt(e -> e.salary)));
    }

    /**
     * 7、对工资进行分档
     * 1：低于1500；
     * 2：大于等于1500且小于等于2000；
     * 3：大于2000
     */
    static Map<Integer, List<Employee>> m7(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(e -> {
            if (e.salary < 1500) {
                return 1;
            } else if (e.salary < 2000) {
                return 2;
            } else {
                return 3;
            }
        }));
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("zhangsan", 1850, "iot");
        Employee e2 = new Employee("lisi", 1460, "welink");
        Employee e3 = new Employee("wangwu", 2100, "iot");

        List<Employee> employees = Arrays.asList(e1, e2, e3);
        System.out.println(m1(employees));
        System.out.println(m2(employees));
        System.out.println(m3(employees));
        System.out.println(m4(employees));
        System.out.println(m5(employees));
        System.out.println(m6(employees));
        System.out.println(m7(employees));
    }
}