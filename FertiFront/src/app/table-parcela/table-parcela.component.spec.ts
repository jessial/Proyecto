import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableParcelaComponent } from './table-parcela.component';

describe('TableParcelaComponent', () => {
  let component: TableParcelaComponent;
  let fixture: ComponentFixture<TableParcelaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableParcelaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableParcelaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
