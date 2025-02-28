package set.Ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto>{
    private Long codigo;
    private String nome;
    private Double preco;
    private Integer quantidade;

    public Produto(Long codigo, String nome, Double preco, Integer quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.codigo = codigo;
    }

    @Override
    public int compareTo(Produto p) {
        return nome.compareToIgnoreCase(p.getNome());
    }

    public String getNome() {
        return nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Produto produto)) return false;
        return Objects.equals(getCodigo(), produto.getCodigo());
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(getCodigo());
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}

class ComparatorPorPreco implements Comparator<Produto>{

    @Override
    public int compare(Produto p1, Produto p2) {
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}
