import java.util.ArrayList;

public class Combo implements Product {
    private String nome;
    private ArrayList<Product> itens;

    public Combo(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionaItem(Product item) {
        itens.add(item);
    }

    @Override
    public void exibir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibir'");
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

}
