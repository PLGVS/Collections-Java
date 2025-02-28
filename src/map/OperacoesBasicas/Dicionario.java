package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        if(!dicionarioMap.isEmpty()){
            if(dicionarioMap.containsKey(palavra)){
                dicionarioMap.remove(palavra);
            }
            else{
                System.out.println("Palavra não encontrada!");
            }
        }
        else {
            System.out.println("O dicionário está vazio");
        }
    }

    public void exibirPalavras(){
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra){
        return dicionarioMap.get(palavra);
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Áudio", "Som reproduzido por meios eletrônicos.");
        dicionario.adicionarPalavra("Leitão", "Porco novo, esp. até a etapa de desenvolvimento em que deixa de mamar.");
        dicionario.adicionarPalavra("Penúria", "estado de extrema pobreza; miséria.");

        dicionario.exibirPalavras();

        System.out.println(dicionario.pesquisarPorPalavra("Leitão"));

        dicionario.removerPalavra("Áudio");

        dicionario.exibirPalavras();
    }
}
