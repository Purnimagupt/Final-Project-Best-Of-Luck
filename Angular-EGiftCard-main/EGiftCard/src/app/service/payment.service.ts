import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payment } from '../payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: HttpClient) { }

  addPaymentDetails(payment: Payment): Observable<Payment> {
    return this.http.post<Payment>("http://localhost:8080/EgiftCardApp/paymentdetails", payment);
  }
}
