import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

// ROUTERS
import { INDEX_ROUTER } from './index.routing';

// COMPONENTS
import { CityMapComponent } from './city-map/city-map.component';
import { ListIncidencesComponent } from './list-incidences/list-incidences.component';

// MODULES
import { SharedModule } from '../../shared/shared.module';
import { ModalService } from 'app/core/util/modal.service';


@NgModule({
  declarations: [CityMapComponent, ListIncidencesComponent],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(INDEX_ROUTER)
  ],
  providers: []
})
export class IndexModule { }
