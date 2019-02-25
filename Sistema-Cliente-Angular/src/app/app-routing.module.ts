import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'cursos'
  },
  {
    path: 'cursos',
    loadChildren: './cursos/cursos.module#CursosModule'
  },
  {
    path: 'produto',
    loadChildren: './produto/produto.module#ProdutoModule'
  },
  {
    path: 'cor',
    loadChildren: './cor/cor.module#CorModule'
  },
  {
    path: 'rxjs-poc',
    loadChildren: './unsubscribe-rxjs/unsubscribe-rxjs.module#UnsubscribeRxjsModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
