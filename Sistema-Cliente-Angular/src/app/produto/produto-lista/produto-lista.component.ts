import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../produto.service';
import { Produto } from '../produto';
import { Observable, empty, of, Subject } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AlertModalService } from '../../shared/alert-modal.service';
import { Cor } from 'src/app/cor/cor';
import { CorService } from 'src/app/cor/cor.service';

@Component({
  selector: 'app-produto-lista',
  templateUrl: './produto-lista.component.html',
  styleUrls: ['./produto-lista.component.scss'],
  preserveWhitespaces: true
})
export class ProdutoListaComponent implements OnInit {

  produtos$: Observable<Produto[]>;
  cors$: Observable<Cor[]>;
  error$ = new Subject<boolean>();

  constructor(
    private produtoService: ProdutoService,
    private corService: CorService,
    private alertService: AlertModalService
    ) { }

  ngOnInit() {
    this.onRefresh();
    this.onRefreshCor();
  }

  onRefresh() {
    this.produtos$ = this.produtoService.list()
    .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
      })
    );
  }

  onRefreshCor() {
    this.handleSucesso()
    this.cors$ = this.corService.list()
    .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
      })
    );
  }
  
  handleSucesso() {
    this.alertService.showAlertSuccess('Conectando ao Servidor....');
   }

  handleError() {
    this.alertService.showAlertDanger('Erro ao carregar produtos. Servidor off line Tente novamente mais tarde.');
   }
}
