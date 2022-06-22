import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-view-organization',
  templateUrl: './view-organization.component.html'
})
export class ViewOrganizationComponent implements OnInit {

  constructor() {console.log('ViewOrganizationComponent => ngOnInit()'); }

  ngOnInit(): void {
    console.log('ViewOrganizationComponent => ngOnInit()');
  }

}
