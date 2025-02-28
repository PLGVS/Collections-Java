package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> palavrasMap;

    public ContagemPalavras() {
        this.palavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        palavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if (!palavrasMap.isEmpty()){
            if(palavrasMap.containsKey(palavra)){
                palavrasMap.remove(palavra);
            }
            else{
                System.out.println("Palavra não encontrada!");
            }
        }
        else {
            System.out.println("O Map está vazio!");
        }
    }

    public void exibirPalavras(){
        System.out.println(palavrasMap);
    }

    public void encontrarPalavraMaisFrequente(){
        String palavraMaisFrequente = " ";
        Integer maiorContagem = Integer.MIN_VALUE;
        if(!palavrasMap.isEmpty()){
            for (String palavra : palavrasMap.keySet()){
                if (palavrasMap.get(palavra) > maiorContagem){
                    palavraMaisFrequente = palavra;
                    maiorContagem = palavrasMap.get(palavra);
                }
            }
            System.out.println("Palavra mais frequente: " + palavraMaisFrequente + ", " + palavrasMap.get(palavraMaisFrequente) + " aparições");
        }
        else {
            System.out.println("O Map está vazio!");
        }
    }

    public static void main(String[] args) {
        ContagemPalavras palavras = new ContagemPalavras();

        palavras.adicionarPalavra("Palavra 1", 4);
        palavras.adicionarPalavra("Palavra 2", 20);
        palavras.adicionarPalavra("Palavra 3", 12);
        palavras.adicionarPalavra("Palavra 4", 7);

        palavras.exibirPalavras();
        palavras.encontrarPalavraMaisFrequente();

        palavras.removerPalavra("Palavra 2");
        palavras.exibirPalavras();
        palavras.encontrarPalavraMaisFrequente();
    }
}
