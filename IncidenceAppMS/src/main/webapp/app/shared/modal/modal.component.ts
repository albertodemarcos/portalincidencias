import { AfterViewInit, ChangeDetectorRef, Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ModalService } from 'app/core/util/modal.service';
import { Modal } from 'app/model/app-modal';
import { Dialog } from 'primeng/dialog';
import { Subscription } from 'rxjs';

@Component({
  selector: 'jhi-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements /*OnInit,*/ AfterViewInit,  OnDestroy {

  visible: boolean;
  maximizable: boolean;
  modalParams : any = {};

  // private params : any = {};
  private modalDataSubscription : Subscription | undefined;
  private modalParamsSubscription : Subscription| undefined;

  constructor(
    private modalService: ModalService,
    private router : Router,
    private activatedRoute : ActivatedRoute,
    private cdRef: ChangeDetectorRef
  ) 
  {
    this.visible = false;
    this.maximizable = false;
  }
 
  ngAfterViewInit(): void {
    this.modalDataSubscription = this.modalService.modalData.subscribe( ( dataModal : any ) => {
      
      console.info( "modalDataSubscription" );        
      
      if( dataModal.open === undefined && dataModal.url === undefined )
      {
        return;
      }

      console.info("data.open " + JSON.stringify(dataModal.open) );

      if( dataModal.open )
      {
        this.open( dataModal.url, dataModal.params, dataModal.maximizable );
      }
      else
      {
        this.close();
      }
    });

    this.modalParamsSubscription = this.modalService.modalParamsObservable$.subscribe( ( modalParams : any ) => {
      console.info("LE HA LLEGADO LAS MODAL PARAMS AL COMPONENTE APP-MODAL.COMPONENT.TS" + JSON.stringify(modalParams) );
      this.modalParams = modalParams;
      this.cdRef.detectChanges(); // para que no marque error de valor cambiado despues de after init
    } );
  }
  ngOnDestroy(): void {
    this.modalDataSubscription?.unsubscribe();
    this.modalParamsSubscription?.unsubscribe();
  }

 /* ngOnInit(): void {
    // console.log( "Entramos en onDeactivate" );
  }*/

  open( url : string, modalParams : any, maximizable: boolean ) : void
  {
    this.modalParams = modalParams;
    
    this.router.navigate( [ { outlets : { 'modal' : url.split( "/" ) } } ]  );
    
    this.visible = true;

    this.maximizable = maximizable;
  }

  close() : void
  {
    this.visible = false;
  }

  onHide() : void
  {
    this.router.navigate( [ { outlets : { 'modal' : null } } ] );
  }

  onActivate( componentInstance: any, modal: Dialog ) : void
  {
    ( <Modal> componentInstance ).modalParams = this.modalParams;
    ( <Modal> componentInstance ).maximizable = this.maximizable;

    this.modalParams = {};

    if(this.maximizable)
    {
      modal.maximize();
    }
  }

  onDeactivate( _componentInstance: any, modal: Dialog ) : void
  {
    // console.log( "Entramos en onDeactivate" );
  }

}
