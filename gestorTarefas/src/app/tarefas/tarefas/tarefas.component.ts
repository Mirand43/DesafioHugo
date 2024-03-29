import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of, pipe } from 'rxjs';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';
import { Tarefas } from '../model/tarefas';
import { TarefasService } from '../services/tarefas.service';

@Component({
  selector: 'app-tarefas',
  templateUrl: './tarefas.component.html',
  styleUrls: ['./tarefas.component.scss']
})
export class TarefasComponent implements OnInit {

  tarefas$: Observable<Tarefas[]>;
  // @Input() tarefas: Tarefas[] = [];
  // @Output() add = new EventEmitter(false);
  // @Output() edit = new EventEmitter(false);
  // @Output() remove = new EventEmitter(false); 
  
  displayedColumns = ['name', 'descrition', 'action'];

  constructor(private tarefasService: TarefasService, public dialog: MatDialog) {
    //this.tarefasService = new TarefasService();
    this.tarefas$ = this.tarefasService.listTarefas()
    .pipe(
      catchError(error => {
        // console.log(error);
        this.onError('Erro ao carregar as tarefas');
        return of([])
      }
      )
    )
    ;
  }

  onError(errorMsg: string): void {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    }
      )
  }

  ngOnInit(): void {
  }

  
  // onAdd() {
  //   this.add.emit(true);
  // }

  // onEdit(tarefas: Tarefas) {
  //   this.edit.emit(tarefas);
  // }

  // onDelete(tarefas: Tarefas) {
  //   this.remove.emit(tarefas);
  // }

}
