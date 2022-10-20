export class Admin {
    adminId: number;
    adminFirstName: string;
    adminLastName: string;
    age: number;
    email: string;
    password: string;
    contact: string;

    constructor(adminId: number,
        adminFirstName: string,
        adminLastName: string,
        age: number,
        email: string,
        password: string,
        contact: string
    ) {
        this.adminId = adminId;
        this.adminFirstName = adminFirstName;
        this.adminLastName = adminLastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }

    toString(): string {
        return this.adminId + "adminId" +
            this.adminFirstName + "adminFirstName" +
            this.adminLastName + "adminLastName" +
            this.age + "age" +
            this.email + "email" +
            this.password + "password" +
            this.contact + "contact"
    }
}
