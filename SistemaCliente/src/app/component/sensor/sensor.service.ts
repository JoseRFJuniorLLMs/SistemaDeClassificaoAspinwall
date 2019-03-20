import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Caixa } from './caixa';
import { tap, delay, take, catchError } from 'rxjs/operators';
import { environment } from '../../../environments/environment';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SensorService {

  private readonly API17 = `${environment.API17}`;
  private readonly API18 = `${environment.API18}`;
  private readonly API_DESCRICAO_SENSOR = `${environment.API_DESCRICAO_SENSOR}`;
  private readonly API_STATUS_SENSOR = `${environment.API_STATUS_SENSOR}`;

  constructor(private http: HttpClient) { }

  getSensores() {
    return this.http.get<Caixa[]>(this.API17)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }

  searchSensorsDescricao(descricao: string) {
    return this.http.get<Caixa[]>(this.API_DESCRICAO_SENSOR + descricao)
      .pipe(
        delay(1000),
        tap(console.log),
        catchError(this.handleError)
      );
    }

  searchSensorsStatus(status: string) {
    return this.http.get<Caixa[]>(this.API_STATUS_SENSOR + status)
      .pipe(
        delay(1000),
        tap(console.log),
        catchError(this.handleError)
      );
    }

  createSensores(sensor: string) {
    return this.http.post(this.API18, sensor).pipe(take(1));
  }

  protected handleError(error: any): Observable<any> {
    console.log('ERRO NA REQUISIÇÃO => ', error);
      return throwError(error);
  }
}
