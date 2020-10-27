import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        final int PORTA = 1234;
        ServerSocket server = null;
        Socket cliente = null;
        Scanner entrada = null;
        PrintStream saida = null;
        String mensagem = "";

        try {
            server = new ServerSocket(PORTA);
        } catch (Exception e) {
            System.out.println("Porta " + PORTA + " em uso");
            return;
        }

        try {

            // Fazer regra de conectar apenas 2 jogadores

            System.out.println("Aguardando conexão...");
            cliente = server.accept();

            System.out.println("Conectado com " + cliente.getInetAddress().getHostAddress());

            entrada = new Scanner(cliente.getInputStream());

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            do {
                mensagem = entrada.nextLine();
                System.out.println(mensagem);

                saida = new PrintStream(cliente.getOutputStream());
                saida.println("Recebi sua mensagem cliente!");
            } while (true);
        } catch (Exception e) {
            System.out.println("Erro durante a comunicação com o cliente.");
        }
    }
}