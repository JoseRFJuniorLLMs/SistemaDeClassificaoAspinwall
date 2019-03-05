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
    private http: HttpClient,
    private alertService: AlertModalService
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
    return this.http.post<Produto>(this.API2, produto, {
      headers: this.headers
    })
    .pipe(map(data => data));
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
    this.alertService.showAlertDanger('Erro ao carregar produtos. Servidor off line Tente novamente mais tarde.');
    return throwError(error);
  }

  handleSucesso() {
    this.alertService.showAlertSuccess('Aguarde procurando servidor....');
   }
}
