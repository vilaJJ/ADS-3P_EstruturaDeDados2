import 'package:arvores_binarias_simulado/src/shared/models/no/no_model.dart';
import 'package:arvores_binarias_simulado/src/shared/services/arvore_binaria/arvore_binaria_service.dart';

/// Classe que extende [ArvoreBinariaService], para implementar as
/// questões do simulado.
class ArvoreBinariaSimulado extends ArvoreBinariaService {
  /// 3. Crie uma função que apresente a quantidade de nós em uma
  /// árvore binária de busca.
  int obterQuantidadeNo() {
    var listaPreOrdem = <int>[];
    obterPreOrdem(no: noRaiz, retorno: listaPreOrdem);

    return listaPreOrdem.length;
  }

  /// 4. Crie uma função que encontre o nó com menor valor em uma
  /// árvore binária de busca.
  NoModel obterMenorNo() {
    var menorNo = noRaiz;

    while (true) {
      if (menorNo.esquerdo == null) {
        break;
      } else {
        menorNo = menorNo.esquerdo!;
      }
    }

    return menorNo;
  }

  /// 5. Crie uma função que apresente o sucessor e o predecessor de
  /// um dado nó em uma árvore binária de busca.
  String obterPredecessorSucessor(int valor) {
    var listaEmOrdem = <int>[];
    obterEmOrdem(no: noRaiz, retorno: listaEmOrdem);

    if (listaEmOrdem.contains(valor) == false) {
      return "O valor '$valor' não existe na árvore binária de busca.";
    }

    var retorno = "";
    var indice = listaEmOrdem.indexOf(valor);

    if (indice == 0) {
      retorno += "Não existe predecessor.";
    } else {
      var valor = listaEmOrdem[indice - 1];
      retorno += "Predecessor: '$valor'.";
    }

    retorno += "\n";

    if (indice == listaEmOrdem.length - 1) {
      retorno += "Não existe sucessor.";
    } else {
      var valor = listaEmOrdem[indice + 1];
      retorno += "Sucessor: '$valor'.";
    }

    return retorno;
  }

  /// 6. Escreva uma função que verifique se uma árvore é realmente
  /// uma árvore binária de busca.
  bool isArvoreBinariaBusca(NoModel noAtual) {
    if (noAtual.esquerdo is NoModel) {
      if (noAtual.valor < noAtual.esquerdo!.valor) {
        return false;
      }
      isArvoreBinariaBusca(noAtual.esquerdo!);
    }

    if (noAtual.direito is NoModel) {
      if (noAtual.valor > noAtual.direito!.valor) {
        return false;
      }
      isArvoreBinariaBusca(noAtual.direito!);
    }

    return true;
  }
}
