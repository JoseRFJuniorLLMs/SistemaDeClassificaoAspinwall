import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbModal, ModalDismissReasons, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { ProdutoService } from '../produto.service';
import { Produto } from '../produto';
import { Observable, empty, of, Subject } from 'rxjs';
import { catchError } from 'rxjs/operators';
//import { AlertModalService } from '../../../shared/alert-modal/alert-modal.service';
import { Cor } from '../../../component/paginas/cor/cor';
import { CorService } from '../../paginas/cor/cor.service';

//import { Location } from '@angular/common';
import { MarcaService } from '../../paginas/marca/marca.service';
import { GrupoService } from '../../paginas/grupo/grupo.service';
import { EmbalagemService } from '../../paginas/embalagem/embalagem.service';

@Component({
  selector: 'app-produto-lista',
  templateUrl: 'produto-lista.component.html',
  encapsulation: ViewEncapsulation.None,
  styles: [
    `
      .dark-modal .modal-content {
        background-color: #009efb;
        color: white;
      }
      .dark-modal .close {
        color: white;
      }
      .light-blue-backdrop {
        background-color: #5cb3fd;
      }
    `
  ],
  preserveWhitespaces: true
})
export class ProdutoListaComponent implements OnInit {

  [x: string]: any;
  produtos$: Observable<Produto[]>;
  cors$: Observable<Cor[]>;
  error$ = new Subject<boolean>();
  closeResult: string;
  form: FormGroup;
  submitted = false;

  constructor(
    private fb: FormBuilder,
    private produtoService: ProdutoService,
    private corService: CorService,
    private marcaService: MarcaService,
    private grupoService: GrupoService,
    private embalagemService: EmbalagemService,
    //private alertService: AlertModalService,
    private modalService: NgbModal,
   // private location: Location
    ) { }

  ngOnInit() {
    this.onRefreshProduto();
    this.onForm();
    this.onRefreshMarca();
    this.onRefreshGrupo();
    this.onRefreshCor();
    this.onRefreshEmbalagem();
  }

onForm() {
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
    imagem: [],
    altura: [],
    largura: [],
    formato: []
  });
}

  onRefreshProduto() {
    this.produtos$ = this.produtoService.list()
    .pipe(
      catchError(error => {
        console.error(error);
        //this.handleError();
        return empty();
      })
    );
  }

  onRefreshCor() {
    this.cors$ = this.corService.list()
    .pipe(
      catchError(error => {
        console.error(error);
        //this.handleError();
        return empty();
        })
    );
  }

  onRefreshMarca() {
    this.marcas$ = this.marcaService.list()
    .pipe(
      catchError(error => {
        console.error(error);
        //this.handleError();
        return empty();
        })
    );
  }

  onRefreshGrupo() {
    this.grupos$ = this.grupoService.list()
    .pipe(
      catchError(error => {
        console.error(error);
        //this.handleError();
        return empty();
        })
    );
  }

  onRefreshEmbalagem() {
    this.embalagens$ = this.embalagemService.list()
    .pipe(
      catchError(error => {
        console.error(error);
        //this.handleError();
        return empty();
        })
    );
  }
  /* Abri o painel para cadastro de Produtos */
  open(content: any) {
    this.modalService.open(content, {
       windowClass: 'dark-modal',
       size: 'lg'
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
          this.onCancel();
          this.onRefreshProduto();
        },
         error =>
         this.modal.showAlertDanger('Erro ao cadastrar o produto, tente novamente!'),
        () =>
        console.log('request completo')
      );
    }
  }

  onCancel() {
    this.submitted = false;
    this.form.reset();
  }
/* 
  openBackDropCustomClass(content) {
    this.modalService.open(content, {backdropClass: 'light-blue-backdrop'});
  }

  openWindowCustomClass(content) {
    this.modalService.open(content, { windowClass: 'dark-modal' });
  }

  openSm(content) {
    this.modalService.open(content, { size: 'sm' });
  }

  openLg(content) {
    this.modalService.open(content, { size: 'lg' });
  }

  openVerticallyCentered(content) {
    this.modalService.open(content, { centered: true });
  } */ 

/*    handleSucesso() {
    this.alertService.showAlertSuccess('Conectando ao Servidor....');
   }

   handleError() {
    this.alertService.showAlertDanger('Erro ao carregar produtos. Servidor off line Tente novamente mais tarde.');
   } */
}
