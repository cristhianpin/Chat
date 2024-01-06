
package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Belén
 */
public class ChatCliente{
    
    private String nombre;
    private Socket socket;
    private final int PORT = 8888;
    private ExecutorService service;
    private BufferedReader lector;
    public MessageSocketClient messageSocketClient;
    private PrintWriter escritor;
    private Future<?> listeningTask;

    public interface MessageSocketClient {
        void onMessage(String mensaje);
        void onServerClosed();
        void onLogout();
    }

    public ChatCliente(){
        service = Executors.newFixedThreadPool(2);
    }

    public void sendMessage(String mensaje) {
        if (escritor != null) {
            System.out.println("Enviando mensaje: " + mensaje);  // Agrega esta línea
            escritor.println(mensaje);
        }
    }

    public void registerOnMessage(MessageSocketClient messageSocketClient) {
        this.messageSocketClient = messageSocketClient;
    }

    public void disconnect() {        
        try {
            if (socket != null && !socket.isClosed()) {
                // Enviar un mensaje al servidor indicando que el cliente se está desconectando
                sendMessage("LOGOUT");
                escritor.close();
                lector.close();
                socket.close();
            }
        } catch (IOException e) {
            if (messageSocketClient != null) {
            }
        }
    }

    public void startClient(String nombre) throws IOException {
        this.nombre = nombre;
        // Inicializa y ejecuta el cliente en el hilo actual
        socket = new Socket("localhost", PORT);
        System.out.print("Usuario agregado "+ nombre+"\n");
        lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        escritor = new PrintWriter(socket.getOutputStream(), true);

        listenToServer();
    }

    private void listenToServer() {
        listeningTask = service.submit(() -> {
            try {
                String mensajeDesdeServidor;
                while (!socket.isClosed() && (mensajeDesdeServidor = lector.readLine()) != null) {
                    if (messageSocketClient != null) {
                        messageSocketClient.onMessage(mensajeDesdeServidor);
                    }
                }
            } catch (IOException e) {
                // Ocurrió un error al conectar o leer del servidor
                if (messageSocketClient != null) {
                    messageSocketClient.onServerClosed();
                }
            } finally {
                if (messageSocketClient != null) {
                    messageSocketClient.onLogout();
                }
            }
        });
    }
    }