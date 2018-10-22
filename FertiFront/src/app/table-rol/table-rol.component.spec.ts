import { fakeAsync, ComponentFixture, TestBed } from '@angular/core/testing';
import { TableRolComponent } from './table-rol.component';

describe('TableRolComponent', () => {
  let component: TableRolComponent;
  let fixture: ComponentFixture<TableRolComponent>;

  beforeEach(fakeAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ TableRolComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableRolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should compile', () => {
    expect(component).toBeTruthy();
  });
});
