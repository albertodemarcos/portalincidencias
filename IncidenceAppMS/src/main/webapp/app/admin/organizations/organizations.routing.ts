import { Routes } from '@angular/router';

// COMPONENTS
import { CreateEditOrganizationComponent } from './create-edit-organization/create-edit-organization.component';
import { ViewOrganizationComponent } from './view-organization/view-organization.component';
import { ListOrganizationComponent } from './list-organization/list-organization.component';

export const ORGANIZATIONS_ROUTER: Routes = [
  {path: 'create',    component: CreateEditOrganizationComponent},
  {path: 'edit/:id',  component: CreateEditOrganizationComponent},
  {path: 'view/:id',  component: ViewOrganizationComponent},
  {path: 'list',      component: ListOrganizationComponent},
  {path: '',      component: ListOrganizationComponent},
];