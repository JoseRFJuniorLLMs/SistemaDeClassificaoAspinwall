import { Cor } from '../cor/cor';
export interface Produto {
     _id?: any;
     uuid?: String;
     descricao?: string;
     preco?: string;
  /*    embalagem?: Embalagem, */
     durabilidade?: string;
     peso?: string;
     rotulagem?: string;
     status?: string;
    /*  grupo?: Grupo, */
       cor?: Cor[];
       /*  marca?: Marca,  */
     imagem?: string;  
}
