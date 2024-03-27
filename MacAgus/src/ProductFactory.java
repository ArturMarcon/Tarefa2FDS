import java.util.ArrayList;

public class ProductFactory {
    public Product criarProdutoSimples(String tipo) {
        if (tipo.equals("lanche")) {
            return new Lanche();
        } else if (tipo.equals("bebida")) {
            return new Bebida();
        } else if (tipo.equals("acompanhamento")) {
            return new Acompanhamento();
        }
        return null;
    }

    public Combo criarCombo(String nome, ArrayList<Product> itens) {
        Combo combo = new Combo(nome);
        for (Product item : itens) {
            combo.adicionaItem(item);
        }
        return combo;

    }

}
