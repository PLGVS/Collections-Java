package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicas;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicas = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ConjuntoPalavrasUnicas that)) return false;
        return Objects.equals(palavrasUnicas, that.palavrasUnicas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(palavrasUnicas);
    }

    public void adicionarPalavra(String palavra){
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra){
        if (!palavrasUnicas.isEmpty()){
            if (palavrasUnicas.contains(palavra)){
                palavrasUnicas.remove(palavra);
            }
            else {
                System.out.println("Palavra não encontrada!");
            }
        }
        else {
            System.out.println("O conjunto está vazio");
        }
    }

    public Boolean verificarPalavra(String palavra){
        return palavrasUnicas.contains(palavra);
    }

    public void exibirPalavrasUnicas(){
        if(!palavrasUnicas.isEmpty()) {
            System.out.println(palavrasUnicas);
        }
        else {
            System.out.println("O conjunto está vazio!");
        }
    }

    @Override
    public String toString() {
        return "ConjuntoPalavrasUnicas{" +
                "palavrasUnicas=" + palavrasUnicas +
                '}';
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas palavras = new ConjuntoPalavrasUnicas();

        palavras.adicionarPalavra("Java");
        palavras.adicionarPalavra("Python");
        palavras.adicionarPalavra("JavaScript");
        palavras.adicionarPalavra("Python");
        palavras.adicionarPalavra("C++");
        palavras.adicionarPalavra("Ruby");


        palavras.exibirPalavrasUnicas();


        palavras.removerPalavra("Python");
        palavras.exibirPalavrasUnicas();


        palavras.removerPalavra("Swift");


        System.out.println("A linguagem 'Java' está no conjunto? " + palavras.verificarPalavra("Java"));
        System.out.println("A linguagem 'Python' está no conjunto? " + palavras.verificarPalavra("Python"));


        palavras.exibirPalavrasUnicas();
    }
}
