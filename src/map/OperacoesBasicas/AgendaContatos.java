package map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> contatoMap;

    public AgendaContatos() {
        this.contatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer numero){
        contatoMap.put(nome, numero);
    }

    public void removerContato(String nome){
        if(!contatoMap.isEmpty()){
            if(contatoMap.containsKey(nome)){
                contatoMap.remove(nome);
            }
            else {
                System.out.println("Não existe nenhum contato com esse nome");
            }
        }
        else {
            System.out.println("Agenda vazia!");
        }
    }

    public void exibirContatos(){
        System.out.println(contatoMap);
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroEncontrado = null;
        if(!contatoMap.isEmpty()){
            if(contatoMap.containsKey(nome)){
                numeroEncontrado = contatoMap.get(nome);
            }
            else {
                System.out.println("Numero não encontrado!");
            }
        }
        else {
            System.out.println("A agenda está vazia");
        }

        return numeroEncontrado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Camila", 123456);
        agendaContatos.adicionarContato("Camila", 5665);
        agendaContatos.adicionarContato("Camila Cavalcante", 1111111);
        agendaContatos.adicionarContato("Camila DIO", 654987);
        agendaContatos.adicionarContato("Maria Silva", 1111111);
        agendaContatos.adicionarContato("Camila", 44444);

        agendaContatos.exibirContatos();
    }
}
