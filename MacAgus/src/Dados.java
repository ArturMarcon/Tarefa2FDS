import java.util.*;

public class Dados {
    
    private static Dados instance;

    private List<Product> produtos;
    private List<Pedido> pedidos;

    Dados() {
        this.produtos = new LinkedList<>();
        this.pedidos = new LinkedList<>();
    }

    public static Dados getInstance() {
        if (instance == null)
            instance = new Dados();
        return instance;
    }

    public Product[] getProdutos() {
        return (Product[])produtos.toArray();
    }

    public List<Pedido> getPedidos() {
        return (Pedido[])pedidos.toArray();
    }

    public Product getProdutoFromCod(String cod) {
        return produtos.stream().anyMatch(p -> p.getCodigo().equals(cod));
    }
}
