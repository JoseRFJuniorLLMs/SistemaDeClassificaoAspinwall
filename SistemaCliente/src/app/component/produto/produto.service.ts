import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { tap, delay, take, map, catchError } from 'rxjs/operators';
import { environment } from '../../../environments/environment';
import { Observable, throwError } from 'rxjs';

import { Produto } from './produto';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})

export class ProdutoService {

  private readonly APIFLUX6 = `${environment.APIFLUX6}`;
  private readonly API2 = `${environment.API2}`;
  private readonly APINOME = `${environment.APINOME}`;

  constructor(
    private http: HttpClient
    ) { }
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json'
  });

  getProdutos() {
    return this.http.get<Produto[]>(this.APIFLUX6)
      .pipe(
        delay(1000),
        tap(console.log),
        catchError(this.handleError)
      );
    }

  loadByID(_id: string) {
      return this.http.get<Produto>(`${this.API2}/${_id}`).pipe(take(1));
    }

  save(produto) {
      if (produto._id) {
        return this.update(produto);
      }
      return this.create(produto);
    }
  private update(produto) {
      return this.http.put(`${this.API2}/${produto._id}`, produto).pipe(take(1));
    }
  updateProduto(data) {
      return this.http.post(`${this.APIFLUX6}`, data);
   }
  private create(produto) {
    return this.http.post(this.APIFLUX6, produto).pipe(take(1));
  }

  getProdutoID(_id: string): Observable<Produto> {
      const url = `${this.API2}/${_id}`;
      return this.http.get<Produto>(url)
      .pipe(
        tap(_ => console.log(`PESQUISA PRODUTO ID >>>>>>>${_id}`, url)),
        catchError(this.handleError)
      );
    }

  deleteProdutoID(_id: any) {
    const url = `${this.API2}${_id}`;
    return this.http.get(url + 'delete?id=' + _id);
  }

  searchProdutosDescricao(descricao: string) {
      return this.http.get<Produto[]>(this.APINOME + descricao)
        .pipe(
          delay(1000),
          tap(console.log),
          catchError(this.handleError)
        );
      }

  createProduto(produto: Produto) {
    console.log(`CREATE DO PRODUTO 1` +  produto)
    return this.http.post<Produto>(this.API2, produto, {
      headers: this.headers
    })
    .pipe(map(data => data),
    tap(_ => console.log(`CREATE DO PRODUTO 2` +  produto)),
    catchError(this.handleError)
    );
  }

/*   updateProduto(_id: any, produto: any): Observable<Produto> {
    const url = `${this.APIFLUX6}/${_id}`;
    return this.http.put(url, produto, httpOptions).pipe(
      tap(_id => console.log(`UPDATE PRODUTO ID>${_id}`)),
      catchError(this.handleError)
    );
  } */

  protected handleError(error: any): Observable<any> {
    console.log('ERRO NA REQUISIÇÃO => ', error);
      return throwError(error);
  }
}
