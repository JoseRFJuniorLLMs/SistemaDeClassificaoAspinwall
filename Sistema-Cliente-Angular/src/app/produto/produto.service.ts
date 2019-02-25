import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Produto } from './produto';
import { tap, delay, take } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { Cor } from '../cor/cor';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  private readonly API = `${environment.API}`;
  private readonly API2 = `${environment.API2}`;

  constructor(private http: HttpClient) { }

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

  create(produto) {
    return this.http.post(this.API, produto).pipe(take(1));
  }
}
