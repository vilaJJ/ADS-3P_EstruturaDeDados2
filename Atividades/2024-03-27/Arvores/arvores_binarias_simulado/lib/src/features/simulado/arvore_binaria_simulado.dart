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
}
