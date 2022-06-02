import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ActionResponse } from 'app/model/app-action-respone';
import { forkJoin, Observable, throwError, of, pipe } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient, /*private spinnerService : SpinnerService,*/ private router: Router) { }

  private headerHttpJson()
  {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json'});
    let options = { headers: headers }
    return options;
  }

  private validateAppResponse(response: ActionResponse): boolean
  {
    if ( response == null || typeof( response.code ) === undefined || response.code == null || response.code.trim() == '' )
    {
      return false;
    }

    return true;
  }

  public get( url: string, params?: HttpParams ): Observable<ActionResponse> 
  {
    console.log('Entramos en el get');
    //this.spinnerService.start();

    let options = this.headerHttpJson();

    let urlParams = (params != null && params.toString().trim() !== '') ? url + params.toString() : url;

    return this.http.get(urlParams, options).pipe(
    
      map( ( response: ActionResponse ) => {

        //this.spinnerService.stop();    
        
        if ( !this.validateAppResponse(response) )
        {
          return response;
        }

        return response;
      } ),
      catchError( ( error: ActionResponse ) => {

        //this.spinnerService.stop();

        if ( this.validateAppResponse(error) && typeof( error.code ) !== undefined )
        {
          return throwError( error );
        }
        
        return throwError( this.responseError() );
      })
    );   
  } 

  public post( url: string, data: any): Observable<ActionResponse>
  {
    let options = this.headerHttpJson();
    let body = JSON.stringify(data);

    return this.http.post( url, body, options).pipe( map( ( response: ActionResponse )=> {
      console.log("Entramos en el post");
      //this.spinnerService.stop();

      if ( !this.validateAppResponse(response) )
      {
        return response;
      }

      return response;
    }), 
    catchError( ( response: ActionResponse ) => {

      //this.spinnerService.stop();

      if ( this.validateAppResponse(response) && typeof( response.code ) !== undefined )
      {
        return throwError( response );
      }
      return throwError( this.responseError() );
    } ) );
  }

  private responseError( code?: string ): ActionResponse 
  {
    let response : ActionResponse = { code : '-1' };
    if ( typeof( code ) !== undefined && code ) 
    {
        response.code = code;
    }
    return response;
  }
}
