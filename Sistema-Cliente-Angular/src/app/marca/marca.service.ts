import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Marca } from './marca';
import { tap, delay, take } from 'rxjs/operators';
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class MarcaService {

  private readonly API9 = `${environment.API9}`;
  private readonly API10 = `${environment.API10}`;

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Marca[]>(this.API9)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }
}

