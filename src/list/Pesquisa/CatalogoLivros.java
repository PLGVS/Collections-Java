package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> catalogo;

    public CatalogoLivros() {
        this.catalogo = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        catalogo.add(new Livro(titulo, autor, anoPublicacao));
    }

    // Pesquisa de Livros pelo nome do autor
    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!catalogo.isEmpty()){
            for (Livro l : catalogo){
                if(l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }
        }
        else {
            System.out.println("A lista está vazia!");
        }

        return livrosPorAutor;
    }

    //Pesquisa de Livros pelo intervalo de anos
    public List<Livro> pesquisaPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        if(!catalogo.isEmpty()){
            for (Livro l : catalogo){
                if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal){
                    livrosPorIntervaloAnos.add(l);
                }
            }
        }
        else {
            System.out.println("A lista está vazia!");
        }

        return livrosPorIntervaloAnos;
    }

    //Pesquisa de Livros por Titulo
    public Livro pesquisaPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        if(!catalogo.isEmpty()){
            for(Livro l : catalogo){
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = l;
                    break;
                }
            }
        }

        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogo = new CatalogoLivros();
        catalogo.adicionarLivro("Livro 1", "Autor 1", 2020);
        catalogo.adicionarLivro("Livro 1", "Autor 2", 2021);
        catalogo.adicionarLivro("Livro 2", "Autor 2", 2022);
        catalogo.adicionarLivro("Livro 3", "Autor 3", 2023);
        catalogo.adicionarLivro("Livro 4", "Autor 4", 1994);

        System.out.println(catalogo.pesquisarPorAutor("Autor 4"));
        System.out.println(catalogo.pesquisaPorIntervaloAnos(2020, 2021));
        System.out.println(catalogo.pesquisaPorTitulo("Livro 1"));
    }
}
