import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from 'app/core/http/http.service';
import { ActionResponse } from 'app/model/app-action-respone';
import { LazyLoadEvent } from 'primeng/api';
import { OrganizationService } from '../organization.service';

@Component({
  selector: 'jhi-list-organization',
  templateUrl: './list-organization.component.html'
})
export class ListOrganizationComponent implements OnInit {


  organizations: any[] = [
    {
      id: 1,
      name: 'Carmarma de Esteruelas',
      description: 'asd',
      type: 1
    },
    {
      id: 2,
      name: 'Alcala de Henares',
      description: 'weqe',
      type: 1
    },
    {
      id: 3,
      name: 'Meco',
      description: 'rewrewr',
      type: 1
    },
    {
      id: 3,
      name: 'Corredor del henares',
      description: 'ghhgjh',
      type: 2
    },
    {
      id: 4,
      name: '',
      description: 'klljkl',
      type: 1
    },
    {
      id: 5,
      name: 'Madrid',
      description: '345',
      type: 1
    },
    {
      id: 6,
      name: 'Valencia',
      description: '09090',
      type: 1
    },
  ];

  statuses: any[] = [];

  loading: boolean = false;

  constructor(private router: Router, private organizationService: OrganizationService) {
    console.log('ViewOrganizationComponent => ngOnInit()'); 

    this.statuses = [
      {label: 'TOWN_HALL', value: 1},
      {label: 'COMMONWEALTH', value: 2},
      {label: 'ADMINISTRATIVE_REGIONS', value: 3},
      {label: 'STATE', value: 4},
      {label: 'CONFEDERATION', value: 5},
      {label: 'PRINCIPAL', value: 6}
    ];

  }

  ngOnInit(): void {
    console.log('ListOrganizationComponent => ngOnInit()');
  }

  loadTable(event: LazyLoadEvent){

    this.loading = true;

    //let data = {lazyEvent: JSON.stringify(event.filters)};

    this.organizationService.getListOrganizations(event.filters).subscribe({
      next: (respone: ActionResponse) => {
        console.log(`getListOrganizations => ${JSON.stringify(respone)}`);
        this.loading = false;
      },
      error: (err: any) => {
        console.log(`getListOrganizations => ${JSON.stringify(err)}`);
        this.loading = false;
      }
    });
  }

  viewOrganization(organizationId: number): void {
    console.log(`ListOrganizationComponent => viewOrganization(): ${organizationId}`);
    const url = `view/${organizationId}`;
    this.router.navigate([url]);
  }
  
 

}
