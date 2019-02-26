import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Embalagem } from './embalagem';
import { tap, delay, take } from 'rxjs/operators';
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class EmbalagemService {

  private readonly API7 = `${environment.API7}`;
  private readonly API8 = `${environment.API8}`;

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Embalagem[]>(this.API7)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }
}

