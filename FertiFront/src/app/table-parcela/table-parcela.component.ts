import { Component, OnInit } from '@angular/core';
import { ParcelaService } from '../servicios/parcela.service';
import { Filtro } from '../clases_dominio/filtro';

@Component({
  selector: 'app-table-parcela',
  templateUrl: './table-parcela.component.html',
  styleUrls: ['./table-parcela.component.css']
})
export class TableParcelaComponent implements OnInit {

  searchValue = '';
  numeroPagina = 1;
  filtro: Filtro;
  totalElementos = 0;
  piePagina = `Total Registros: 0`;
  dataSet = [];
  listaFiltros: string[] = [];
  mapOfExpandData: { [key: string]: boolean } = {};

  constructor(private parcelaServicio: ParcelaService) { }

  ngOnInit() {
    this.filtro = new Filtro();
    this.filtro.numeroFiltro = 0;
    this.filtro.pagina = 1;
    this.filtro.valor = '';
    this.getParcela();
  }

  getParcela(): void {
    this.parcelaServicio.getBackParcela(this.filtro).subscribe(result => {
      if (!!result) {
        this.dataSet = result.parcela;
        this.totalElementos = result.paginador.totalElementos;
        this.piePagina = `Total Registros: ${this.totalElementos}`;
      }
    });
  }

  nzPageIndexChange(pagina: number): void {
    this.filtro.pagina = pagina;
    this.getParcela();
  }

  search(): void {
    this.filtro.valor = this.searchValue;
    this.filtro.numeroFiltro = 1;
    if (!!this.filtro.valor) {
      this.getParcela();
    }
  }

  reset(): void {
    this.searchValue = '';
    this.filtro.numeroFiltro = 0;
  }


}
