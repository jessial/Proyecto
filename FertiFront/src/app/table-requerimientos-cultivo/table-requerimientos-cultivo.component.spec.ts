import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableRequerimientosCultivoComponent } from './table-requerimientos-cultivo.component';

describe('TableRequerimientosCultivoComponent', () => {
  let component: TableRequerimientosCultivoComponent;
  let fixture: ComponentFixture<TableRequerimientosCultivoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableRequerimientosCultivoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableRequerimientosCultivoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
