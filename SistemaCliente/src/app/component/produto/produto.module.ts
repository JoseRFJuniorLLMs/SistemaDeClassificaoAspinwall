import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { ProdutoRoutingModule } from './produto-routing.module';
import { ProdutoListaComponent } from './produto-lista/produto-lista.component';
import { ProdutoFormComponent } from './produto-form/produto-form.component';
import { ProdutoEditarComponent } from './produto-editar/produto-editar.component';

@NgModule({
  imports: [
    CommonModule,
    ProdutoRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [ProdutoListaComponent, ProdutoFormComponent, ProdutoEditarComponent]
})
export class ProdutoModule { }
