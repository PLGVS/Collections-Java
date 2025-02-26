package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    List<Integer> numerosInteiros;

    public SomaNumeros() {
        this.numerosInteiros = new ArrayList<>();
    }

    public void adicionarNumero(int num){
        numerosInteiros.add(num);
    }

    public int calcularSoma(){
        int soma = 0;
        for (int num : numerosInteiros){
            soma += num;
        }

        return soma;
    }

    public int encontrarMaiorNumero(){
        int maiorNumero = numerosInteiros.getFirst();
        for (int num : numerosInteiros){
            if (num > maiorNumero){
                maiorNumero = num;
            }
        }
        return maiorNumero;
    }

    public int encontrarMenorNumero(){
        int menorNumero = numerosInteiros.getFirst();
        for (int num : numerosInteiros){
            if (num < menorNumero){
                menorNumero = num;
            }
        }
        return menorNumero;
    }

    public List<Integer> exibirNumeros(){
        List<Integer> numeros = new ArrayList<>();
        if (!numerosInteiros.isEmpty()){
            for (int num : numerosInteiros){
                numeros.add(num);
            }
        }
        return numeros;
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(6);
        somaNumeros.adicionarNumero(8);
        somaNumeros.adicionarNumero(20);
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(12);

        System.out.println("Soma: " + somaNumeros.calcularSoma());
        System.out.println("Maior número: " + somaNumeros.encontrarMaiorNumero());
        System.out.println("Menor número: " + somaNumeros.encontrarMenorNumero());
        System.out.println("Números da lista: " + somaNumeros.exibirNumeros());
    }
}
