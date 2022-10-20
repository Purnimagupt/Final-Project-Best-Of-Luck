import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GiftCard } from '../gift-card';

@Injectable({
  providedIn: 'root'
})
export class GiftcardService {

  constructor(private http: HttpClient) {
  }

  baseUrl = "http://localhost:8080/EGiftCardApp/api/GiftCard"

  getAllGiftCards(): Observable<GiftCard[]> {
    return this.http.get<GiftCard[]>("http://localhost:8080/EGiftCardApp/api/GiftCard");
  }
}
