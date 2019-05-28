import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { SeguridadService} from '../seguridad/servicios/seguridad.service';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  isCollapsed = false;
  triggerTemplate = null;
  isLoadingTwo = false;
  @ViewChild('trigger') customTrigger: TemplateRef<void>;


  constructor(private seguridadService: SeguridadService) { }

  ngOnInit() {
  }

  changeTrigger(): void {
    this.triggerTemplate = this.customTrigger;
  }

  loadTwo(): void {
    this.seguridadService.logout();
  }

}
