package set.Ordenacao;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double nota){
        alunoSet.add(new Aluno(nome, matricula, nota));
    }

    public void removerAluno(Long matricula){
        Aluno alunoParaRemover = null;
        if(!alunoSet.isEmpty()){
            for (Aluno a : alunoSet){
                if(a.getMatricula().equals(matricula)){
                    alunoParaRemover = a;
                    break;
                }
            }
            if (alunoParaRemover != null){
                alunoSet.remove(alunoParaRemover);
            }
            else {
                System.out.println("Aluno não encontrado!");
            }
        }
        else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
        alunosPorNota.addAll(alunoSet);
        return alunosPorNota;
    }

    public void exibirAlunos(){
        System.out.println(alunoSet);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("João", 2765L, 5.5);
        gerenciadorAlunos.adicionarAluno("Gustavo", 2765L, 8.5);
        gerenciadorAlunos.adicionarAluno("Maria", 3765L, 9.5);
        gerenciadorAlunos.adicionarAluno("Douglas", 4765L, 6.5);
        gerenciadorAlunos.adicionarAluno("Lucas", 5765L, 7.5);

        gerenciadorAlunos.exibirAlunos();

        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());

        gerenciadorAlunos.removerAluno(5765L);
        gerenciadorAlunos.exibirAlunos();
    }
}
