import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { CorRoutingModule } from './cor-routing.module';
import { CorListaComponent } from './cor-lista/cor-lista.component';

@NgModule({
  imports: [
    CommonModule,
    CorRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [CorListaComponent]
})
export class CorModule { }
