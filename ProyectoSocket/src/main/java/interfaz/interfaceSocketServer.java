/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

/**
 *
 * @author Belén
 */
public interface interfaceSocketServer {
    void onJoin(String name);
    void onLeave(String name);
    void log(String message);
    
}
