import java.util.LinkedList;
import java.util.List;

public class Pedido {

    private String codigo;
    private List<Produto> itens;

    private static int numPedido = 1000;

    public Pedido() {
        this.codigo = Integer.toString(numPedido++);
        this.itens = new LinkedList<>();
    }

    public void registrarPedido(String codigo, int quantidade) {
        Produto p = Dados.getInstance().getProdutoFromCod(codigo);
        for (int i = 1; i <= quantidade; i++) {
            itens.add(p);
        }
    }

    public String gerarComprovante() {
        String c = "Pedido " + codigo + "\n";
        for (Produto p : itens) {
            int qtd = (int)itens.stream().filter(o -> o.equals(p)).count();
            c += String.format("%6d | %s\n", qtd, p.getNome());
        }
        return c;
    }
}
