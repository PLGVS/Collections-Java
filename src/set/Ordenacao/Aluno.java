package set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Aluno implements Comparable<Aluno>{
    private String nome;
    private Long matricula;
    private Double nota;

    public Aluno(String nome, Long matricula, Double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    @Override
    public int compareTo(Aluno a) {
        return nome.compareToIgnoreCase(a.getNome());
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Aluno aluno)) return false;
        return Objects.equals(getMatricula(), aluno.getMatricula());
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(getMatricula());
    }

    public String getNome() {
        return nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public Double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                ", nota=" + nota +
                '}';
    }
}

class ComparatorPorNota implements Comparator<Aluno>{

    @Override
    public int compare(Aluno a1, Aluno a2) {
        return Double.compare(a1.getNota(), a2.getNota());
    }
}
