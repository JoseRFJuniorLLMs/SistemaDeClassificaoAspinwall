import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Produto } from './produto';
import { tap, delay, take, map } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { Cor } from '../cor/cor';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  private readonly API = `${environment.API}`;
  private readonly API2 = `${environment.API2}`;
  private readonly API3 = `${environment.API3}`;

  constructor(private http: HttpClient) { }

  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  });

  listCor() {
    return this.http.get<Cor[]>(this.API2)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }

  list() {
    return this.http.get<Produto[]>(this.API)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }

/*   create(produto) {
    return this.http.post(this.API3, produto).pipe(take(1));
  } */
  create(produto: Produto) {
    return this.http.post<Produto>(this.API3, produto, {
      headers: this.headers
    })
    .pipe(map(data => data));
}
}
