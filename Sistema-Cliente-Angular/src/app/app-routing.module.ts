import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: '/produto'
  },
  {
    path: 'produto',
    loadChildren: './produto/produto.module#ProdutoModule'
  },
  {
    path: 'cor',
    loadChildren: './cor/cor.module#CorModule'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
