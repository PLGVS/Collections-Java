package set.Pesquisa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao, false));
    }

    public void removerTarefa(String descricao){
        if (!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                    tarefaSet.remove(t);
                }
            }
        }
        else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public void exibirTarefas(){
        System.out.println(tarefaSet);
    }

    public int contarTarefas(){
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if(!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.isConcluida()) {
                    tarefasConcluidas.add(t);
                }
            }
        }
        else {
            System.out.println("O conjunto está vazio!");
        }

        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if(!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (!t.isConcluida()) {
                    tarefasPendentes.add(t);
                }
            }
        }
        else {
            System.out.println("O conjunto está vazio!");
        }

        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao){
        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setConcluida(true);
                    break;
                }
                else {
                    System.out.println("Tarefa não encontrada!");
                }
            }
        }
        else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public void marcarTarefaPendente(String descricao){
        if(!tarefaSet.isEmpty()){
            for (Tarefa t : tarefaSet){
                if (t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setConcluida(false);
                    break;
                }
                else {
                    System.out.println("Tarefa não encontrada!");
                }
            }
        }
        else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public void limparListaTarefas(){
        tarefaSet.clear();
    }

    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();

        lista.adicionarTarefa("Tarefa 1");
        lista.adicionarTarefa("Tarefa 2");
        lista.adicionarTarefa("Tarefa 3");
        lista.adicionarTarefa("Tarefa 3");
        lista.adicionarTarefa("Tarefa 5");

        lista.exibirTarefas();

        lista.marcarTarefaConcluida("Tarefa 5");

        lista.exibirTarefas();
        System.out.println(lista.obterTarefasConcluidas());

        lista.marcarTarefaPendente("Tarefa 5");

        lista.exibirTarefas();

        lista.contarTarefas();
    }
}
