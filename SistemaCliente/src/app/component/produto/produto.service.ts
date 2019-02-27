import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Produto } from './produto';
import { tap, delay, take, map } from 'rxjs/operators';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  private readonly API = `${environment.API}`;
  private readonly API2 = `${environment.API2}`;

  constructor(private http: HttpClient) { }

  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  });

  list() {
    return this.http.get<Produto[]>(this.API)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }

  create(produto: Produto) {
    return this.http.post<Produto>(this.API2, produto, {
      headers: this.headers
    })
    .pipe(map(data => data));
  }
}
