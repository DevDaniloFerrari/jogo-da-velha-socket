import java.net.Socket;

public class Jogador extends Thread {

    Socket cliente;
    Comunicacao comunicacao;

    public Jogador(Socket cliente) {
        this.cliente = cliente;
        // comunicacao = new Comunicacao(cliente);
    }

    @Override
    public void run() {

        try {
            cliente.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

}
