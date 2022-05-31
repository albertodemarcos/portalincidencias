import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

//ROUTERS
import { INCIDENCE_ROUTER } from './incidence.routing';

//COMPONENTS
import { FormIncidenceComponent } from './form-incidence/form-incidence.component';
import { ViewIncidenceComponent } from './view-incidence/view-incidence.component';
import { CityMapComponent } from './city-map/city-map.component';
import { ListIncidencesComponent } from './list-incidences/list-incidences.component';

//MODULES
import { SharedModule } from '../../shared/shared.module';

//SERVICES
import { IncidencesService } from './incidences.service';

@NgModule({
  declarations: [FormIncidenceComponent, ViewIncidenceComponent, CityMapComponent, ListIncidencesComponent],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(INCIDENCE_ROUTER)
  ],
  providers: [IncidencesService ], 
})
export class IncidenceModule { }
