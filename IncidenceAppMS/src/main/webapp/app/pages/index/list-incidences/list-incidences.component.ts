import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-list-incidences',
  templateUrl: './list-incidences.component.html'
})
export class ListIncidencesComponent implements OnInit {

  incidences: any[];

  statuses: any[];

  constructor() {
    this.incidences = [];
    this.statuses = [
      {label: 'a', value: 1},
      {label: 'b', value: 2},
      {label: 'c', value: 3},
      {label: 'd', value: 4},
      {label: 'e', value: 5},
      {label: 'f', value: 6}
    ];
  }

  ngOnInit(): void {
    console.log("Component[ListIncidencesComponent]=>ngOnInit()");
  }

  viewIncidence(incidenceId: any): void{
    console.log(`Component[ListIncidencesComponent]=>viewIncidence(${incidenceId})`);
  }

}
