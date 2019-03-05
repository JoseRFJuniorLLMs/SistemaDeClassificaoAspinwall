import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Produto } from './produto';
import { tap, delay, take, map, catchError } from 'rxjs/operators';
import { environment } from '../../../environments/environment';
import { Observable, throwError } from 'rxjs';
import { AlertModalService } from '../../shared/alert-modal/alert-modal.service';

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

  list() {
    return this.http.get<Produto[]>(this.APIFLUX6)
      .pipe(
        delay(1000),
        tap(console.log),
        catchError(this.handleError)
      );
    }

  searchProdutos(descricao: string) {
      return this.http.get<Produto[]>(this.APINOME + descricao)
        .pipe(
          delay(1000),
          tap(console.log),
          catchError(this.handleError)
        );
      }

  create(produto: Produto) {
    console.log(`CREATE DO PRODUTO 1` +  produto)
    return this.http.post<Produto>(this.API2, produto, {
      headers: this.headers
    })
    .pipe(map(data => data),
    tap(_ => console.log(`CREATE DO PRODUTO 2` +  produto)),
    catchError(this.handleError)
    );
  }

  getProduto(id: string): Observable<Produto> {
    const url = `${this.APIFLUX6}/${id}`;
    return this.http.get<Produto>(url)
    .pipe(
      tap(_ => console.log(`fetched product id=${id}`)),
      catchError(this.handleError)
    );
  }

  protected handleError(error: any): Observable<any> {
    console.log('ERRO NA REQUISIÇÃO => ', error);
      return throwError(error);
  }
}
