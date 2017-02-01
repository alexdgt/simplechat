package sample;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by john on 31.01.2017.
 */
public class ChatClient {
    Controller controller;

    Socket socket;
    BufferedReader reader;
    PrintWriter writer;

    public ChatClient(Controller controller) {
        this.controller = controller;
    }

    public void go() {
        println("starting client...");
        setUpNetworking();
        //starting reading thread
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
    }
    //setting up connection
    public void setUpNetworking() {
        println("setting up network connection");

        try {
            socket = new Socket("127.0.0.1", 5000);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
            println("connection established");
        }catch (IOException ex){
            println("connection faild");
        }

    }
    public void sendMessage(String message){
        try {
            writer.println(message);
            writer.flush();
        }catch (Exception ex){println("sending message error");}

    }

    //print line and cr
    private void println(String string){
        controller.getIncomingTextArea().appendText(string+"\n");
    }


    class IncomingReader implements Runnable{

        @Override
        public void run() {
            String message;
            try{
                while ((message = reader.readLine()) != null){
                    println(message);
                }

            }catch (IOException ex){
                println("io exception");
            }


        }
    }

}
