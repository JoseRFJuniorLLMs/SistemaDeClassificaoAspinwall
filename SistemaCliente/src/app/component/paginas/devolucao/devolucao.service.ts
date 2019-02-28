import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Devolucao } from './devolucao';
import { tap, delay, take } from 'rxjs/operators';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DevolucaoService {

  private readonly API11 = `${environment.API11}`;
  private readonly API12 = `${environment.API12}`;

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Devolucao[]>(this.API11)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }

  create(devolucao) {
    return this.http.post(this.API12, devolucao).pipe(take(1));
  }
}
