package app.emsserverside.Beans;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Role role;
    private Department department;
    private Date startDate;
    private Date endDate;
    private int salary;

    @ManyToOne
    private Company company;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String phone, Role role, Department department, Date startDate, Date endDate, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.department = department;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, String email, String phone, Role role, Department department, Date startDate, Date endDate, int salary, Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.department = department;
        this.startDate = startDate;
        this.endDate = endDate;
        this.salary = salary;
        this.company = company;
    }

    public Employee(String firstName, String lastName, String email, String phone, Role role, Department department, Date startDate, int salary, Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.department = department;
        this.startDate = startDate;
        this.salary = salary;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Role getRole() {
        return role;
    }

    public Department getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Company getCompany() {
        return company;
    }
}
