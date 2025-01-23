import {Company} from "./Company.ts";

export class Admin {

    id: number
    email: string
    username: string
    password: string
    company: Company

    constructor(id: number, email: string, username: string, password: string, company: Company) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.company = company;
    }
}