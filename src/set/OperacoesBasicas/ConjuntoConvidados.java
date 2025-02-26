package set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidado(int codigoConvite){
        Convidado convidadoParaRemover = null;
        for (Convidado c : convidadoSet){
            if(c.getCodigoConvite() == codigoConvite){
                convidadoParaRemover = c;
                break;
            }
        }
        if (convidadoParaRemover != null){
            convidadoSet.remove(convidadoParaRemover);
        }
        else{
            throw new RuntimeException("Não existe nenhum convidado com o código especificado!");
        }

    }

    public int contarConvidados(){
        return convidadoSet.size();
    }

    public void exibirConvidados(){
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados convidados = new ConjuntoConvidados();
        System.out.println("Existem " + convidados.contarConvidados() + " convidados dentro do Set de convidados");

        convidados.adicionarConvidado("Convidado 1", 1234);
        convidados.adicionarConvidado("Convidado 2", 1235);
        convidados.adicionarConvidado("Convidado 3", 1235);
        convidados.adicionarConvidado("Convidado 4", 1237);


        System.out.println("Existem " + convidados.contarConvidados() + " convidado(s) dentro do Set de convidados");

        convidados.removerConvidado(1236);

        System.out.println("Existem " + convidados.contarConvidados() + " convidado(s) dentro do Set de convidados");

        convidados.exibirConvidados();
    }

}
