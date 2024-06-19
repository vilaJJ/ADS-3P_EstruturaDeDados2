public class GrafosApp {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        grafo.adicionarVertice("Araguaína");
        grafo.adicionarVertice("Piraquê");
        grafo.adicionarVertice("Wanderlândia");
        grafo.adicionarVertice("Babaçulândia");
        grafo.adicionarVertice("Filadélfia");
        grafo.adicionarVertice("Palmeirante");
        grafo.adicionarVertice("Nova Olinda");
        grafo.adicionarVertice("Pau D'arco");
        grafo.adicionarVertice("Santa Fé do Araguaía");
        grafo.adicionarVertice("Muricilândia");
        grafo.adicionarVertice("Aragominas");
        grafo.adicionarVertice("Carmolândia");

        grafo.adicionarAresta("Araguaína", "Piraquê");
        grafo.adicionarAresta("Araguaína", "Wanderlândia");
        grafo.adicionarAresta("Araguaína", "Babaçulândia");
        grafo.adicionarAresta("Araguaína", "Filadélfia");
        grafo.adicionarAresta("Araguaína", "Palmeirante");
        grafo.adicionarAresta("Araguaína", "Nova Olinda");
        grafo.adicionarAresta("Araguaína", "Pau D'arco");
        grafo.adicionarAresta("Araguaína", "Santa Fé do Araguaía");
        grafo.adicionarAresta("Araguaína", "Muricilândia");
        grafo.adicionarAresta("Araguaína", "Aragominas");
        grafo.adicionarAresta("Araguaína", "Carmolândia");

        grafo.adicionarAresta("Piraquê", "Wanderlândia");
        grafo.adicionarAresta("Wanderlândia", "Babaçulândia");
        grafo.adicionarAresta("Babaçulândia", "Filadélfia");
        grafo.adicionarAresta("Filadélfia", "Palmeirante");
        grafo.adicionarAresta("Palmeirante", "Nova Olinda");
        grafo.adicionarAresta("Nova Olinda", "Pau D'arco");
        grafo.adicionarAresta("Santa Fé do Araguaía", "Muricilândia");
        grafo.adicionarAresta("Muricilândia", "Aragominas");
        grafo.adicionarAresta("Aragominas", "Carmolândia");
        grafo.adicionarAresta("Carmolândia", "Piraquê");

        grafo.removerAresta("Araguaína", "Carmolândia");
        grafo.removerAresta("Aragominas", "Carmolândia");
        grafo.removerAresta("Carmolândia", "Piraquê");

        grafo.removerVertice("Carmolândia");

        System.out.println("Grafo em Largura:");
        System.out.println("\t" + Grafo.obterEmLargura(grafo, "Araguaína"));

        System.out.println("Grafo em Profundidade:");
        System.out.println("\t" + Grafo.obterEmProfundidade(grafo, "Araguaína"));
    }
}