import { Routes } from '@angular/router';

// COMPONENTS
// import { CityMapComponent } from '../index/city-map/city-map.component';
import { FormIncidenceComponent } from './form-incidence/form-incidence.component';
// import { ListIncidencesComponent } from './list-incidences/list-incidences.component';
import { ViewIncidenceComponent } from './view-incidence/view-incidence.component';

export const INCIDENCES_ROUTER: Routes = [
  // {path: 'map', component: CityMapComponent},
  // {path: 'list', component: ListIncidencesComponent},
  {path: 'form', component: FormIncidenceComponent},
  // {path: 'form', component: FormIncidenceComponent},
  {path: 'view', component: ViewIncidenceComponent} 
];