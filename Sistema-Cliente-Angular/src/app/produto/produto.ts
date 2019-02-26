import { Cor } from '../cor/cor';
import { Embalagem } from '../embalagem/embalagem';
import { Grupo } from '../grupo/grupo';
import { Marca } from '../marca/marca';
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
}
