import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModalService {

  private modalSource : Subject<any> = new Subject<any>();
  modalData : Observable<any> = this.modalSource.asObservable();

  private modalParamsBehaviourSubject : BehaviorSubject<any> = new BehaviorSubject<any>(null);
  modalParamsObservable$ : Observable<any> = this.modalParamsBehaviourSubject.asObservable();

  constructor(private router : Router) { }

  open( url : string, params? : any, maximizable?: boolean ) : void
  {
    console.log("Modal URL: " + url + " params: " + JSON.stringify(params) + " maximizable: " + maximizable );

    this.router.navigate( [ { outlets : { 'modal' : [ 'modal' ] } } ] );
    
    let modalData : any = this.getModalData( url, params, maximizable );

    setTimeout( () => {
      this.modalSource.next( modalData );
    }, 100 );
  }

  close()
  {
    this.modalSource.next( { open : false } );
  }

  actualizaModalParams(modalParams:any)
  {
    this.modalParamsBehaviourSubject.next(modalParams);
  }

  private getModalData( url : string, params? : any, maximizable?: boolean )
  {
    let paramsModal = params == null || params == undefined ? {} : params;
    let ulrModal = "modal/" + url.replace( /^\/+/, "" );
    let maximizableModal = maximizable != null ? maximizable : false;
    return {
      url : ulrModal,
      params : paramsModal,
      maximizable: maximizableModal,
      open: true
    };
  }


}
