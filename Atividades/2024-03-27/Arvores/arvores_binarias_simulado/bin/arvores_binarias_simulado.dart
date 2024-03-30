import 'package:arvores_binarias_simulado/src/shared/services/arvore_binaria/arvore_binaria_service.dart';

void main() {
  var arvoreBinaria = ArvoreBinariaService();

  arvoreBinaria.inserirLista([70, 25, 90, 12, 40, 82, 101, 31, 42, 8, 92]);

  print(arvoreBinaria.obterPreOrdem(no: arvoreBinaria.obterRaiz(), retorno: []));
  print(arvoreBinaria.obterEmOrdem(no: arvoreBinaria.obterRaiz(), retorno: []));
  print(arvoreBinaria.obterPosOrdem(no: arvoreBinaria.obterRaiz(), retorno: []));
}
