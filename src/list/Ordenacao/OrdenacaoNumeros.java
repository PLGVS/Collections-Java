package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> numerosInteiros;

    public OrdenacaoNumeros() {
        this.numerosInteiros = new ArrayList<>();
    }

    public void adicionarNumero(int num){
        numerosInteiros.add(num);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> numerosAscendentes = new ArrayList<>(this.numerosInteiros);
        if (!numerosAscendentes.isEmpty()){
            Collections.sort(numerosAscendentes);
            return numerosAscendentes;
        }
        else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> numerosDescendentes = new ArrayList<>(this.numerosInteiros);
        if (!numerosDescendentes.isEmpty()){
            numerosDescendentes.sort(Collections.reverseOrder());
            return numerosDescendentes;
        }
        else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(7);
        numeros.adicionarNumero(23);
        numeros.adicionarNumero(1);
        numeros.adicionarNumero(3);
        numeros.adicionarNumero(6);

        System.out.println(numeros.ordenarDescendente());
        System.out.println(numeros.ordenarAscendente());
    }
}
