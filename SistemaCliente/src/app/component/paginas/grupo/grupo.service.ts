import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Grupo } from './grupo';
import { tap, delay, take } from 'rxjs/operators';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GrupoService {

  private readonly API5 = `${environment.API5}`;
  private readonly API6 = `${environment.API6}`;

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Grupo[]>(this.API5)
      .pipe(
        delay(1000),
        tap(console.log)
      );
  }
}

