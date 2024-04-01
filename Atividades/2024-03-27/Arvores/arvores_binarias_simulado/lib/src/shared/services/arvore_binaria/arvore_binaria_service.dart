import 'package:arvores_binarias_simulado/src/shared/models/no/no_model.dart';

/// Classe de serviço, para operações com Árvores binárias.
class ArvoreBinariaService {
  /// Nó raiz da Árvore binária.
  NoModel? _noRaiz;

  /// Retorna o nó raiz da Árvore binária.
  NoModel get noRaiz {
    if (_noRaiz is NoModel) {
      return _noRaiz!;
    }

    throw Exception('A raiz da árvore binária é nula.');
  }

  /// Insere um valor na Árvore binária.
  void inserir(int valor) {
    if (_noRaiz == null) {
      _noRaiz = NoModel(valor: valor);
    } else {
      _inserir(valor, _noRaiz!);
    }
  }

  /// Insere uma lista de valores na Árvore binária.
  void inserirLista(List<int> valores) {
    for (var valor in valores) {
      inserir(valor);
    }
  }

  /// Busca um nó na Árvore binária, baseado num valor informado.
  NoModel? buscar(int valor) {
    if (_noRaiz == null) {
      return null;
    }

    return _buscar(valor, _noRaiz!);
  }

  /// Retorna uma lista de valores inteiros, referentes aos nós da Árvore binária
  /// dispostos em **pré-ordem**.
  ///
  /// 1. Raiz;
  ///
  /// 2. Esquerda;
  ///
  /// 3. Direita;
  List<int> obterPreOrdem({
    required NoModel? no,
    required List<int> retorno,
  }) {
    if (no is NoModel) {
      retorno.add(no.valor);
      retorno = obterPreOrdem(no: no.esquerdo, retorno: retorno);
      retorno = obterPreOrdem(no: no.direito, retorno: retorno);
    }

    return retorno;
  }

  /// Retorna uma lista de valores inteiros, referentes aos nós da Árvore binária
  /// dispostos **em-ordem**.
  ///
  /// 1. Esquerda;
  ///
  /// 2. Raiz;
  ///
  /// 3. Direita;
  List<int> obterEmOrdem({
    required NoModel? no,
    required List<int> retorno,
  }) {
    if (no != null) {
      retorno = obterEmOrdem(no: no.esquerdo, retorno: retorno);
      retorno.add(no.valor);
      retorno = obterEmOrdem(no: no.direito, retorno: retorno);
    }

    return retorno;
  }

  /// Retorna uma lista de valores inteiros, referentes aos nós da Árvore binária
  /// dispostos em **pós-ordem**.
  ///
  /// 1. Esquerda;
  ///
  /// 2. Direita;
  ///
  /// 3. Raiz;
  List<int> obterPosOrdem({
    required NoModel? no,
    required List<int> retorno,
  }) {
    if (no is NoModel) {
      retorno = obterPosOrdem(no: no.esquerdo, retorno: retorno);
      retorno = obterPosOrdem(no: no.direito, retorno: retorno);
      retorno.add(no.valor);
    }

    return retorno;
  }

  // Métodos privados

  /// Insere um valor na Árvore binária, respeitando as regras da estrutura de dados.
  void _inserir(int valor, NoModel noAtual) {
    if (valor <= noAtual.valor) {
      if (noAtual.esquerdo is NoModel) {
        _inserir(valor, noAtual.esquerdo!);
      } else {
        noAtual.setEsquerdo(valor);
      }
    } else {
      if (noAtual.direito is NoModel) {
        _inserir(valor, noAtual.direito!);
      } else {
        noAtual.setDireito(valor);
      }
    }
  }

  /// Busca a primeira ocorrência de um valor informado.
  NoModel? _buscar(int valor, NoModel noAtual) {
    if (valor == noAtual.valor) {
      return noAtual;
    } else if (valor <= noAtual.valor) {
      if (noAtual.esquerdo is NoModel) {
        return _buscar(valor, noAtual.esquerdo!);
      } else {
        return null;
      }
    } else {
      if (noAtual.direito is NoModel) {
        return _buscar(valor, noAtual.direito!);
      } else {
        return null;
      }
    }
  }
}
