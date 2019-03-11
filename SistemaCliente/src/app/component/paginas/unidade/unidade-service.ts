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

  getUnidade() {
    return this.http.get<Unidade[]>(this.API13)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }

  createUnidade(unidade: string) {
    return this.http.post(this.API14, unidade).pipe(take(1));
  }
}
