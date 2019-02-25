import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cor } from './cor';
import { tap, delay, take } from 'rxjs/operators';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CorService {

  private readonly API2 = `${environment.API2}`;

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Cor[]>(this.API2)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }

  create(cor) {
    return this.http.post(this.API2, cor).pipe(take(1));
  }
}
