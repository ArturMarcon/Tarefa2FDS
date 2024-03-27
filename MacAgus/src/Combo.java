import java.util.ArrayList;

public class Combo implements Produto {
    private String nome;
    private String codigo;
    private ArrayList<Produto> itens;

    private static int codigoAtual = 1;

    public Combo(String nome) {
        this.nome = nome;
        this.codigo = "C"+Integer.toString(codigoAtual++);
        this.itens = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public ArrayList<Produto> getItens() {
        return itens;
    }
    
    @Override
    public double getPreco() {
        double precoTotal = 0;
        for (Produto item : itens) {
            precoTotal += item.getPreco();
        }
        return precoTotal * 0.9; // Desconto de 10% no preço do combo
    }
    
    public void addItem(Produto item, int qtd) {
        for (int i = 1; i <= qtd; i++)
            itens.add(item);
    }
    
    public void removeItem(Produto item) {
        itens.remove(item);
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + ", Código: " + codigo + ", Preco: " + getPreco();
    }
}
