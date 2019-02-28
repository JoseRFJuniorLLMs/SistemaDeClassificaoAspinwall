import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DevolucaoComponent } from './devolucao.component';

const routes: Routes = [
  { path: '', component: DevolucaoComponent}/*,
  { path: 'novo', component: DevolucaoFormComponent},
  { path: 'editar/:id', component: DevolucaoFormComponent} */
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DevolucaoRoutingModule { }
