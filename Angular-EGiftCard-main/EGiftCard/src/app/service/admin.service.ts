import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { observableToBeFn } from 'rxjs/internal/testing/TestScheduler';
import { LoginComponent } from '../component/login/login.component';
import { Admin } from '../admin';
import { Brands } from '../brands';
import { GiftCard } from '../gift-card';
import { User } from '../user';


@Injectable({
  providedIn: 'root'
})
export class AdminService {


  constructor(private http: HttpClient) {
  }

  //Admin Details
  login(email: string, password: string): Observable<Admin> {
    return this.http.get<Admin>(`http://localhost:8080/EGiftCardApp/admin/loginAdmin/${email}${password}`);
  }

  forgotPassword(user: User, email: string): Observable<User> {
    return this.http.put<User>(`http://localhost:8080/EGiftCardApp/api/user/forgetPassword/${user.email}`, user);
  }

  //user Details
  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>("http://localhost:8080/EgiftCardApp/userservice/allUser");
  }

  deleteUser(userName: string): Observable<User> {
    return this.http.delete<User>(`http://localhost:8080/EgiftCardApp/userservice/${userName}`);
  }

  updateUser(u: User, userName: string): Observable<User> {
    return this.http.put<User>(`http://localhost:8080/EgiftCardApp/userservice/updateUser/${userName}`, u);
  }

  addUser(user: User): Observable<User> {
    return this.http.post<User>("http://localhost:8080/EgiftCardApp/userservice/registerUser", user);
  }

  //gift details
  getAllGiftCards(): Observable<Brands[]> {
    return this.http.get<Brands[]>("http://localhost:8080/EgiftCardApp/giftbrands");
  }
  deleteBrand(brandId: number): Observable<Brands> {
    return this.http.delete<Brands>(`http://localhost:8080/EgiftCardApp/giftbrands/${brandId}`);
  }

  updateBrand(b: Brands, brandId: number): Observable<Brands> {
    return this.http.put<Brands>(`http://localhost:8080/EgiftCardApp/giftbrands/${brandId}`, b);
  }

  addBrand(brand: Brands): Observable<Brands> {
    return this.http.post<Brands>("http://localhost:8080/EgiftCardApp/giftbrands", brand);
  }
}
