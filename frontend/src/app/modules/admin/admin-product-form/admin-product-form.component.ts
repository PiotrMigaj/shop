import { Component, Input, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-admin-product-form',
  template: `
    <div [formGroup]="parentForm" fxLayout="column">
      <mat-form-field appearance="fill">
        <mat-label>Nazwa</mat-label>
        <input
          matInput
          placeholder="Podaj nazwa produktu"
          formControlName="name"
        />
      </mat-form-field>
      <mat-form-field appearance="fill">
        <mat-label>Opis</mat-label>
        <textarea
          matInput
          rows="20"
          placeholder="Podaj opis produktu"
          formControlName="description"
        ></textarea>
      </mat-form-field>
      <mat-form-field appearance="fill">
        <mat-label>Kategoria</mat-label>
        <input
          matInput
          placeholder="podaj kategoria"
          formControlName="category"
        />
      </mat-form-field>
      <mat-form-field appearance="fill">
        <mat-label>Cena</mat-label>
        <input matInput placeholder="Podaj cena" formControlName="price" />
      </mat-form-field>
      <mat-form-field appearance="fill">
        <mat-label>Waluta</mat-label>
        <input
          matInput
          placeholder="Podaj waluta"
          value="PLN"
          formControlName="currency"
        />
      </mat-form-field>
      <div fxLayout="colum" fxFlexAlign="end" fxLayoutGap="10">
        <button mat-flat-button color="primary">Zapisz</button>
      </div>
    </div>
  `,
})
export class AdminProductFormComponent implements OnInit {

    @Input() parentForm!: FormGroup;

    constructor() {}

    ngOnInit(): void {}
}
