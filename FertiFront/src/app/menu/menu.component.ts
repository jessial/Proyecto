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
  isLogged = false;
  @ViewChild('trigger') customTrigger: TemplateRef<void>;


  constructor(private seguridadService: SeguridadService) { }

  ngOnInit() {
    this.logged();
  }

  changeTrigger(): void {
    this.triggerTemplate = this.customTrigger;
  }

  logged(): void {
    /*this.seguridadService.getAuth()
    .subscribe(result => {
      this.isLogged = result;
    }
    );*/
  }

}
