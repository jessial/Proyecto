import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableFuenteComponent } from './table-fuente.component';

describe('TableFuenteComponent', () => {
  let component: TableFuenteComponent;
  let fixture: ComponentFixture<TableFuenteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableFuenteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableFuenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
