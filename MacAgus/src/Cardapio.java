import java.util.List;

public class Cardapio {

    public static String get() {
        String c = "CARDAPIO DE LANCHES:\n";
        for (Produto p : Dados.getInstance().getProdutos()) {
            c += String.format("%4s | R$ %4,.2f | %s\n", p.getCodigo(), p.getPreco(), p.getNome());
            if (p instanceof Combo) {
                Combo combo = (Combo) p;
                List<Produto> itens = combo.getItens().stream().distinct().toList();
                for (Produto pp : itens) {
                    int qtd = (int)itens.stream().filter(o -> o.equals(pp)).count();
                    c += String.format("%6d | %s\n", qtd, pp.getNome());
                }
            }
        }
        return c;
    }

}
