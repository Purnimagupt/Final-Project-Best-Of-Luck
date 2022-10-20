import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/admin';

import { User } from 'src/app/user';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  users: User[];


  constructor(private service: AdminService, private fb: FormBuilder, private route: ActivatedRoute, private router: Router) {
    this.users = new Array();

  }

  ngOnInit(): void {
    console.log("ng on init");



  }













  showUser() {
    this.router.navigate(['user-admin'], { relativeTo: this.route });
  }

  showGiftCards() {
    this.router.navigate(['gift-card-admin'], { relativeTo: this.route });
  }
}
