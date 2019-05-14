import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-analisis',
  templateUrl: './analisis.page.html',
  styleUrls: ['./analisis.page.scss'],
})
export class AnalisisPage implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  agregarAnalisis() {
    this.router.navigateByUrl('agregar-analisis');
  }

}
