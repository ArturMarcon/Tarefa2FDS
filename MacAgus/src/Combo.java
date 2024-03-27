import java.util.ArrayList;

public class Combo implements Product {
    private String nome;
    private ArrayList<Product> itens;
    private String codigo;

    private static int codigoAtual = 1;

    public Combo(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
        this.codigo = "C"+Integer.toString(codigoAtual++);
    }

    public void adicionaItem(Product item) {
        itens.add(item);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Código: " + codigo + ", Preco: " + getPreco();
    }

    @Override
    public double getPreco() {
        double precoTotal = 0;
        for (Product item : itens) {
            precoTotal += item.getPreco();
        }
        return precoTotal * 0.9; // Desconto de 10% no preço do combo
    }
    

    public void adicionarItem(Product produtoComponent) {
        itens.add(produtoComponent);
    }

    public void removerItem(Product produtoComponent) {
        itens.remove(produtoComponent);
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Product> getItens() {
        return itens;
    }

    public String getCodigo() {
        return codigo;
    }

    public static int getCodigoAtual() {
        return codigoAtual;
    }

}
