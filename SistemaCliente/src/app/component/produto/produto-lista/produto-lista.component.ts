import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbModal, ModalDismissReasons, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { ProdutoService } from '../produto.service';
import { Produto } from '../produto';
import { Observable, empty, of, Subject } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Cor } from '../../../component/paginas/cor/cor';
import { CorService } from '../../paginas/cor/cor.service';

import { MarcaService } from '../../paginas/marca/marca.service';
import { GrupoService } from '../../paginas/grupo/grupo.service';
import { EmbalagemService } from '../../paginas/embalagem/embalagem.service';
import { AlertModalService } from '../../../shared/alert-modal/alert-modal.service';
import { DevolucaoService } from '../../paginas/devolucao/devolucao.service';
import { Devolucao } from '../../paginas/devolucao/devolucao';
import { Marca } from '../../paginas/marca/marca';
import { Grupo } from '../../paginas/grupo/grupo';
import { Embalagem } from '../../paginas/embalagem/embalagem';

import * as moment from 'moment';

@Component({
  selector: 'app-produto-lista',
  templateUrl: 'produto-lista.component.html',
  encapsulation: ViewEncapsulation.None,
  styleUrls: ['produto-lista.component.scss'],
  preserveWhitespaces: true
})

export class ProdutoListaComponent implements OnInit {

  produtos$: Observable<Produto[]>;
  cors$: Observable<Cor[]>;
  marcas$: Observable<Marca[]>;
  grupos$: Observable<Grupo[]>;
  embalagens$: Observable<Embalagem[]>;
  devolucaos$: Observable<Devolucao[]>;

  error$ = new Subject<boolean>();
  closeResult: string;
  form: FormGroup;
  submitted = false;

  descricao: string;

  datacadastro: string;

  constructor(

    private produtoService: ProdutoService,
    private corService: CorService,
    private marcaService: MarcaService,
    private grupoService: GrupoService,
    private embalagemService: EmbalagemService,
    private devolucaoService: DevolucaoService,

    private fb: FormBuilder,
    private modalService: NgbModal,
    private alertService: AlertModalService
    ) { }

  ngOnInit() {
    this.onIniciaProduto();
    this.datacadastro = moment().format('DD/MM/YYYY HH:mm:ss');
  }

ngAfterContentInit(): void {
    this.onForm();
    this.onRefreshCor();
    this.onRefreshMarca();
    this.onRefreshGrupo();
    this.onRefreshEmbalagem();
    this.onRefreshDevolucao();
}

onForm() {
  this.form = this.fb.group({
    descricao: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(250)]],
    preco: [],
    durabilidade: [],
    peso: [],
    rotulagem: [],
    status: [],
    cor: [null, [Validators.required, Validators.minLength(3), Validators.maxLength(250)]],
    grupo: [],
    marca: [],
    embalagem: [],
    devolucao: [],
    imagem: [],
    altura: [],
    largura: [],
    formato: [],
    datacadastro: []
  });
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

  /* Abri o painel para cadastro de Produtos */
  open(content: any) {
    this.modalService.open(content, {
       windowClass: 'dark-modal',
       size: 'lg',
       centered: true,
       backdropClass: 'light-blue-backdrop'
       });
   }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
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
          this.onRefreshProduto();
          this.form.reset();
        },
         error =>
         this.handleError(),
         () =>
        console.log('request completo')
      );
    }
  }

/* chamadada Async */
/*   private searchPrdoutos(descricao: string) {
    this.produtoService.searchPrdoutos(descricao)
      .subscribe(
        dados => this.produtos$ = dados
        );
        console.log('PRODUTOX: ' + this.produtos$);
  } */

  searchProdutos(descricao: string) {
     this.produtos$ =  this.produtoService.searchProdutos(descricao),
        console.log('PRODUTOX: ' + this.produtos$);
  }

  uPpercase(event: any) {
    event.target.value = event.target.value.toUpperCase();
  }

  onCancel() {
    this.submitted = false;
    this.form.reset();
    this.handleSucesso();
  }

  onReset() {
    this.form.reset();
    this.handleSucesso();
  }
  onSubmitShearch() {
    this.searchProdutos(this.descricao);
    this.handleSucesso();
   }

    handleSucesso() {
    this.alertService.showAlertSuccess('Calma PORRA estou indo ao servidor....');
   }

   handleError() {
    this.alertService.showAlertDanger('Erro ao carregar produtos. Servidor off line Tente novamente mais tarde.');
   }
}
