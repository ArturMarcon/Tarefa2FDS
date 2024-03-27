import java.util.*;

public class Dados {
    
    private static Dados instance;

    private List<Produto> produtos;
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

    public Produto[] getProdutos() {
        return (Produto[])produtos.toArray();
    }

    public Pedido[] getPedidos() {
        return (Pedido[])pedidos.toArray();
    }

    public Produto getProdutoFromCod(String cod) {
        Optional<Produto> produto = produtos.stream()
                                            .filter(p -> p.getCodigo().equals(cod))
                                            .findAny();
        if (!produto.isPresent())
            return null;
        return produto.get();
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
}
