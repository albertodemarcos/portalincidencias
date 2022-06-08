import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Incidence } from 'app/entities/incidence/incidence.model';
import { IncidencesService } from '../incidences.service';

@Component({
  selector: 'jhi-view-incidence',
  templateUrl: './view-incidence.component.html',
  styleUrls: ['./view-incidence.component.scss']
})
export class ViewIncidenceComponent implements OnInit {

  incidence: Incidence = new Incidence();

  constructor(private incidencesService: IncidencesService, private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    console.log("Component[ViewIncidenceComponent]=>ngOnInit()");
    this.getIncidence()
  }

  private getIncidence(): void
  {
    let idIncidence = Number(this.activatedRoute.snapshot.params['id']);

    if( idIncidence == null || typeof(idIncidence) == undefined || idIncidence == 0 || isNaN(idIncidence) ) 
    {
      return;
    }

    let observer = this.observers(idIncidence);

    this.incidencesService.get(idIncidence).subscribe( observer );
  }

  private getTaskFromJson(data: any, idIncidence : any)
  {
    this.incidence.id = idIncidence;
    this.incidence.title = data['title'];
    this.incidence.description = data['description'];
    this.incidence.resolved = data['remindresolveder'];
    this.incidence.startDate = data['startDate'];
    this.incidence.endDate = data['endDate'];
    this.incidence.longitude = data['longitude'];
    this.incidence.latitude = data['latitude'];
  }

  private observers(idIncidence: any)
  {
    let observer = {
      next: (response: any) =>{
        console.log('Observer got a next value: ' + JSON.stringify(response));

        if( response == null || !response.code || response.code.trim() !== '1' || !response.data )
        {
          alert("Se ha producido un error!");
          return;
        }
        this.incidence = new Incidence();
        this.getTaskFromJson(response.data, idIncidence);
      },
      error: (error: any) => {
        console.error('Observer got an error: ' +  JSON.stringify(error));
        alert("Error: "+JSON.stringify(error) );
      },
    };

    return observer;
  }

}
