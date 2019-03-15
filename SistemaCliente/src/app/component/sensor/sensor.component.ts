import { Component, OnInit } from '@angular/core';
import { Observable, Subject, empty } from 'rxjs';

import { Caixa } from '../../component/sensor/caixa';
import { AlertModalService } from '../../shared/alert-modal/alert-modal.service';
import { SensorService } from './sensor.service';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-sensor',
  templateUrl: './sensor.component.html',
  styleUrls: ['./sensor.component.css']
})
export class SensorComponent implements OnInit {

  sensors$: Observable<Caixa[]>;
  error$ = new Subject<boolean>();
  descricao: string;

  constructor(
    private alertService: AlertModalService,
    private sensorService: SensorService
  ) { }

  ngOnInit() {
    this.onRefreshSensor();
  }


  searchSensor(descricao: string) {
    this.sensors$ =  this.sensorService.searchSensorsDescricao(descricao);
       if (this.descricao != null ) {
        console.log('SUCESSO: ' + this.sensors$);
       } else {
        console.log('ERRO: ' + this.sensors$);
        this.handleError();
       }
  }
  onSubmitShearch() {
    this.searchSensor(this.descricao);
    this.handleSucesso();
   }

  onRefreshSensor() {
    this.handleSucesso();
    this.sensors$ = this.sensorService.getSensores()
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
    this.alertService.showAlertDanger('Erro ao carregar, Servidor off line - Tente novamente mais tarde.');
   }
}
