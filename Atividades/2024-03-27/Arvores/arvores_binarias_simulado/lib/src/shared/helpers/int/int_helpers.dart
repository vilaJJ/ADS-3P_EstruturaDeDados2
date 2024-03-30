/// Retorna o maior valor inteiro de uma lista.
/// 
/// A lista [numeros] não pode ter um comprimento [numeros.length] igual a zero.
int obterMaiorValor(List<int> numeros) {
  if (numeros.isEmpty) {
    throw Exception("A lista de números não pode ser vazia.");
  }

  var value = numeros.first;

  if (numeros.length == 1) {
    return value;
  }

  for (var numero in numeros) {
    if (numero > value) {
      numero = value;
    }
  }

  return value;
}