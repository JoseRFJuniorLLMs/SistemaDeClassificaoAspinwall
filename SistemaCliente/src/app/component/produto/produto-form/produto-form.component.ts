import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProdutoService } from '../produto.service';
import { AlertModalService } from '../../../shared/alert-modal/alert-modal.service';
import { Location } from '@angular/common';
import { CorService } from '../../paginas/cor/cor.service';
import { Observable, empty } from 'rxjs';
import { Cor } from '../../paginas/cor/cor';
import { catchError } from 'rxjs/operators';
import { MarcaService } from '../../paginas/marca/marca.service';
import { Marca } from '../../paginas/marca/marca';
import { Grupo } from '../../paginas/grupo/grupo';
import { Embalagem } from '../../paginas/embalagem/embalagem';
import { GrupoService } from '../../paginas/grupo/grupo.service';
import { EmbalagemService } from '../../paginas/embalagem/embalagem.service';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.scss']
})
export class ProdutoFormComponent implements OnInit {

  [x: string]: any;
  cors$: Observable<Cor[]>;
  marcas$: Observable<Marca[]>;
  grupos$: Observable<Grupo[]>;
  embalagens$: Observable<Embalagem[]>;
  form: FormGroup;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private produtoService: ProdutoService,
    private corService: CorService,
    private marcaService: MarcaService,
    private grupoService: GrupoService,
    private embalagemService: EmbalagemService,
    private modal: AlertModalService,
    private location: Location) { }

  ngOnInit() {
    this.onRefreshMarca();
    this.onRefreshGrupo();
    this.onRefreshCor();
    this.onRefreshEmbalagem();
    this.form = this.fb.group({
      descricao: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(250)]],
      preco: [],
      durabilidade: [],
      peso: [],
      rotulagem: [],
      status: [],
      cor: [],
      grupo: [],
      marca: [],
      embalagem: [],
      imagem: []
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

  onRefreshMarca() {
    this.marcas$ = this.marcaService.list()
    .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
        })
    );
  }

  onRefreshGrupo() {
    this.grupos$ = this.grupoService.list()
    .pipe(
      catchError(error => {
        console.error(error);
        this.handleError();
        return empty();
        })
    );
  }

  onRefreshEmbalagem() {
    this.embalagens$ = this.embalagemService.list()
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
          this.modal.showAlertSuccess('Produto Cadastrado com Sucesso!');
          this.location.back();
        },
        error => this.modal.showAlertDanger('Erro ao cadastrar o produto, tente novamente!'),
        () => console.log('request completo')
      );
    }
  }

  onCancel() {
    this.submitted = false;
    this.form.reset();
  }
}
