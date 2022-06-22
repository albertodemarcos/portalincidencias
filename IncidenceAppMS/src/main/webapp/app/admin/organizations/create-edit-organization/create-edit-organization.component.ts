import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { OrganizationService } from '../organization.service';

@Component({
  selector: 'jhi-create-edit-organization',
  templateUrl: './create-edit-organization.component.html'
})
export class CreateEditOrganizationComponent implements OnInit {

  organizationForm: FormGroup ;
  idOrganization: any;
  success = false;

  constructor(  
    private formBuilder: FormBuilder,
    private organizationService: OrganizationService,
    private router: Router,
    private route: ActivatedRoute) {
      this.organizationForm = this.formBuilder.group({
        id: [0],
        name: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
        description: ['', ],
        type: ['', [Validators.required]],
        longitude: [0, [Validators.required ]],
        latitude: [0, [Validators.required ]]
      });
  }

  ngOnInit(): void {
    console.log('CreateEditOrganizationComponent => ngOnInit()');
  }

  createOrganization(): void {
    console.log('CreateEditOrganizationComponent => createOrganization()');
  }


}
