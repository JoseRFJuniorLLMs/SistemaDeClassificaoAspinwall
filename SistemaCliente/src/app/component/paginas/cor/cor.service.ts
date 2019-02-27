import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cor } from './cor';
import { tap, delay, take } from 'rxjs/operators';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CorService {

  private readonly API3 = `${environment.API3}`;
  private readonly API4 = `${environment.API4}`;

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Cor[]>(this.API3)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }

  create(cor) {
    return this.http.post(this.API4, cor).pipe(take(1));
  }
}
