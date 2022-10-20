import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { GiftingDetailsService } from 'src/app/service/gifting-details.service';
import { UserGiftDetails } from 'src/app/user-gift-details';

@Component({
  selector: 'app-gifting-details',
  templateUrl: './gifting-details.component.html',
  styleUrls: ['./gifting-details.component.css']
})
export class GiftingDetailsComponent implements OnInit {
  userDetails: UserGiftDetails[];

  PurchaseForm: FormGroup = new FormGroup({});

  isUpdate: boolean = false;

  loggedInStatus: boolean;

  loggedIn: any;
  constructor(private fb: FormBuilder, private giftingDetailsService: GiftingDetailsService, private router: Router) {
    this.userDetails = new Array();
    this.loggedIn = sessionStorage.getItem("loggedIn");
    this.loggedInStatus = JSON.parse(this.loggedIn);
    alert(this.loggedIn);
  }

  ngOnInit(): void {
    this.PurchaseForm = this.fb.group({
      giftCardAmount: new FormControl(''),
      recepientName: new FormControl(''),
      recepientEmail: new FormControl(''),
      recepientMobile: new FormControl(''),
      message: new FormControl('')
    })
  }


  saveUserPurchase() {

    this.giftingDetailsService.savePurchaseDetails(this.PurchaseForm.value).subscribe(data => {
      //alert(JSON.stringify(data));
      console.log(JSON.stringify(data));
      console.log("Details added")
    },
      err => {
        console.log(err);
      })

    this.router.navigate(['/brands/gifting-detail/payment', this.PurchaseForm.value.giftCardAmount]);

  }


}