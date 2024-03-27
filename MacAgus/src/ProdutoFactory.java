import java.util.List;

public class ProdutoFactory {
    public Produto criarProdutoSimples(String nome, float preco) {
        return new Lanche(nome, preco);
    }

    public Produto criarCombo(String nome, List<Produto> itens) {
        Combo combo = new Combo(nome);
        for (Produto item : itens) {
            combo.addItem(item,1);
        }
        return combo;

    }

}
