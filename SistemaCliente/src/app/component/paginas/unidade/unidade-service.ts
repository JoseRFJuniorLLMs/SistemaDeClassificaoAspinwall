import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Unidade } from './unidade';
import { tap, delay, take } from 'rxjs/operators';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UnidadeService {

  private readonly API13 = `${environment.API13}`;
  private readonly API14 = `${environment.API14}`;

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Unidade[]>(this.API13)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }

  create(tipo) {
    return this.http.post(this.API14, tipo).pipe(take(1));
  }
}
