import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

// ROUTERS
import { INCIDENCES_ROUTER } from './incidences.routing';

// COMPONENTS
import { FormIncidenceComponent } from './form-incidence/form-incidence.component';
import { ViewIncidenceComponent } from './view-incidence/view-incidence.component';

// MODULES
import { SharedModule } from '../../shared/shared.module';

// SERVICES
import { IncidencesService } from './incidences.service';

@NgModule({
  declarations: [FormIncidenceComponent, ViewIncidenceComponent],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(INCIDENCES_ROUTER)
  ],
  providers: [IncidencesService ], 
})
export class IncidenceModule { }
