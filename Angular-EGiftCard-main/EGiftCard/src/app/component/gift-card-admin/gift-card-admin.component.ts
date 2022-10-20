import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Brands } from 'src/app/brands';
import { GiftCard } from 'src/app/gift-card';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-gift-card-admin',
  templateUrl: './gift-card-admin.component.html',
  styleUrls: ['./gift-card-admin.component.css']
})
export class GiftCardAdminComponent implements OnInit {

  brands: Brands[];
  isUpdate: boolean = false;
  adminGiftForm!: FormGroup;

  constructor(private service: AdminService, private fb: FormBuilder) {
    this.brands = new Array();

  }

  ngOnInit(): void {
    this.adminGiftForm = this.fb.group(
      {
        brandId: ['', Validators.required],
        brandName: ['', Validators.required],
        brandDescription: ['', Validators.required],
        imageUrl: ['', Validators.required]
      }
    );
  }

  getAllGiftCard() {
    this.service.getAllGiftCards().subscribe(gift => {
      this.brands = gift;

      //alert(JSON.stringify(this.brands))
      console.log(JSON.stringify(this.brands));
    },
      err => { console.log(err) },
    )

  }

  updateBrand(brandId: number) {
    let g: any;
    g = this.brands.find(e => e.brandId == brandId)
    this.service.updateBrand(g, brandId);
    this.adminGiftForm = this.fb.group(
      {
        brandId: [g.brandId, Validators.required],
        brandName: [g.brandName, Validators.required],
        brandDescription: [g.brandDescription, Validators.required],
        imageUrl: [g.imageUrl, Validators.required]
      }
    )
    //alert(JSON.stringify(g));
    console.log(JSON.stringify);
    this.isUpdate = true;
  }

  saveGiftCard(): void {
    let g: Brands = this.adminGiftForm.value;
    if (!this.isUpdate) {
      this.service.addBrand(g).subscribe(data => {
        alert("Gift Card with Id " + data.brandId + " is created");
        this.service.getAllGiftCards().subscribe
          (gi => {
            this.brands = gi;
          });
      });
    }
    else {
      this.service.updateBrand(g, g.brandId).subscribe(data => {
        alert("Gift Card is updated");
        this.service.getAllGiftCards().subscribe(g => {
          this.brands = g
        });
      });
      this.isUpdate = false;
      //alert(JSON.stringify(u));

    }
    this.adminGiftForm.reset;
  }



  deleteBrand(brandId: number) {
    let candelete = confirm(`Are you sure to delete Brand '${brandId}'`);
    if (candelete == true) {
      this.service.deleteBrand(brandId).subscribe(data => {
        alert("Deleted successfully");
        this.service.getAllGiftCards().subscribe(brand => {
          this.brands = brand;
        })
      })
    }
  }



}
