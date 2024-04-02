import 'package:arvores_binarias_simulado/src/features/simulado/arvore_binaria_simulado.dart';

void main() {
  var arvoreBinaria = ArvoreBinariaSimulado();
  arvoreBinaria.inserirLista([90, 30, 11, 78, 91, 2, 15, 103]);

  print(arvoreBinaria.obterPreOrdem(no: arvoreBinaria.noRaiz, retorno: []));
  print(arvoreBinaria.obterEmOrdem(no: arvoreBinaria.noRaiz, retorno: []));
  print(arvoreBinaria.obterPosOrdem(no: arvoreBinaria.noRaiz, retorno: []));

  print(arvoreBinaria.obterQuantidadeNo());
  print(arvoreBinaria.obterMenorNo().valor);
  print(arvoreBinaria.obterPredecessorSucessor(91));
  print(arvoreBinaria.isArvoreBinariaBusca(arvoreBinaria.noRaiz));
}
