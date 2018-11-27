import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableTipoFuenteComponent } from './table-tipo-fuente.component';

describe('TableTipoFuenteComponent', () => {
  let component: TableTipoFuenteComponent;
  let fixture: ComponentFixture<TableTipoFuenteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableTipoFuenteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableTipoFuenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
