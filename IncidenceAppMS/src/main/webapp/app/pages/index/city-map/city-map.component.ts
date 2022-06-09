import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-city-map',
  templateUrl: './city-map.component.html',
  styleUrls: ['./city-map.component.scss']
})
export class CityMapComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    console.log("Component[CityMapComponent]=>ngOnInit()");
  }

}
