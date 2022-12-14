import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  public setRoles(roles: []) {

    sessionStorage.setItem("roles", JSON.stringify(roles));
  }

  public getRoles() {

    return JSON.parse(sessionStorage.getItem('roles')!);
  }

  public setToken(jwtToken: string) {
    sessionStorage.setItem("jwtToken", jwtToken)
  }

  public getToken(): string {
    return sessionStorage.getItem('jwtToken')!;
  }

  public clear() {
    sessionStorage.clear();
    sessionStorage.removeItem("loggedIn");
  }

  public isLoggedIn() {
    return this.getRoles() && this.getToken();
  }


}