import { ModalController } from '@ionic/angular';
import { Component, OnInit, Input } from '@angular/core';
import { Elemento } from 'src/app/dominio/elemento';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UnidadService } from 'src/app/servicios/unidad.service';
import { Unidad } from 'src/app/dominio/unidad';
import { DTOElementoXAnalisis } from 'src/app/dto/dto-elemento';
import { ElementoService } from 'src/app/servicios/elemento.service';

@Component({
  selector: 'app-modal-agregar-analisis-component',
  templateUrl: './modal-agregar-analisis-component.component.html',
  styleUrls: ['./modal-agregar-analisis-component.component.css']
})
export class ModalAgregarAnalisisComponent implements OnInit {

  @Input() elementosXAnalisis: DTOElementoXAnalisis[];
  formularioAgregarElemento: FormGroup;
  enviado = false;
  unidades: Unidad[];
  elementos: Elemento[] = [];

  constructor(private fb: FormBuilder, private modalController: ModalController,
    private unidadServicio: UnidadService, private elementoServicio: ElementoService) { }

  ngOnInit() {
    this.formularioAgregarElemento = this.fb.group({
      elemento: [null, Validators.required],
      unidad: [null, Validators.required],
      cantidad: [null, [Validators.required, Validators.min(0), Validators.max(100)]]
    });
    this.unidadServicio.getBackUnidad().subscribe(unidades => {
      this.unidades = unidades.filter(unidad => unidad.codigoUnidad !== 3);
    });
    this.elementoServicio.getBackElementos().subscribe(elementos => {
      this.elementos = elementos;
      this.cargarElementos();
    });
  }

  cargarElementos() {
    this.elementosXAnalisis.forEach(exa => {
      this.elementos = this.elementos.filter(ele => ele.codigoElemento !== exa.elemento.codigoElemento);
    });
  }

  agregarElemento() {
    this.enviado = true;
    if (this.formularioAgregarElemento.invalid) {
      return null;
    }
    const elementoPorAnalisis: DTOElementoXAnalisis = new DTOElementoXAnalisis();
    elementoPorAnalisis.cantidad = this.f.cantidad.value;
    elementoPorAnalisis.elemento = this.f.elemento.value;
    elementoPorAnalisis.unidad = this.f.unidad.value;
    this.cerrarModal(elementoPorAnalisis);
  }

  cerrarModal(elementoPorAnalisis = null) {
    this.modalController.dismiss({ 'resultado': elementoPorAnalisis });
  }

  get f() { return this.formularioAgregarElemento.controls; }

}
