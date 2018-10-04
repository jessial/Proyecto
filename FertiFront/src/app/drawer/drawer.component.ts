import { Component, ViewChild  } from '@angular/core';
import { FormComponent } from '../form_tipo_cultivo/form.component'

@Component({
  selector: 'app-drawer',
  templateUrl: './drawer.component.html',
  styleUrls: ['./drawer.component.css']
})

export class DrawerComponent {
  visible = false;
  childrenVisible = false;
  formulario: string;
  data: any;
  
  @ViewChild(FormComponent) form: FormComponent;


  open(formulario: string): void {
    this.formulario = formulario;
    this.visible = true;
  }

  close(): void {
    this.visible = false;
  }

  openChildren(): void {
    this.childrenVisible = true;
  }

  closeChildren(): void {
    this.childrenVisible = false;
  }

  submitForm(): void{
    this.form.submitForm();
  }

}
