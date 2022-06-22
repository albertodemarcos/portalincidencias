import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { TranslateModule } from '@ngx-translate/core';

// PrimeNg
import {PanelModule} from 'primeng/panel';
import {CalendarModule} from 'primeng/calendar';
import {InputSwitchModule} from 'primeng/inputswitch';
import {TooltipModule} from 'primeng/tooltip';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {ColorPickerModule} from 'primeng/colorpicker';
import {TableModule} from 'primeng/table';
import {SidebarModule} from 'primeng/sidebar';
import {MenuModule} from 'primeng/menu';
import {MegaMenuModule} from 'primeng/megamenu';
import {TreeModule} from 'primeng/tree';
import {ProgressSpinnerModule} from 'primeng/progressspinner';
import {ToastModule} from 'primeng/toast';
import {DialogModule} from 'primeng/dialog';
import {CardModule} from 'primeng/card';
import {ContextMenuModule} from 'primeng/contextmenu';
import {ChartModule} from 'primeng/chart';
import {TagModule} from 'primeng/tag';
import {GMapModule} from 'primeng/gmap';
import { GoogleMapsModule } from '@angular/google-maps'
import {DropdownModule} from 'primeng/dropdown';


@NgModule({
  imports: [ 
    PanelModule, CalendarModule, InputSwitchModule, InputTextareaModule, TableModule, SidebarModule, MenuModule, MegaMenuModule,
    TreeModule, ProgressSpinnerModule, ToastModule, DialogModule, CardModule, ContextMenuModule, ChartModule, TagModule,
    TooltipModule, ColorPickerModule, GMapModule, GoogleMapsModule, DropdownModule
  ],
  exports: [
    FormsModule, CommonModule, NgbModule, InfiniteScrollModule, FontAwesomeModule, ReactiveFormsModule, TranslateModule,
    PanelModule, CalendarModule, InputSwitchModule, InputTextareaModule, TableModule, SidebarModule, MenuModule, MegaMenuModule,
    TreeModule, ProgressSpinnerModule, ToastModule, DialogModule, CardModule, ContextMenuModule, ChartModule, TagModule,
    TooltipModule, ColorPickerModule, GMapModule, GoogleMapsModule, DropdownModule
  ],
})
export class SharedLibsModule {}
