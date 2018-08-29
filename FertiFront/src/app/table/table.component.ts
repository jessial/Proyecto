import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  i = 1;
  editCache = {};
  dataSet = [
    {
      key    : '0',
      name   : 'Edward King 0',
      age    : '32',
      address: 'London, Park Lane no. 0'
    },
    {
      key    : '1',
      name   : 'Edward King 1',
      age    : '32',
      address: 'London, Park Lane no. 1'
    }
  ];

  constructor() { }

  addRow(): void {
    this.i++;
    this.dataSet = [ ...this.dataSet, {
      key    : `${this.i}`,
      name   : ``,
      age    : '',
      address: ``
    } ];
    this.updateEditCache();
  }

  deleteRow(i: string): void {
    const dataSet = this.dataSet.filter(d => d.key !== i);
    this.dataSet = dataSet;
  }

  startEdit(key: string): void {
    this.editCache[ key ].edit = true;
  }

  finishEdit(key: string): void {
    this.editCache[ key ].edit = false;
    this.dataSet.find(item => item.key === key).name = this.editCache[ key ].name;
    this.dataSet.find(item => item.key === key).age = this.editCache[ key ].age;
  }

  updateEditCache(): void {
    this.dataSet.forEach(item => {
      if (!this.editCache[ item.key ]) {
        this.editCache[ item.key ] = {
          edit: false,
          name: item.name,
          age: item.age
        };
      }
    });
  }

  ngOnInit(): void {
    this.updateEditCache();
  }

}
