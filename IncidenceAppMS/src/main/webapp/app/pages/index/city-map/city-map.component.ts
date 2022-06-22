import { Component, OnInit } from '@angular/core';
import { ModalService } from 'app/core/util/modal.service';


@Component({
  selector: 'jhi-city-map',
  templateUrl: './city-map.component.html'
})
export class CityMapComponent implements OnInit {

  options: any;
  overlays: any[] | undefined;

  constructor(private modalService: ModalService) { }

  ngOnInit(): void {
    console.log("Component[CityMapComponent]=>ngOnInit()");
  }

  getFormIncidenceModal(): void
  {
    console.log("Entramos en la modal");
    const modalParams = {
      title: "Hola esto es una prueba",
    };
    this.modalService.open('/incidences/form', modalParams, true);
  }

  getViewIncidenceModal(): void
  {
    console.log("Entramos en la modal");
    const modalParams = {
      title: "Hola esto es una prueba",
    };
    this.modalService.open('/incidences/view', modalParams, true);
  }

  addIncidence(): void {
    console.log("Component[CityMapComponent]=>ngOnInit()");
  }
  
  editIncidence(): void {
    console.log("Component[CityMapComponent]=>ngOnInit()");
  }

  deleteIncidence(): void {
    console.log("Component[CityMapComponent]=>ngOnInit()");
  }

  viewIncidence(): void {
    console.log("Component[CityMapComponent]=>ngOnInit()");
  }















}
