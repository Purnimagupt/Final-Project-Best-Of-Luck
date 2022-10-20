import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/user';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-user-admin',
  templateUrl: './user-admin.component.html',
  styleUrls: ['./user-admin.component.css']
})
export class UserAdminComponent implements OnInit {

  users: User[];
  adminUserForm!: FormGroup;
  isUpdate: boolean = false;
  constructor(private service: AdminService, private fb: FormBuilder) {
    this.users = new Array();
  }

  ngOnInit(): void {
    this.adminUserForm = this.fb.group(
      {
        userName: ['', Validators.required],
        name: ['', Validators.required],
        email: ['', Validators.required],
        mobile: ['', Validators.required],
        password: ['', Validators.required]
      });
  }

  getAllUser() {
    this.service.getAllUsers().subscribe(users => {
      this.users = users;
    },
      err => { console.log(err) })
  }

  deleteUser(userName: string) {
    let candelete = confirm(`Are you sure to delete User '${userName}'`);
    if (candelete == true) {
      this.service.deleteUser(userName).subscribe(data => {
        alert("Deleted successfully");
        this.service.getAllUsers().subscribe(users => {
          this.users = users;
        })
      })
    }
  }

  saveUser(): void {
    let u: User = this.adminUserForm.value;
    if (!this.isUpdate) {
      this.service.addUser(u).subscribe(data => {
        alert("User with Id " + data.userName + " is created");
        this.service.getAllUsers().subscribe
          (us => {
            this.users = us;
          });
      });
    }
    else {
      this.service.updateUser(u, u.userName).subscribe(data => {
        alert("user is updated");
        this.service.getAllUsers().subscribe(u => {
          this.users = u
        });
      });
      this.isUpdate = false;
      //alert(JSON.stringify(u));
      console.log(JSON.stringify(u));

    }
    this.adminUserForm.reset;
  }


  updateUser(userName: string) {
    let u: any;
    u = this.users.find(e => e.userName == userName);
    this.service.updateUser(u, userName);
    this.adminUserForm = this.fb.group(
      {
        userName: [u.userName, Validators.required],
        name: [u.name, Validators.required],
        email: [u.email, Validators.required],
        mobile: [u.mobile, Validators.required],
        password: [u.password, Validators.required]
      }
    )
    //alert(JSON.stringify(u));
    console.log(JSON.stringify(u))
    this.isUpdate = true;
  }
}
