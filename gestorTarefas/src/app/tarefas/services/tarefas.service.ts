import { Injectable } from '@angular/core';
import { Tarefas } from '../model/tarefas';
import { HttpClient } from '@angular/common/http';
import { delay, first, take, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {

  constructor(private httpClient: HttpClient) { }

  private readonly API = '/assets/tarefas.json'

  listTarefas() {
    return this.httpClient.get<Tarefas[]>(this.API)
    .pipe(
      first(),
      delay(5000),
      tap(tarefas => console.log(tarefas)
      )
    );
  }

}
