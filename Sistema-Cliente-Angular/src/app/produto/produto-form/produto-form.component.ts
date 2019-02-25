import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProdutoService } from '../produto.service';
import { AlertModalService } from '../../shared/alert-modal.service';
import { Location } from '@angular/common';
import { CorService } from 'src/app/cor/cor.service';
import { Observable, empty } from 'rxjs';
import { Cor } from 'src/app/cor/cor';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.scss']
})
export class ProdutoFormComponent implements OnInit {
  [x: string]: any;

  cors$: Observable<Cor[]>;
  form: FormGroup;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private produtoService: ProdutoService,
    private corService: CorService,
    private modal: AlertModalService,
    private location: Location) { }

  ngOnInit() {
    this.onRefreshCor();
    this.form = this.fb.group({
      descricao: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(250)]],
      cor: []
    });

  }
  onRefreshCor() {
    this.cors$ = this.corService.list()
    .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
      })
    );
  }

  hasError(field: string) {
    return this.form.get(field).errors;
  }

  onSubmit() {
    this.submitted = true;
    console.log(this.form.value);
    if (this.form.valid) {
      console.log('submit');
      this.produtoService.create(this.form.value).subscribe(
        success => {
          this.modal.showAlertSuccess('Curso criado com sucesso!');
          this.location.back();
        },
        error => this.modal.showAlertDanger('Erro ao criar curso, tente novamente!'),
        () => console.log('request completo')
      );
    }
  }

  onCancel() {
    this.submitted = false;
    this.form.reset();
  }
}
