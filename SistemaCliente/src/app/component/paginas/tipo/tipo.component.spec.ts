import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TipoComponent } from './tipo.component';

describe('TipoComponent', () => {
  let component: TipoComponent;
  let fixture: ComponentFixture<TipoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TipoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TipoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
