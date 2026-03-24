package Projeet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientChatIHM extends JFrame {
    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    private JTextArea zoneMessages;
    private JTextField champMessage;
    private JButton boutonEnvoyer;

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String pseudo;

    public ClientChatIHM() {
        pseudo = JOptionPane.showInputDialog(this, "Entrez votre pseudo :");

        if (pseudo == null || pseudo.trim().isEmpty()) {
            pseudo = "Anonyme";
        }

        setTitle("Chat - " + pseudo);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        zoneMessages = new JTextArea();
        zoneMessages.setEditable(false);

        champMessage = new JTextField();
        boutonEnvoyer = new JButton("Envoyer");

        JScrollPane scrollPane = new JScrollPane(zoneMessages);

        JPanel bas = new JPanel(new BorderLayout());
        bas.add(champMessage, BorderLayout.CENTER);
        bas.add(boutonEnvoyer, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bas, BorderLayout.SOUTH);

        boutonEnvoyer.addActionListener(e -> envoyer());
        champMessage.addActionListener(e -> envoyer());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if (out != null) {
                        out.println("/quit");
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        connecter();
    }

    private void connecter() {
        try {
            socket = new Socket(HOST, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println(pseudo);

            Thread t = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        String msg = message;
                        SwingUtilities.invokeLater(() -> zoneMessages.append(msg + "\n"));
                    }
                } catch (Exception e) {
                    SwingUtilities.invokeLater(() ->
                            zoneMessages.append("Déconnecté du serveur.\n"));
                }
            });
            t.start();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Impossible de se connecter au serveur.");
        }
    }

    private void envoyer() {
        String message = champMessage.getText().trim();

        if (!message.isEmpty()) {
            out.println(message);
            champMessage.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClientChatIHM gui = new ClientChatIHM();
            gui.setVisible(true);
        });
    }
}