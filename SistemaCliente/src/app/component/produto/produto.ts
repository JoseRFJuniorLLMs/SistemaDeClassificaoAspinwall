import { Cor } from '../paginas/cor/cor';
import { Embalagem } from '../paginas/embalagem/embalagem';
import { Grupo } from '../paginas/grupo/grupo';
import { Marca } from '../paginas/marca/marca';
import { Devolucao } from '../paginas/devolucao/devolucao';
import { Unidade } from '../paginas/unidade/unidade';

export interface Produto {
     _id: any;
     uuid?: String;
     descricao: string;
     preco?: Number;
     durabilidade?: string;
     peso?: Number;
     rotulagem?: string;
     status?: string;
     imagem?: string;
     altura?: Number;
     largura?: Number;
     formato?: string;
     datacadastro?: string;
     estilo?: string;
     fabricacao?: string;
     vencimento?: string;
     unidade?: Unidade[];
     cor: Cor[];
     embalagem: Embalagem[];
     grupo: Grupo[];
     marca: Marca[];
     devolucao: Devolucao[];
}
