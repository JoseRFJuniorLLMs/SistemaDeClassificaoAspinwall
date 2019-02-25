import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CorListaComponent } from './cor-lista/cor-lista.component';

const routes: Routes = [
  { path: '', component: CorListaComponent}/*,
  { path: 'novo', component: CorFormComponent},
  { path: 'editar/:id', component: CorFormComponent} */
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CorRoutingModule { }
