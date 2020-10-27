import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        final String IP = "127.0.0.1";
        final int PORTA = 1234;

        Socket socket = null;
        PrintStream output = null;

        Scanner entrada;
        Scanner teclado = new Scanner(System.in);
        String mensagem;

        try {
            socket = new Socket(IP, PORTA);
            System.out.println("Conectado com o servidor.");

            output = new PrintStream(socket.getOutputStream());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            do {
                System.out.println("Digite uma mensagem:");
                mensagem = teclado.nextLine();
                output.println(mensagem);

                entrada = new Scanner(socket.getInputStream());
                entrada.nextLine();
            } while (true);
        } catch (Exception e) {
            System.out.println("Erro na etapa de comunicação.");
        }

        // encerra a conexão
        try {
            socket.close();
            System.out.println("Terminada a conexão.");
        } catch (Exception e) {
            System.out.println("Erro ao encerrar a conexão.");
        }

    }
}