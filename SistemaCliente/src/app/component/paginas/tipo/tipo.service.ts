import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tipo } from './tipo';
import { tap, delay, take } from 'rxjs/operators';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TipoService {

  private readonly API13 = `${environment.API13}`;
  private readonly API14 = `${environment.API14}`;

  constructor(private http: HttpClient) { }

  getTipo() {
    return this.http.get<Tipo[]>(this.API13)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }

  createTipo(tipo: string) {
    return this.http.post(this.API14, tipo).pipe(take(1));
  }
}
