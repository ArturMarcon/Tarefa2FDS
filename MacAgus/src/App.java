import java.io.PrintStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        PrintStream saida = System.out;
        Scanner in = new Scanner(System.in);
        boolean rodando = true;
        
        SistemaDeVendasFacade sistema = new SistemaDeVendasFacade(saida);
        sistema.boasvindas();
        
        while(rodando) {
            sistema.exibirOpcoes();
            String leitura = in.nextLine().trim();

            while ( !ehNumerico(leitura) || !opcaoValida(leitura) ) {
                if (!ehNumerico(leitura))
                    saida.println("Insira um numero.");
                else
                    saida.println("Insira um numero valido.");
                
                sistema.exibirOpcoes();
                leitura = in.nextLine().trim();
            }

            switch (Integer.parseInt(leitura)) {
                case 1:
                    sistema.exibirCardapio();
                    break;
                case 2:
                    sistema.criarPedido();
                    break;
                case 3:
                    saida.print("Informe o codigo do produto: ");
                    leitura = in.nextLine().trim();

                    while ( Dados.getInstance().getProdutoFromCod(leitura) == null ) {
                        saida.print("Informe um codigo valido: ");
                        leitura = in.nextLine();
                    }
                    String produto = leitura;

                    saida.print("Informe a quantidade: ");
                    leitura = in.nextLine();

                    while ( !ehNumerico(leitura) || Integer.parseInt(leitura) <= 0 ) {
                        if (!ehNumerico(leitura))
                            saida.print("Insira um numero: ");
                        else
                            saida.print("Insira uma quantidade positiva: ");
                        
                        leitura = in.nextLine().trim();
                    }
                    int qtd = Integer.parseInt(leitura);

                    sistema.registrarPedido(produto, qtd);
                    break;
                case 4:
                    sistema.gerarComprovante();
                    break;
                case 5:
                    rodando = false;
                    break;
            }
        }
        in.close();
    }

    public static boolean ehNumerico(String num) {
        if (num == null) {
            return false;
        }
        try {
            @SuppressWarnings("unused")
            int d = Integer.parseInt(num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean opcaoValida(String s) {
        int valor = Integer.parseInt(s);
        return (valor >= 1 & valor <= 5);
    }
}
