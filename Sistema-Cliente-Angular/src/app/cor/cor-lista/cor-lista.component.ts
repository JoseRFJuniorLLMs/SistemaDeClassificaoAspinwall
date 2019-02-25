import { Component, OnInit } from '@angular/core';
import { CorService } from '../cor.service';
import { Cor } from '../cor';
import { Observable, empty, of, Subject } from 'rxjs';
import { catchError, switchMap } from 'rxjs/operators';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { AlertModalComponent } from '../../shared/alert-modal/alert-modal.component';
import { AlertModalService } from '../../shared/alert-modal.service';

@Component({
  selector: 'app-cor-lista',
  templateUrl: './cor-lista.component.html',
  styleUrls: ['./cor-lista.component.scss'],
  preserveWhitespaces: true
})
export class CorListaComponent implements OnInit {

  cors$: Observable<Cor[]>;
  error$ = new Subject<boolean>();

  constructor(
    private alertService: AlertModalService,
    private corService: CorService
    ) { }

  ngOnInit() {
    this.onRefreshCor();
  }

  onRefreshCor() {
    this.cors$ = this.corService.list()
    .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
      })
    );
  }

  handleError() {
    this.alertService.showAlertDanger('Erro ao carregar cors. Tente novamente mais tarde.');
   }
}
