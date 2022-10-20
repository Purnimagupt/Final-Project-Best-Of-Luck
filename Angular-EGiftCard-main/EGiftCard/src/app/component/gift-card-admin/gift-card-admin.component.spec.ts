import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GiftCardAdminComponent } from './gift-card-admin.component';

describe('GiftCardAdminComponent', () => {
  let component: GiftCardAdminComponent;
  let fixture: ComponentFixture<GiftCardAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GiftCardAdminComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(GiftCardAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
