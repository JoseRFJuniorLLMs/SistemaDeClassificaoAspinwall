import { NgModule } from '@angular/devolucaoe';
import { Routes, RouterModule } from '@angular/router';
import { DevolucaoListaComponent } from './devolucao-lista/devolucao-lista.component';

const routes: Routes = [
  { path: '', component: DevolucaoListaComponent}/*,
  { path: 'novo', component: DevolucaoFormComponent},
  { path: 'editar/:id', component: DevolucaoFormComponent} */
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DevolucaoRoutingModule { }
