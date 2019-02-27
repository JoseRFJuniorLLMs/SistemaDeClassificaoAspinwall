import { Cor } from '../paginas/cor/cor';
import { Embalagem } from '../paginas/embalagem/embalagem';
import { Grupo } from '../paginas/grupo/grupo';
import { Marca } from '../paginas/marca/marca';
export interface Produto {
     _id?: any;
     uuid?: String;
     descricao?: string;
     preco?: Number;
     durabilidade?: string;
     peso?: Number;
     rotulagem?: string;
     status?: string;
     embalagem?: Embalagem[];
     grupo?: Grupo[];
     cor?: Cor[];
     marca?: Marca[];
     imagem?: string;
     altura?: Number;
     largura?: Number;
     formato?: string;
}
