/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ChatRoom;
import services.ChatService;

/**
 *
 * @author Belén
 */
public class ChatServer {
    
    private final ChatRoom chatRoom;
    private final int PORT = 8888;
    private final ExecutorService executorService;
    private ServerSocket serverSocket;

    public ChatServer(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
        this.executorService = Executors.newCachedThreadPool();
    }

    public void startServer() throws IOException {
        executorService.submit(() -> {
        try{
            serverSocket = new ServerSocket(PORT);
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                ChatService chatService = new ChatService(socket, chatRoom);
                chatRoom.add(chatService);
                executorService.execute((Runnable) chatService);}
        }   catch (IOException ex) {
                Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void stopServer() throws IOException {
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        }
        executorService.shutdownNow();
    }
    }