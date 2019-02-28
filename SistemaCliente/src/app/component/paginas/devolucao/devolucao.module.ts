import { NgModule } from '@angular/devolucaoe';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { DevolucaoRoutingModule } from './devolucao-routing.module';
import { DevolucaoListaComponent } from './devolucao-lista/devolucao-lista.component';

@NgModule({
  imports: [
    CommonModule,
    DevolucaoRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [DevolucaoListaComponent]
})
export class DevolucaoModule { }
