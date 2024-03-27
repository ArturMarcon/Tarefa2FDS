import java.util.ArrayList;

public class ProductFactory {
    public Product criarProdutoSimples(String nome, float preco) {
        return new Lanche(nome, preco);
    }

    public Combo criarCombo(String nome, ArrayList<Product> itens) {
        Combo combo = new Combo(nome);
        for (Product item : itens) {
            combo.adicionaItem(item);
        }
        return combo;

    }

}
