package club.mytree;

import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Timer;

//import org.apache.commons.cli.*;

public class Main {
    static String GROUP_NAME = "finalfoto";
    private static Integer INET_PORT = 8080;
    private static String INET_ADDRESS = "";

    /**/
    private static boolean parseArgs(String[] args){
        Options options = new Options();

        Option group = new Option("g", "group", true, "group to watch");
        group.setRequired(true);
        options.addOption(group);

        Option port = new Option("p", "port", true, "bind port");
        port.setRequired(false);
        options.addOption(port);

        Option output = new Option("i", "address", true, "bind inet address");
        output.setRequired(false);
        output.setType(Number.class);
        options.addOption(output);


        CommandLineParser parser = new BasicParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
            return false;
        }

        if(cmd.hasOption("group")){
            GROUP_NAME = cmd.getOptionValue("group");
        }
        if(cmd.hasOption("port")){
            INET_PORT= new Integer(cmd.getOptionValue("port"));
        }
        if(cmd.hasOption("address")){
            INET_ADDRESS = cmd.getOptionValue("address");
        }
        return true;
    }

    public static void main(String[] args) {
        if(parseArgs(args)) {
            try {
                startServer();
                startClientVk();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startClientVk(){
        UpdateDBOnTimer updateTask = new UpdateDBOnTimer();
        Timer timer = new Timer();
        timer.schedule(updateTask,1000,1000*60);
    }


    private static void startServer() throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(INET_ADDRESS,INET_PORT), 0);

        HttpContext context = server.createContext("/index.html", new StaticHandle());
        HttpContext contextOnline = server.createContext("/online", new JsonReqHandler("online"));
        HttpContext contextStatic = server.createContext("/static", new StaticHandle());
        contextOnline.setAuthenticator(new BasicAuthenticator("") {
            @Override
            public boolean checkCredentials(String user, String pwd) {
                return user.equals("test") && pwd.equals("test");
            }
        });


        //context.setAuthenticator(new Auth());

        server.setExecutor(null);
        server.start();
    }
}
