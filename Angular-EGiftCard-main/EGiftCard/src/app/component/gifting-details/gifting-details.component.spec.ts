import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GiftingDetailsComponent } from './gifting-details.component';

describe('GiftingDetailsComponent', () => {
  let component: GiftingDetailsComponent;
  let fixture: ComponentFixture<GiftingDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GiftingDetailsComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(GiftingDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
