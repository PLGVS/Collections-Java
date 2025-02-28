package map.Pesquisa;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> produtosMap;

    public EstoqueProdutos() {
        this.produtosMap = new HashMap<>();
    }

    public void adicionarProduto(Long codigo, String nome, int quantidade, double preco){
        produtosMap.put(codigo, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos(){
        System.out.println(produtosMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotal = 0d;
        if(!produtosMap.isEmpty()){
            for(Produto p : produtosMap.values()){
                valorTotal += p.getPreco() * p.getQuantidade();
            }
        }
        else{
            System.out.println("O Map está vazio!");
        }

        return valorTotal;
    }

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        if (!produtosMap.isEmpty()) {
            for (Produto p : produtosMap.values()) {
                if (p.getPreco() > maiorPreco) {
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco();
                }
            }
        }
        else {
            System.out.println("O Map está vazio!");
        }

        return produtoMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.exibirProdutos();

        estoque.adicionarProduto(1L, "Produto A", 10, 5.0);
        estoque.adicionarProduto(2L, "Produto B", 5, 10.0);
        estoque.adicionarProduto(3L, "Produto C", 2, 15.0);
        estoque.adicionarProduto(4L, "Produto D", 2, 8.0);

        estoque.exibirProdutos();

        System.out.println("O valor total do estoque: R$" + estoque.calcularValorTotalEstoque());
        System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());
    }
}
