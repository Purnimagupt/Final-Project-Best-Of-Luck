import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Brands } from '../brands';


@Injectable({
  providedIn: 'root'
})
export class BrandsService {

  constructor(private http: HttpClient) { }


  getAlBrands(): Observable<Brands[]> {

    return this.http.get<Brands[]>("http://localhost:8080/EgiftCardApp/giftbrands");
  }
}