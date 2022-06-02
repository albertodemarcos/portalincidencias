import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Incidence } from 'app/entities/incidence/incidence.model';
import { ActionResponse } from 'app/model/app-action-respone';
import { IncidencesService } from '../incidences.service';

@Component({
  selector: 'jhi-form-incidence',
  templateUrl: './form-incidence.component.html',
  styleUrls: ['./form-incidence.component.scss']
})
export class FormIncidenceComponent implements OnInit {

  incidenceForm: FormGroup ;
  idIncidence: any;
  success = false;

  constructor(
    private formBuilder: FormBuilder,
    private incidencesService: IncidencesService,
    private router: Router,
    private route: ActivatedRoute)
  {
    this.incidenceForm = this.formBuilder.group({
      id: [0],
      title: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      description: ['', [Validators.required, Validators.minLength(15), Validators.maxLength(254)]],
      startDate: ['', [Validators.required, Validators.minLength(15), Validators.maxLength(254)]],
      endDate: ['', [Validators.required, Validators.minLength(15), Validators.maxLength(254)]],
      longitude: [0, [Validators.required ]],
      latitude: [0, [Validators.required ]],
      resolved: [false],
    });    
  }

  ngOnInit(): void {
    console.log("Component[FormIncidenceComponent]=>ngOnInit()");
  }

  createIncidence(): void
  {
    let incidence: Incidence = this.getTaskFromFormBuild();
    this.postSaveIncidence(incidence);
  }

  editIncidence(): void
  {
    let incidence: Incidence = this.getTaskFromFormBuild();
    this.postSaveIncidence(incidence);
  }

  private getTaskFromFormBuild()
  {
    let incidence: Incidence = new Incidence();
    
    let idP = this.incidenceForm.get('id')?.value;
    let titleP = this.incidenceForm.get('title')?.value;
    let descriptionP = this.incidenceForm.get('description')?.value; 
    let startDateP = this.incidenceForm.get('startDate')?.value; 
    let endDateP = this.incidenceForm.get('endDate')?.value;
    let longitudeP = this.incidenceForm.get('longitude')?.value; 
    let latitudeP = this.incidenceForm.get('latitude')?.value; 
    let resolvedP = this.incidenceForm.get('resolved')?.value;

    incidence.create(idP, titleP, descriptionP, startDateP, endDateP, longitudeP, latitudeP, resolvedP); 

    return incidence;
  }

  private getIncidenceFromJson(idIncidence: any, data: any) 
  {
    this.incidenceForm.setValue({
      id: idIncidence,
      title: data['title'],
      description: data['description'],
      startDate: data['startDate'],
      endDate: data['endDate'],
      longitude: data['location']?data['location']['longitude'] : null,//location
      latitude: data['location']?data['location']['latitude'] : null,//location
      resolved: data['resolved'],
    });
  }

  private postSaveIncidence(incidence: Incidence): void
  {    
    this.incidencesService.save(incidence).subscribe( ( 
      (response: ActionResponse)=>{
        if( response == null || !response.code || response.code.trim() !== '1' || !response.data )
        {
          alert("Se ha producido un error!");
          return;
        }        
        this.router.navigate(['/tasks/list']);
      }),
      ( (error2: any)=>{
        alert("Error: "+JSON.stringify(error2) );
      })
    );
  }

  private getEditIncidence(): void
  {
    let idIncidence = Number(this.route.snapshot.params['id']);

    if( idIncidence == null || typeof(idIncidence) == undefined || idIncidence == 0 || isNaN(idIncidence) ) 
    {
      return;
    }
    
    this.incidencesService.get(idIncidence).subscribe(
      (response: ActionResponse)=>{
        if( response == null || !response.code || response.code.trim() !== '1' || !response.data )
        {
          alert("Se ha producido un error!");
          return;
        }        
        this.getIncidenceFromJson(idIncidence, response.data);
      },
      (error: any)=>{
        alert("Error: "+JSON.stringify(error) );
      }
    );
  }

}
