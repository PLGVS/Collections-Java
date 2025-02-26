package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();

        for (Item i : itens){
            if (i.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(i);
            }
        }

        itens.removeAll(itensParaRemover);
    }

    public double calcularValorTotal(){
        double valorTotal = 0.0;

        for(Item i : itens){
            valorTotal += i.getPreco() * i.getQuantidade();
        }

        return valorTotal;
    }

    public void exibirItens(){
        System.out.println(itens);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras c = new CarrinhoDeCompras();

        c.adicionarItem("Arroz", 5.50, 2);
        c.adicionarItem("Feijão", 3.50, 1);
        c.adicionarItem("Frango", 19.50, 2);
        c.adicionarItem("Batata", 7.50, 6);

        c.exibirItens();
        System.out.println("Valor total da compra: R$" + c.calcularValorTotal());

        c.removerItem("Batata");
        c.exibirItens();
        System.out.println("Valor total da compra: R$" + c.calcularValorTotal());

    }
}
