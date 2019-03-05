import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbModal, ModalDismissReasons, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { Observable, empty, of, Subject } from 'rxjs';
import { catchError } from 'rxjs/operators';
import * as moment from 'moment';
import { Router, ActivatedRoute } from '@angular/router';

import { CorService } from '../../paginas/cor/cor.service';
import { ProdutoService } from '../produto.service';
import { MarcaService } from '../../paginas/marca/marca.service';
import { GrupoService } from '../../paginas/grupo/grupo.service';
import { EmbalagemService } from '../../paginas/embalagem/embalagem.service';
import { AlertModalService } from '../../../shared/alert-modal/alert-modal.service';
import { DevolucaoService } from '../../paginas/devolucao/devolucao.service';
import { UnidadeService } from '../../paginas/unidade/unidade-service';
import { TipoService } from '../../paginas/tipo/tipo.service';

import { Produto } from '../produto';
import { Devolucao } from '../../paginas/devolucao/devolucao';
import { Marca } from '../../paginas/marca/marca';
import { Grupo } from '../../paginas/grupo/grupo';
import { Embalagem } from '../../paginas/embalagem/embalagem';
import { Cor } from '../../../component/paginas/cor/cor';
import { Tipo } from '../../paginas/tipo/tipo';
import { Unidade } from '../../paginas/unidade/unidade';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.scss']
})
export class ProdutoFormComponent implements OnInit {

  produtos$: Observable<Produto[]>;
  cors$: Observable<Cor[]>;
  marcas$: Observable<Marca[]>;
  grupos$: Observable<Grupo[]>;
  embalagens$: Observable<Embalagem[]>;
  devolucaos$: Observable<Devolucao[]>;
  unidades$: Observable<Unidade[]>;
  tipos$: Observable<Tipo[]>;
  error$ = new Subject<boolean>();
  closeResult: string;
  produtoForm: FormGroup;
  submitted = false;

  descricao: string;
  datacadastro: string;
  fabricacao: string;
  vencimento: string;
  status: string;
  _id: string;

  constructor(

    private produtoService: ProdutoService,
    private corService: CorService,
    private marcaService: MarcaService,
    private grupoService: GrupoService,
    private embalagemService: EmbalagemService,
    private devolucaoService: DevolucaoService,
    private unidadeService: UnidadeService,
    private tipoService: TipoService,

    private fb: FormBuilder,
    private modalService: NgbModal,
    private alertService: AlertModalService,

    private router: Router,
    private route: ActivatedRoute

    ) { }

  ngOnInit() {
    this.getProduto(this.route.snapshot.params['id']);
    this.produtoForm = this.fb.group({
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

  ngAfterContentInit(): void {

    this.onFormularionSubmit();
    this.onRefreshCor();
    this.onRefreshMarca();
    this.onRefreshGrupo();
    this.onRefreshEmbalagem();
    this.onRefreshDevolucao();
    this.onRefreshUnidade();
    this.onRefreshTipo();

 }
 onRefreshProduto() {
  this.produtos$ = this.produtoService.list();
  if (this.produtos$ != null) {
    this.handleSucesso();
  } else {
    this.handleError();
    return empty();
  }
 }

onIniciaProduto() {
  this.produtos$ = this.produtoService.list()
    .pipe(
    catchError(error => {
      console.error(error);
      this.handleError();
      return empty();
      })
  );
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

onRefreshUnidade() {
  this.unidades$ = this.unidadeService.list()
  .pipe(
    catchError(error => {
      console.error(error);
      this.handleError();
      return empty();
    })
  );
}

onRefreshTipo() {
  this.tipos$ = this.tipoService.list()
  .pipe(
    catchError(error => {
      console.error(error);
      this.handleError();
      return empty();
    })
  );
}

onRefreshDevolucao() {
  this.devolucaos$ = this.devolucaoService.list()
  .pipe(
    catchError(error => {
      console.error(error);
      this.handleError();
      return empty();
    })
  );
}

  onFormularionSubmit() {
    this.submitted = true;
    console.log(this.produtoForm.value);
    if (this.produtoForm.valid) {
      console.log('ENVIANDO DADOS DO FORMULARIO');
      this.produtoService.create(this.produtoForm.value).subscribe(
        success => {
          this.handleSucesso();
        },
        error => {
          this.handleError();
        },
        () => console.log('DADOS ENVIADOS COM SUCESSO')
      );
    }
  }

  onCancel() {
    this.submitted = false;
    this.produtoForm.reset();
  }

  hasError(field: string) {
    return this.produtoForm.get(field).errors;
  }

  getProduto(_id: string) {
    this.produtoService.getProduto(_id).subscribe(data => {
      this._id = data._id;
      this.produtoForm.setValue({
        descricao: data.descricao,
        valor: data.preco,
      });
    });
  }

  handleSucesso() {
    this.alertService.showAlertSuccess('Calma PORRA estou indo ao servidor....');
   }

  handleError() {
    this.alertService.showAlertDanger('Erro ao carregar produtos. Servidor off line Tente novamente mais tarde.');
   }
}
