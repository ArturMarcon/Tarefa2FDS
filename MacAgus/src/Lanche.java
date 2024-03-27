public class Lanche implements Produto {
    private String nome;
    private String codigo;
    private double preco;

    private static int codigoAtual = 1;
    
    public Lanche(String nome, float preco) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = Integer.toString(codigoAtual++);

    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Código: " + codigo + ", Preço: " + preco;
    }

    public double getPreco() {
        return preco;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
