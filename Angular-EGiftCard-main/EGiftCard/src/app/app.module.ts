import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutComponent } from './component/about/about.component';
import { ContactComponent } from './component/contact/contact.component';
import { FooterComponent } from './component/footer/footer.component';
import { HomeComponent } from './component/home/home.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { LoginComponent } from './component/login/login.component';
import { AdminComponent } from './component/admin/admin.component';
import { UserComponent } from './component/user/user.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'
import { RouterModule } from '@angular/router';
// import { AuthGuard } from './auth/auth.guard';
// import { AuthInterceptor } from './auth/auth.interceptor';
import { UserService } from './service/user.service';

import { PaymentComponent } from './component/payment/payment.component';
import { BrandsComponent } from './component/brands/brands.component';
import { GiftingDetailsComponent } from './component/gifting-details/gifting-details.component';
import { UserAdminComponent } from './component/user-admin/user-admin.component';
import { GiftCardAdminComponent } from './component/gift-card-admin/gift-card-admin.component';
// import { PopupComponent } from './component/popup/popup.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    LoginComponent,
    AdminComponent,
    UserComponent,
    PaymentComponent,
    BrandsComponent,
    GiftingDetailsComponent,
    UserAdminComponent,
    GiftCardAdminComponent

  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule
  ],
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
