import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';
import { AppMaterialModule } from './app-material/app-material.module';

@NgModule({
  declarations: [
    ErrorDialogComponent,
    ConfirmationDialogComponent
  ],
  imports: [
    CommonModule,
    AppMaterialModule
  ],
  exports: [
    MatDialogModule,
    ErrorDialogComponent,
    ConfirmationDialogComponent
  ]
})
export class SharedModule { }