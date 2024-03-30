/// Classe modelo para os nós da Árvore binária.
class NoModel {
  /// Valor do nó.
  final int valor;

  /// Nó a esquerda.
  late NoModel? _esquerdo;

  /// Nó a direita.
  late NoModel? _direito;

  /// Construtor da classe.
  ///
  /// [valor] é obrigatório.
  NoModel({
    required this.valor,
    NoModel? esquerdo,
    NoModel? direito,
  }) {
    _esquerdo = esquerdo;
    _direito = direito;
  }

  /// Retorna o valor referente ao nó a esquerda.
  NoModel? get esquerdo => _esquerdo;

  /// Retorna o valor referente ao nó a direita.
  NoModel? get direito => _direito;

  /// Define o valor referente ao nó a esquerda.
  void setEsquerdo(int valor) {
    _esquerdo = NoModel(valor: valor);
  }

  /// Define o valor referente ao nó a direita.
  void setDireito(int valor) {
    _direito = NoModel(valor: valor);
  }

  /// Retorna ***true*** caso o nó seja **folha**, ou seja, [esquerdo] e [direito] forem iguais a [null].
  ///
  /// Caso contrário, retornará ***false***.
  bool get isFolha {
    return _esquerdo == null && _direito == null;
  }
}
