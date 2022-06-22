import { Injectable } from '@angular/core';
import { HttpService } from 'app/core/http/http.service';
import { ActionResponse } from 'app/model/app-action-respone';
import { AppResponse } from 'app/model/app-response';
import { catchError, map, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  private static URL_LIST_ORGANIZATIONS = '/organizationsAppApi/organizations/list';

  constructor(private httpService: HttpService) { }

  getListOrganizations(filters: any): Observable<ActionResponse>{
    
    /**@typescript-eslint/no-this-alias */
    const that = this;

    return new Observable(observer => {
      that.httpService.post(OrganizationService.URL_LIST_ORGANIZATIONS, filters).subscribe(
        (response: ActionResponse) => {
          if( !response ){
            observer.error();
            return;
          }
          observer.next(response);
          observer.complete();
        }
      );
    });
    
    
    /*return this.httpService.post('/organizationApi/organizations/list', filters ).pipe<AppResponse>(
      map(( response: any ) => {
        return response;
      },
      catchError( (error: any) => {
        return throwError(error);
      }))
    );*/
  }

  
}
