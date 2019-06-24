import { Component, OnInit } from '@angular/core';
import { Filtro } from '../clases_dominio/filtro';
import { AnalisisService } from '../servicios/analisis.service';
import { TipoCultivoService } from '../servicios/tipo-cultivo.service';

@Component({
  selector: 'app-table-analisis',
  templateUrl: './table-analisis.component.html',
  styleUrls: ['./table-analisis.component.css']
})
export class TableAnalisisComponent implements OnInit {

  searchValue = '';
  numeroPagina = 1;
  filtro: Filtro;
  totalElementos = 0;
  piePagina = `Total Registros: 0`;
  dataSet = [];
  listaFiltros: string[] = [];
  tiposCultivo = [];
  mapOfExpandData: { [key: string]: boolean } = {};

  constructor(private analisisServicio: AnalisisService, private tipoCultivoService: TipoCultivoService) { }

  ngOnInit() {
    this.filtro = new Filtro();
    this.filtro.numeroFiltro = 0;
    this.filtro.pagina = 1;
    this.filtro.valor = '';
    this.getAnalisis();
    this.getTipoCultivos();
  }

  getAnalisis(): void {
    this.analisisServicio.getBackAnalisis(this.filtro).subscribe(result => {
      if (!!result) {
        this.dataSet = result.analisis;
        this.totalElementos = result.paginador.totalElementos;
        this.piePagina = `Total Registros: ${this.totalElementos}`;
      }
    });
  }

  getTipoCultivos(): void {

  }

  nzPageIndexChange(pagina: number): void {
    this.filtro.pagina = pagina;
    this.getAnalisis();
  }

  search(): void {
    this.filtro.valor = this.searchValue;
    this.filtro.numeroFiltro = 1;
    if (!!this.filtro.valor) {
      this.getAnalisis();
    }
  }

  reset(): void {
    this.searchValue = '';
    this.filtro.numeroFiltro = 0;
  }

}
