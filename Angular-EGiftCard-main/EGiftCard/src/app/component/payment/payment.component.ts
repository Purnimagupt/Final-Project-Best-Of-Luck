import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { PaymentService } from 'src/app/service/payment.service';
import { DateValidator } from 'src/app/shared/date.validator';
import { GiftingDetailsComponent } from '../gifting-details/gifting-details.component';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  paymentObj: PaymentComponent[];
  paymentForm: FormGroup = new FormGroup({});
  giftingDetailsComponent: GiftingDetailsComponent;
  giftCardAmount: string;

  get fullName() {
    return this.paymentForm.get('fullName');
  }

  get nameOnCard() {
    return this.paymentForm.get('nameOnCard');
  }

  get paymentMethod() {
    return this.paymentForm.get('paymentMethod');
  }

  get cardNumber() {
    return this.paymentForm.get('cardNumber');
  }

  get cvv() {
    return this.paymentForm.get('cvv');
  }

  get cardExpiry() {
    return this.paymentForm.get('cardExp');
  }

  constructor(private fb: FormBuilder, private paymentService: PaymentService, private route: ActivatedRoute) {
    this.paymentObj = new Array();
    this.giftCardAmount = this.route.snapshot.paramMap.get('giftCardAmount')
    //alert(this.giftCardAmount);
    console.log(this.giftCardAmount);
  }

  public regexp = "^\\d{14,16}$";
  public regexp2 = "^\\d{3}$";
  ngOnInit(): void {
    this.paymentForm = this.fb.group({
      fullName: ['', [Validators.required]],
      nameOnCard: ['', [Validators.required]],
      cardNumber: ['', [Validators.required, Validators.pattern(this.regexp)]],
      cvv: ['', [Validators.required, Validators.pattern(this.regexp2)]],
      cardExpiry: ['', Validators.compose([Validators.required, DateValidator.dateValidator])],
      paymentAmount: [this.giftCardAmount, [Validators.required]]

    });
  }

  savePaymentDetails() {
    this.paymentService.addPaymentDetails(this.paymentForm.value).subscribe((data: any) => {
      //alert(JSON.stringify(data));
      
      console.log(JSON.stringify(data));
      console.log("Details added")
      alert("Payment Successfull, Card Sent Successfully")
    },
      (err: any) => {
        console.log(err);
      })
  }
}
