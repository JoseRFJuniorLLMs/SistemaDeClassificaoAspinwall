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
     preco?: number;
     durabilidade?: string;
     peso?: number;
     rotulagem?: string;
     status?: string;
     imagem?: string;
     altura?: number;
     largura?: number;
     tamanho: number;
     formato?: string;
     datacadastro?: string;
     estilo?: string;
     fabricacao?: string;
     vencimento?: string;
     tipo: string;
     cor: Cor[];
     embalagem: Embalagem[];
     grupo: Grupo[];
     marca: Marca[];
     devolucao: Devolucao[];
}
