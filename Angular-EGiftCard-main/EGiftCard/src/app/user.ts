export class User {
    userName: string;
    name: string;
    email: string;
    mobile: string;
    password: string;


    constructor(userName: string,
        name: string,
        email: string,
        mobile: string,
        password: string,
    ) {
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }
}



