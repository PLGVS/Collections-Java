package map.Ordenacao;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livrosMap;

    public LivrariaOnline() {
        this.livrosMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco){
        livrosMap.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo){
        Livro livroParaRemover = null;
        if(!livrosMap.isEmpty()){
            for (Map.Entry<String, Livro> entry : livrosMap.entrySet()){
                String linklivro = entry.getKey();
                Livro livro = entry.getValue();
                if (livro.getTitulo().equalsIgnoreCase(titulo)){
                    livroParaRemover = livro;
                    livrosMap.remove(linklivro);
                    break;
                }
            }
        }
        else{
            System.out.println("O Map está vazio!");
        }
    }

    public void exibirLivros(){
        System.out.println(livrosMap);
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> livrosPorPreco = new ArrayList<>(livrosMap.entrySet());

        Collections.sort(livrosPorPreco, new ComparatorPorPreco());
        Map<String, Livro> livrosOrdenados = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosPorPreco){
            livrosOrdenados.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenados;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor){
        Map<String, Livro> livrosPorAutor = new HashMap<>();
        if(!livrosMap.isEmpty()){
            for (Map.Entry<String, Livro> entry : livrosMap.entrySet()){
                if (entry.getValue().getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.put(entry.getKey(), entry.getValue());
                }
            }
        }
        else {
            System.out.println("O Map está vazio!");
        }
        return livrosPorAutor;
    }

    public Livro obterLivroMaisCaro(){
        Livro livroMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if(!livrosMap.isEmpty()){
            for (Map.Entry<String, Livro> entry : livrosMap.entrySet()){
                if (entry.getValue().getPreco() > maiorPreco){
                    livroMaisCaro = livrosMap.get(entry.getKey());
                    maiorPreco = entry.getValue().getPreco();
                }
            }
        }
        else {
            System.out.println("O Map está vazio!");
        }

        return livroMaisCaro;
    }

    public Livro obterLivroMaisBarato(){
        Livro livroMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if(!livrosMap.isEmpty()){
            for (Map.Entry<String, Livro> entry : livrosMap.entrySet()){
                if (entry.getValue().getPreco() < menorPreco){
                    livroMaisBarato = livrosMap.get(entry.getKey());
                    menorPreco = entry.getValue().getPreco();
                }
            }
        }
        else {
            System.out.println("O Map está vazio!");
        }

        return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livraria = new LivrariaOnline();

        livraria.adicionarLivro("Link 1", "Livro 1", "Autor 1", 79.99);
        livraria.adicionarLivro("Link 2", "Livro 2", "Autor 2", 29.99);
        livraria.adicionarLivro("Link 3", "Livro 3", "Autor 3", 49.99);
        livraria.adicionarLivro("Link 4", "Livro 4", "Autor 4", 26.99);
        livraria.adicionarLivro("Link 5", "Livro 5", "Autor 2", 26.99);

        livraria.exibirLivros();

        System.out.println(livraria.exibirLivrosOrdenadosPorPreco());
        System.out.println();
        System.out.println(livraria.pesquisarLivrosPorAutor("Autor 2"));
        System.out.println(livraria.obterLivroMaisCaro());
        System.out.println(livraria.obterLivroMaisBarato());

    }
}
