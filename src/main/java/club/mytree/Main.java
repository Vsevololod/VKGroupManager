package club.mytree;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Timer;

public class Main {
    static String GROUP_NAME = "finalfoto";

    public static void main(String[] args) {
        try {
            startServer();
            startClientVk();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startClientVk(){
        UpdateDBOnTimer updateTask = new UpdateDBOnTimer();
        Timer timer = new Timer();
        timer.schedule(updateTask,1000,1000*60);
    }


    private static void startServer() throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8080), 0);

        HttpContext context = server.createContext("/", new JsonReqHandler("main"));
        HttpContext contextOnline = server.createContext("/online", new JsonReqHandler("online"));
        //context.setAuthenticator(new Auth());

        server.setExecutor(null);
        server.start();
    }
}
