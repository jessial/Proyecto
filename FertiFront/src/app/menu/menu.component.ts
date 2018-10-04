import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  isCollapsed = false;
  triggerTemplate = null;
  @ViewChild('trigger') customTrigger: TemplateRef<void>;


  constructor() { }

  ngOnInit() {
  }

  changeTrigger(): void {
    this.triggerTemplate = this.customTrigger;
  }

}
