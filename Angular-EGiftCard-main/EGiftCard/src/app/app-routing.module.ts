import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
// import { AuthGuard } from './auth/auth.guard';
import { AboutComponent } from './component/about/about.component';
import { AdminComponent } from './component/admin/admin.component';
import { BrandsComponent } from './component/brands/brands.component';
import { ContactComponent } from './component/contact/contact.component';
import { GiftCardAdminComponent } from './component/gift-card-admin/gift-card-admin.component';
import { GiftingDetailsComponent } from './component/gifting-details/gifting-details.component';
import { HomeComponent } from './component/home/home.component';
import { LoginComponent } from './component/login/login.component';
import { PaymentComponent } from './component/payment/payment.component';
import { UserAdminComponent } from './component/user-admin/user-admin.component';
// import { PopupComponent } from './component/popup/popup.component';
import { UserComponent } from './component/user/user.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'user', component: UserComponent },
  { path: 'brands', component: BrandsComponent },
  { path: 'about', component: AboutComponent },
  { path: 'login', component: LoginComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'gifting-detail', component: GiftingDetailsComponent },
  { path: 'payment', component: PaymentComponent },
  { path: 'brands/gifting-detail', component: GiftingDetailsComponent },
  { path: 'brands/gifting-detail/payment/:giftCardAmount', component: PaymentComponent },
  { path: 'brands/gifting-detail/payment/home', component: HomeComponent },
  {
    path: 'admin', component: AdminComponent,
    children: [
      { path: 'user-admin', component: UserAdminComponent },
      { path: 'gift-card-admin', component: GiftCardAdminComponent }
    ]
  },
  
  {path:'home/brands',component:BrandsComponent}
  // {path:'footer/brands',component:BrandsComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
