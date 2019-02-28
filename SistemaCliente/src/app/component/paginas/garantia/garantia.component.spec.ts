import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GarantiaComponent } from './garantia.component';

describe('GarantiaComponent', () => {
  let component: GarantiaComponent;
  let fixture: ComponentFixture<GarantiaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GarantiaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GarantiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
