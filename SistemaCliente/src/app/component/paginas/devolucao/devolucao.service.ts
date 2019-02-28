import { Injectable } from '@angular/devolucaoe';
import { HttpClient } from '@angular/common/http';
import { Devolucao } from './devolucao';
import { tap, delay, take } from 'rxjs/operators';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DevolucaoService {

  private readonly API3 = `${environment.API3}`;
  private readonly API4 = `${environment.API4}`;

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Devolucao[]>(this.API3)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }

  create(devolucao) {
    return this.http.post(this.API4, devolucao).pipe(take(1));
  }
}
