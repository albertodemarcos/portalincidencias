import { Routes } from '@angular/router';

// COMPONENTS
import { CityMapComponent } from '../index/city-map/city-map.component';
import { ListIncidencesComponent } from './list-incidences/list-incidences.component';

export const INDEX_ROUTER: Routes = [
  {path: 'map', component: CityMapComponent},
  {path: 'list', component: ListIncidencesComponent},
];