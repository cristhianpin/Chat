/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import interfaz.interfaceSocketServer;
import java.util.ArrayList;
import java.util.List;
import services.ChatService;

/**
 *
 * @author Belén
 */
public class ChatRoom {
    
   private final List<ChatService> chatters = new ArrayList<>();
   private interfaceSocketServer messageSocketServer;

    public ChatRoom(interfaceSocketServer messageSocketServer) {
        this.messageSocketServer = messageSocketServer;
    }

    public synchronized void add(ChatService client) {
        chatters.add(client);
    }

    public synchronized void remove(ChatService client) {
        chatters.remove(client);
        if (messageSocketServer != null) {
            messageSocketServer.onLeave(client.getUserName());
        } else {
            System.err.println("Error: serverMessageHandler is null in ChatRoom.remove()");
        }
        updateClientList();
    }

    public synchronized void broadcast(String sender, String message, ChatService excludeClient) {
        for (ChatService client : chatters) {
            if (client != excludeClient) {
                client.putMessage(sender + ": " + message);
            }
        }
    }

    public synchronized void register(String name, ChatService client) {
            client.putMessage(name + " se ha unido al chat.");
            messageSocketServer.onJoin(name);
        }
        
    public synchronized void leave(String name, ChatService client) {
        for (ChatService c : chatters) {
            if (c != client) {
                c.putMessage(name + " se ha desconectado.");
            }
        }
        
        messageSocketServer.onLeave(name);
        updateClientList();
    }

    public synchronized void abandonarChat() {
        for (ChatService client : chatters) {
            client.putMessage("Administrador del chat room: El servidor se está cerrando. Adiós.");
            client.disconnect();
        }
        chatters.clear();
    }

    private void updateClientList() {
        if (messageSocketServer != null) {
            List<String> clientNames = new ArrayList<>();
            for (ChatService client : chatters) {
                clientNames.add(client.getUserName());
            }
        } else {
            System.err.println("Error: serverMessageHandler is null in ChatRoom.updateClientList()");
        }
    }
}
