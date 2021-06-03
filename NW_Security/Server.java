import java.net.*;
import java.io.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class Server extends Thread {
    private ServerSocket serverSocket;

    private String plainText = "Advanced Network Security - MTECH CSE , NITW";

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();

                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());

                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                EncryptDecrypt();
                out.writeUTF("Connecting to " + server.getLocalSocketAddress()
                        + "\nThe text has been encrypted and Decrypted using RSA!");
                server.close();

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void EncryptDecrypt() throws Exception {
        // Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withRSA");

        // Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        // Initializing the key pair generator
        keyPairGen.initialize(2048);

        // Generate the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        // Getting the public key from the key pair
        PublicKey publicKey = pair.getPublic();

        // Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        // Initializing a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        // Add data to the cipher
        byte[] input = plainText.getBytes();
        cipher.update(input);

        // encrypting the data
        byte[] cipherText = cipher.doFinal();
        System.out.println("Encrypted Text : ");
        System.out.println(new String(cipherText, "UTF8"));

        // Initializing the same cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());

        // Decrypting the text
        byte[] decipheredText = cipher.doFinal(cipherText);
        System.out.println("Decrypted Text : ");
        System.out.println(new String(decipheredText));
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new Server(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean bfs(int source, int goal, int graph[][]) {
        boolean pathFound = false;
        int destination, element;
        for (int vertex = 1; vertex <= numberOfVertices; vertex++) {
            parent[vertex] = -1;
            visited[vertex] = false;
        }
        queue.add(source);
        parent[source] = -1;
        visited[source] = true;

        while (!queue.isEmpty()) {
            element = queue.remove();
            destination = 1;
            while (destination <= numberOfVertices) {
                if (graph[element][destination] > 0 && !visited[destination]) {
                    parent[destination] = element;
                    queue.add(destination);
                    visited[destination] = true;
                }
                destination++;
            }
        }

        if (visited[goal]) {
            pathFound = true;
        }
        return pathFound;
    }
}