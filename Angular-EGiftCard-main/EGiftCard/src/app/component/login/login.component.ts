import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterService } from 'src/app/service/register.service';
import { UserAuthService } from 'src/app/service/user-auth.service';
import { UserService } from 'src/app/service/user.service';
import { User } from 'src/app/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})



export class LoginComponent implements OnInit {


  // for signup
  user: User = new User(null, null, null, null, null);




  constructor(private userService: UserService,
    private userAuthService: UserAuthService,
    private router: Router,
    private registerService: RegisterService) { }

  ngOnInit(): void {
  }

  register() {
    console.log(this.user);
    this.registerService.registerUser(this.user).subscribe(data => {
      alert("Successfully user is registered! Please Login Now!" );
    }, error => alert("Sorry user is not registered!"));

  }


  login(loginForm: NgForm) {
    console.log("Form is submitted!");
    alert("Login Successfully");
    console.log(loginForm.value);
    this.userService.login(loginForm.value).subscribe(
      (response: any) => {
        console.log(response.jwtToken);
        console.log(response.user.role);

        this.userAuthService.setRoles(response.user.role);
        this.userAuthService.setToken(response.jwtToken);

        const role = response.user.role[0].role;
        sessionStorage.setItem("loggedIn", "true")
        if (role === 'Admin') {
          this.router.navigate(['admin']);
        }
        else {
          this.router.navigate(['home']);
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
