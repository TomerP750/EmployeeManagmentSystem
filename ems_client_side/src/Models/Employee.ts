import {Role} from "./Role.ts";
import {Department} from "./Department.ts";


export class Employee {
    id: number
    firstName: string
    lastName: string
    email: string
    phone: string
    role: Role
    department: Department
    startDate: Date
    salary: number

    constructor(id: number, firstName: string, lastName: string, email: string, phone: string, role: Role, department: Department,startDate: Date, salary: number) {
        this.id = id;
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.phone = phone
        this.role = role
        this.department = department
        this.startDate = startDate
        this.salary = salary
    }


}