public class SistemaDeVendasFacade {

    private Cardapio cardapio;
    private PedidoService pedidoService;
    private ComprovanteService comprovanteService;

    public SistemaDeVendasFacade() {
        this.cardapio = new Cardapio();
        this.pedidoService = new PedidoService();
        this.comprovanteService = new ComprovanteService();
    }

    public void exibirCardapio() {
        cardapio.exibir();
    }

    public void registrarPedido(String codigo, int quantidade) {
        pedidoService.registrarPedido(codigo, quantidade);
    }

    public void gerarComprovante() {
        comprovanteService.gerarComprovante();
    }
}
