package com.techelevator;

public class Employee {
    private long employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
    private Department department;
    private String hireDate;

    private static final double STARTING_SALARY = 60000;

    public long getEmployeeID() { return this.employeeID; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getEmail() { return this.email; }
    public double getSalary() { return this.salary; }
    public Department getDepartment() { return this.department; }
    public String getHireDate() { return this.hireDate; }

    public void setEmployeeID(long employeeID) { this.employeeID = employeeID; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(Department department) { this.department = department; }
    public void setHireDate(String hireDate) { this.hireDate = hireDate; }

    public Employee(long employeeID, String firstName, String lastName, String email, Department department, String hireDate) {
        setEmployeeID(employeeID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setDepartment(department);
        setHireDate(hireDate);
        this.salary = STARTING_SALARY;
    }

    public Employee() { this.salary = STARTING_SALARY; }

    public String getFullName() { return lastName + ", " + firstName; }

    public void raiseSalary(double percent) { salary += salary * (percent/100); }
}
