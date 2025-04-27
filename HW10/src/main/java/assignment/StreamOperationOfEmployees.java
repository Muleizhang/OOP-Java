package assignment;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperationOfEmployees {
    public static void main(String[] args) {
        List<Employee> employeesList = getListOfEmployees();

        // 在此处编写你的Stream代码（替换以下注释）// 任务1-7的代码需依次编写在此处
//1. Given a list of employees, you need to find all the employees whose age is greater than 30 and print the employee names.
        employeesList.stream().filter(e -> e.getAge() > 30).map(Employee::getName).forEach(System.out::println);
        System.out.println();

//2. Given the list of employees, find the count of employees with age greater than 25?
        System.out.println(employeesList.stream().filter(e -> e.getAge() > 25).count());
        System.out.println();

//3. Given the list of employees, find the employee whose name is John.
        employeesList.stream().filter(e -> Objects.equals(e.getName(), "John")).forEach(System.out::println);
        System.out.println();

//4.Given a list of employees, You need to find the highest age of employee?
        System.out.println(employeesList.stream().map(Employee::getAge).max(Integer::compareTo).orElse(0));
        System.out.println();

//5. Given a list of employees, you need sort employee list by age?
        System.out.println(employeesList.stream().sorted(Comparator.comparingInt(Employee::getAge)).collect(Collectors.toList()));
        System.out.println();

//6. Given the list of Employees, you need to join the all employee names with ","?
        System.out.println(employeesList.stream().map(Employee::getName).collect(Collectors.joining(",")));
        System.out.println();

//7. Given the list of employees, you need to group them by name
        employeesList.stream().collect(Collectors.groupingBy(Employee::getName))
                .forEach((name, empList) -> System.out.println(name + ":\n" + empList));
    }

    public static List<Employee> getListOfEmployees() {
        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new Employee("Tom", 24, Arrays.asList("NewYork", "Washington")));
        listOfEmployees.add(new Employee("John", 27, Arrays.asList("Paris", "London")));
        listOfEmployees.add(new Employee("Jerry", 32, Arrays.asList("LosAngles", "Seattle")));
        listOfEmployees.add(new Employee("Amit", 22, Arrays.asList("Beijing", "Shanghai")));
        listOfEmployees.add(new Employee("Amit", 24, Arrays.asList("Shanghai", "Wuhan")));
        return listOfEmployees;
    }
}