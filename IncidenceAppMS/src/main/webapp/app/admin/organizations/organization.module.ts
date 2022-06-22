import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

import { CreateEditOrganizationComponent } from './create-edit-organization/create-edit-organization.component';
import { ViewOrganizationComponent } from './view-organization/view-organization.component';
import { ListOrganizationComponent } from './list-organization/list-organization.component';

import { SharedModule } from 'app/shared/shared.module';

import { ORGANIZATIONS_ROUTER } from './organizations.routing';
import { OrganizationService } from './organization.service';

@NgModule({
  declarations: [
    CreateEditOrganizationComponent,
    ViewOrganizationComponent,
    ListOrganizationComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    RouterModule.forChild(ORGANIZATIONS_ROUTER)
  ],
  providers: [
    OrganizationService
  ]
})
export class OrganizationModule { }
