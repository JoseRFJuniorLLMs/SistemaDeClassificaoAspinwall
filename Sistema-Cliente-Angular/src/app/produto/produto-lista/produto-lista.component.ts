import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../produto.service';
import { Produto } from '../produto';
import { Observable, empty, of, Subject } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AlertModalService } from '../../shared/alert-modal.service';
import { Cor } from 'src/app/cor/cor';

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
    this.cors$ = this.produtoService.listCor()
    .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
      })
    );
  }

  handleError() {
    this.alertService.showAlertDanger('Erro ao carregar produtos. Tente novamente mais tarde.');
   }
}
