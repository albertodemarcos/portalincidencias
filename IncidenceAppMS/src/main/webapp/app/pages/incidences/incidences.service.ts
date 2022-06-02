import { HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpService } from 'app/core/http/http.service';
import { Incidence } from 'app/entities/incidence/incidence.model';
import { ActionResponse } from 'app/model/app-action-respone';
import { forkJoin, Observable, throwError, of, pipe } from 'rxjs';
import { catchError, map } from 'rxjs/operators';


@Injectable()
export class IncidencesService {

  constructor(private http: HttpService) { }

  save(incidence: Incidence): Observable<ActionResponse> 
  {
    return this.http.post('/tasksApi/createTask', incidence).pipe(
      map( 
        ( response: ActionResponse )=>{
          return response;
        },
        catchError( (error: any)=>{
          console.error("Error!: " + error);
          return throwError(error);
        })
      )      
    );
  }

  delete(incidenceId: Number): Observable<ActionResponse>
  {
    return this.http.get('/tasksApi/task/'+incidenceId).pipe(
      map( 
        ( response: ActionResponse )=>{
          return response;
        },
        catchError( (error: any)=>{
          console.error("Error!: " + error);
          return throwError(error);
        })
      )      
    );;
  }

  get(incidenceId: Number): Observable<ActionResponse>
  {
    return this.http.get('/tasksApi/task/'+incidenceId).pipe(
      map( 
        ( response: ActionResponse )=>{
          return response;
        },
        catchError( (error: any)=>{
          console.error("Error!: " + error);
          return throwError(error);
        })
      )      
    );;
  }

  list(params?: HttpParams ): Observable<ActionResponse>
  {
    return this.http.post('/tasksApi/tasks', {rows: null, field: null}).pipe(
      map( 
        ( response: ActionResponse )=>{
          return response;
        },
        catchError( (error: any)=>{
          console.error("Error!: " + error);
          return throwError(error);
        })
      )      
    );;
  }

  isResponseData(response: ActionResponse): boolean
  {
    if( response == null || response == undefined || response.code == null || response.code != '1' || response.data == null )
    {
      return false;
    }
    return true;
  }
}
