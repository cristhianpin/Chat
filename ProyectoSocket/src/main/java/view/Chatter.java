/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import cliente.ChatCliente;
import cliente.ChatCliente.MessageSocketClient;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Belén
 */
public class Chatter extends javax.swing.JFrame {
    
    private ChatCliente clienteSocket;

    /**
     * Creates new form Chatter
     */
    public Chatter() {
        initComponents();
        txtChatChatter.setEnabled(false);
        btnLogout.setEnabled(false);
        btnEnviarChatter.setEnabled(false);
        clienteSocket = new ChatCliente();
        
        // Agrega un KeyListener al campo de texto
        txtNombreChatter.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // Verifica si el carácter es una letra o un número
                if (!Character.isLetterOrDigit(c)) {
                    e.consume(); // Ignora el carácter si no cumple con los criterios
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // No necesitamos implementar este método, pero es necesario para la interfaz KeyListener
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No necesitamos implementar este método, pero es necesario para la interfaz KeyListener
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        labelTituloChatter = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreChatter = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        labelUsuarioRegistrado = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChatChatter = new javax.swing.JTextArea();
        txtMensajeChatter = new javax.swing.JTextField();
        btnEnviarChatter = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        labelTituloChatter.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTituloChatter.setText("CHAT");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nickname:");

        txtNombreChatter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreChatterActionPerformed(evt);
            }
        });

        btnIniciar.setBackground(new java.awt.Color(153, 153, 255));
        btnIniciar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        labelUsuarioRegistrado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelUsuarioRegistrado.setText("Bienvenido .......... !");
        labelUsuarioRegistrado.setToolTipText("");

        btnLogout.setBackground(new java.awt.Color(153, 153, 255));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setText("Cerrar sesión");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        txtChatChatter.setColumns(20);
        txtChatChatter.setRows(5);
        jScrollPane1.setViewportView(txtChatChatter);

        txtMensajeChatter.setToolTipText("");

        btnEnviarChatter.setBackground(new java.awt.Color(153, 153, 255));
        btnEnviarChatter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEnviarChatter.setText("Enviar");
        btnEnviarChatter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarChatterActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Saluda en el chat!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreChatter, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIniciar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMensajeChatter, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEnviarChatter))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(labelTituloChatter)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelUsuarioRegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTituloChatter)
                    .addComponent(labelUsuarioRegistrado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(txtNombreChatter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensajeChatter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviarChatter))
                .addGap(13, 13, 13)
                .addComponent(btnLogout)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel2.getAccessibleContext().setAccessibleName("labelNombreChatter");
        txtNombreChatter.getAccessibleContext().setAccessibleName("");
        btnIniciar.getAccessibleContext().setAccessibleName("btnLogin");
        labelUsuarioRegistrado.getAccessibleContext().setAccessibleName("labelNombreRegistrado");
        btnLogout.getAccessibleContext().setAccessibleName("btnLogout");
        btnLogout.getAccessibleContext().setAccessibleDescription("");
        txtMensajeChatter.getAccessibleContext().setAccessibleName("txtMensajeChatter");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreChatterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreChatterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreChatterActionPerformed

    
    private void btnEnviarChatterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarChatterActionPerformed

        String mensaje = txtMensajeChatter.getText().trim();
        String nuevoMensaje;
        if (!mensaje.isEmpty()) {
            
            nuevoMensaje = txtNombreChatter.getText()+": " + mensaje;
            clienteSocket.sendMessage("CHAT "+nuevoMensaje);
            txtChatChatter.setEditable(false);
//            txtChatChatter.append(nuevoMensaje + "\n");
            txtMensajeChatter.setEnabled(true);
            txtMensajeChatter.setText("");
            
        }
        
        System.out.print("Mensaje enviado\n");

    }//GEN-LAST:event_btnEnviarChatterActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:

            String nombre = txtNombreChatter.getText();
            if (!nombre.isEmpty()) {
                try {
//                    if (clienteSocket == null) {
//                        clienteSocket = new ChatCliente();
                        System.out.println("Usuario dentro del servidor");
                        clienteSocket.registerOnMessage(createMessageSocketClient());
                        clienteSocket.startClient(nombre);
                        System.out.println("En línea!");
                        formatoLogueado();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al iniciar el cliente: " + e.getMessage());
            }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un nombre de usuario");
    
            }

    }//GEN-LAST:event_btnIniciarActionPerformed

    
    
    
    private void formatoLogueado(){
        String nombre = txtNombreChatter.getText();
        labelUsuarioRegistrado.setText("Bienvenido " + nombre + " !");
        btnIniciar.setEnabled(false);
        btnLogout.setEnabled(true);
        btnEnviarChatter.setEnabled(true);
        txtNombreChatter.setEnabled(false); // Deshabilita la edición del nombre después de registrarse
//            clienteSocket.registerOnMessage(createMessageSocketClient());
        clienteSocket.sendMessage("LOGIN " + nombre);
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        limpiarInterfaz();
        System.out.print("Saliste del chat\n");
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
                new Chatter().setVisible(true);
        });
    }


    private MessageSocketClient createMessageSocketClient() {
        return new MessageSocketClient() {
            @Override
            public void onMessage(String response) {
                txtChatChatter.append(response + "\n");
            }

            @Override
            public void onServerClosed() {
//                JOptionPane.showMessageDialog(null, "El servidor está cerrado!");
                limpiarInterfaz();
            }

            @Override
            public void onLogout() {
                JOptionPane.showMessageDialog(null, "Te has desconectado del servidor!");
                limpiarInterfaz();
            }

        };
    }
    
    private void limpiarInterfaz() {
        labelUsuarioRegistrado.setText("");
        txtNombreChatter.setText("");
        txtMensajeChatter.setText("");
        txtChatChatter.setText("");
        btnIniciar.setEnabled(true);
        btnLogout.setEnabled(false);
        btnEnviarChatter.setEnabled(false);
        txtNombreChatter.setEnabled(true);
        if (clienteSocket != null) {
            clienteSocket.disconnect();
        }
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarChatter;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTituloChatter;
    private javax.swing.JLabel labelUsuarioRegistrado;
    private javax.swing.JTextArea txtChatChatter;
    private javax.swing.JTextField txtMensajeChatter;
    private javax.swing.JTextField txtNombreChatter;
    // End of variables declaration//GEN-END:variables
}

