import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { DevolucaoRoutingModule } from './devolucao-routing.module';
import { DevolucaoComponent } from './devolucao.component';

@NgModule({
  imports: [
    CommonModule,
    DevolucaoRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [DevolucaoComponent]
})
export class DevolucaoModule { }
