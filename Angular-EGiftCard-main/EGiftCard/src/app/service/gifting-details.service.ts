import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserGiftDetails } from '../user-gift-details';

@Injectable({
  providedIn: 'root'
})
export class GiftingDetailsService {

  constructor(private http: HttpClient) { }

  savePurchaseDetails(userDetail: UserGiftDetails): Observable<UserGiftDetails> {

    return this.http.post<UserGiftDetails>("http://localhost:8080/EgiftCardApp/usergiftdetails", userDetail)

  }
}
