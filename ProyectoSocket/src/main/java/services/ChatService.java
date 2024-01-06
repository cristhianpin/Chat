/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import modelo.ChatRoom;



/**
 *
 * @author Belén
 */
public class ChatService implements Runnable{
    
    private final Socket socket;
    private final ChatRoom chatRoom;
    private final PrintWriter out;
    private final BufferedReader in;
    private String userName;

    public ChatService(Socket socket, ChatRoom chatRoom) throws IOException {
        this.socket = socket;
        this.chatRoom = chatRoom;
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!in.ready()) continue;
                String line = in.readLine();
                int commandDelimiterPos = line.indexOf(' ');
                if (commandDelimiterPos < 0) commandDelimiterPos = line.length();
                String command = line.substring(0, commandDelimiterPos);
                line = line.substring(commandDelimiterPos);
                
                System.out.println("Comando recibido: " + command); // Agrega esta línea para imprimir el comando

                String response = executeCommand(command, line);
                putMessage(response);
            }
        } catch (IOException e) {
            handleDisconnect();
        }
    }

    public void putMessage(String msg) {
        if (out != null) {
            out.println(msg);
        }
    }

    public String executeCommand(String command, String line) throws IOException {
        System.out.println("Comando recibido: " + command);  // Agrega esta línea
        System.out.println("Mensaje recibido: " + line);    // Agrega esta línea
        
        if (command.equals("LOGIN")) {
            userName = line;
            chatRoom.register(userName, this);
            chatRoom.broadcast(userName, "LOGIN", this);
            return "Admin: Bienvenido, " + userName + ".";
        } else if (command.equals("CHAT")) {
            String message = line;
            chatRoom.broadcast(userName, message, this);
            return message;
        } else if (command.equals("LOGOUT")) {
            handleDisconnect();
            return "Adios!";
        } else {
            return "Administrador del chat room: Comando inválido";
        }
    }

    public String getUserName() {
        return userName;
    }

    public void disconnect() {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar el socket: " + e.getMessage());
        }
    }

    private void handleDisconnect() {
        chatRoom.leave(userName, this);
        disconnect();
    }
    }