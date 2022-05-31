import { Routes } from '@angular/router';

//COMPONENTS
import { FormIncidenceComponent } from './form-incidence/form-incidence.component';
import { ViewIncidenceComponent } from './view-incidence/view-incidence.component';
import { CityMapComponent } from './city-map/city-map.component';
import { ListIncidencesComponent } from './list-incidences/list-incidences.component';

export const INCIDENCE_ROUTER: Routes = [
    {path: 'form', component: FormIncidenceComponent},
    {path: 'view', component: ViewIncidenceComponent},
    {path: 'map', component: CityMapComponent},
    {path: 'list', component: ListIncidencesComponent}
  ];