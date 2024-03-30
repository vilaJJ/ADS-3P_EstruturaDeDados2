/// Extensão para implementar novos métodos no tipo primitivo [int].
extension IntExtension on int {
  /// Retorna ***true*** caso o valor inteiro seja par.
  ///
  /// Caso contrário, retornará falso.
  bool get isPar => isEven;

  /// Retorna ***true*** caso o valor inteiro seja impar.
  ///
  /// Caso contrário, retornará falso.
  bool get isImpar => isPar == false;
}
