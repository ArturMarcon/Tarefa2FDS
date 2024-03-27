import java.io.PrintStream;

public class SistemaDeVendasFacade {

    PrintStream out;
    Pedido pedidoAtual;

    public SistemaDeVendasFacade(PrintStream out) {
        this.out = out;
        pedidoAtual = null;
    }

    public void boasvindas() {
        out.println("Bem-Vindo a Lancheria do Bolinha!!");
    }

    public void exibirOpcoes() {
        out.println("1) Exibir Cardapio");
        out.println("2) Iniciar Pedido");
        out.println("3) Adicionar no Pedido");
        out.println("4) Finalizar Pedido");
        out.println("5) Fim");
        out.print("\nInsira sua escolha: ");
    }

    public void exibirCardapio() {
        out.println(Cardapio.get());
    }

    public void criarPedido() {
        this.pedidoAtual = new Pedido();
        out.println("Novo Pedido Criado.");
    }

    public void registrarPedido(String codigo, int quantidade) {
        if (pedidoAtual == null)
            out.println("Sem Pedido Aberto.");
        
        pedidoAtual.registrarPedido(codigo, quantidade);
    }

    public void gerarComprovante() {
        if (pedidoAtual == null)
            out.println("Sem Pedido Aberto.");

        out.println(pedidoAtual.gerarComprovante());
        Dados.getInstance().addPedido(pedidoAtual);
        pedidoAtual = null;
    }
}
