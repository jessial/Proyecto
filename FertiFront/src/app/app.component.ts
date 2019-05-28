import { Component } from '@angular/core';
import { SeguridadService } from './seguridad/servicios/seguridad.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FertiFront';

  constructor(public seguridadService: SeguridadService) { }
}
