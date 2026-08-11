package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Definition
 * List<Employee> l1 // have employee id and name
 * List<Employee> l2 // have employee department
 * List<Employee> l2 // have employee salary
 * List<Employee> combinedList //add all 3 list into one
 * */

class Employee{
    private int id;
    private String name;
    private String department;
    private Long salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class ThreeListIntoOne {
    public static void main(String[] args) {
        List<Employee> l1 = new ArrayList<>(){{
            Employee employee  = new Employee();
            employee.setId(1);
            employee.setName("test");
            add(employee);
        }};

        List<Employee> l2 = new ArrayList<>(){{
            Employee employee  = new Employee();
            employee.setId(1);
            employee.setDepartment("Eng");
            add(employee);
        }};

        List<Employee> l3 = new ArrayList<>(){{
            Employee employee  = new Employee();
            employee.setId(1);
            employee.setSalary(140000L);
            add(employee);
        }};

        Map<Integer, Employee> eMap = l1.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
        l2.forEach(employee->eMap.get(employee.getId()).setDepartment(employee.getDepartment()));
        l3.forEach(employee->eMap.get(employee.getId()).setSalary(employee.getSalary()));

        List<Employee> combinedList = new ArrayList<>(eMap.values());

        System.out.println(combinedList);
        //[Employee{id=1, name='test', department='Eng', salary=140000}]
    }


}
