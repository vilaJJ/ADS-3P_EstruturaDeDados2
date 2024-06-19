import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Grafo {
    private Map<Vertice, List<Vertice>> verticesAdjascentes;

    Grafo() {
        this.verticesAdjascentes = new HashMap<Vertice, List<Vertice>>();
    }

    void adicionarVertice(String nomeCidade) {
        verticesAdjascentes.putIfAbsent(new Vertice(nomeCidade), new ArrayList<>());
    }

    void removerVertice(String nomeCidade) {
        Vertice verticeRemover = new Vertice(nomeCidade);
        verticesAdjascentes.values().stream().forEach(e -> e.remove(verticeRemover));
        verticesAdjascentes.remove(new Vertice(nomeCidade));
    }

    void adicionarAresta(String nomeCidadeInicio, String nomeCidadeDestino) {
        Vertice v1 = new Vertice(nomeCidadeInicio);
        Vertice v2 = new Vertice(nomeCidadeDestino);
        verticesAdjascentes.get(v1).add(v2);
        verticesAdjascentes.get(v2).add(v1);
    }

    void removerAresta(String nomeCidadeInicio, String nomeCidadeDestino) {
        Vertice v1 = new Vertice(nomeCidadeInicio);
        Vertice v2 = new Vertice(nomeCidadeDestino);

        List<Vertice> eV1 = verticesAdjascentes.get(v1);
        List<Vertice> eV2 = verticesAdjascentes.get(v2);

        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    List<Vertice> obterVerticeAdjascente(String label) {
        return verticesAdjascentes.get(new Vertice(label));
    }

    void imprimirGrafico() {
        StringBuffer grafico = new StringBuffer();

        for (Vertice vertice : verticesAdjascentes.keySet()) {
            grafico.append(vertice);
            grafico.append(verticesAdjascentes.get(vertice));
        }
        System.out.println(grafico.toString());
    }

    class Vertice {
        String nomeCidade;

        Vertice(String nomeCidade) {
            this.nomeCidade = nomeCidade;
        }

        @Override
        public int hashCode() {
            final int valorCalculo = 31;
            int resultado = 1;
            resultado = valorCalculo * resultado + obterOutraInstancia().hashCode();
            resultado = valorCalculo * resultado + ((nomeCidade == null) ? 0 : nomeCidade.hashCode());
            return resultado;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (getClass() != obj.getClass()) {
                return false;
            }

            Vertice vertice = (Vertice) obj;

            if (!obterOutraInstancia().equals(vertice.obterOutraInstancia())) {
                return false;
            }
            if (nomeCidade == null) {
                if (vertice.nomeCidade != null) {
                    return false;
                }
            } else if (!nomeCidade.equals(vertice.nomeCidade)) {
                return false;
            }

            return true;
        }

        private Grafo obterOutraInstancia() {
            return Grafo.this;
        }
    }

    static Set<String> obterEmProfundidade(Grafo grafo, String cidadeRaiz) {
        Set<String> visitados = new LinkedHashSet<String>();
        Stack<String> pilha = new Stack<String>();

        pilha.push(cidadeRaiz);
        
        while (!pilha.isEmpty()) {
            String vertice = pilha.pop();
            
            if (!visitados.contains(vertice)) {
                visitados.add(vertice);

                for (Vertice v : grafo.obterVerticeAdjascente(vertice)) {
                    pilha.push(v.nomeCidade);
                }
            }
        }
        return visitados;
    }

    static Set<String> obterEmLargura(Grafo grafo, String cidadeRaiz) {
        Set<String> visitados = new LinkedHashSet<String>();
        Queue<String> fila = new LinkedList<String>();

        fila.add(cidadeRaiz);
        visitados.add(cidadeRaiz);

        while (!fila.isEmpty()) {
            String vertice = fila.poll();
            
            for (Vertice v : grafo.obterVerticeAdjascente(vertice)) {
                if (!visitados.contains(v.nomeCidade)) {
                    visitados.add(v.nomeCidade);
                    fila.add(v.nomeCidade);
                }
            }
        }
        return visitados;
    }
}