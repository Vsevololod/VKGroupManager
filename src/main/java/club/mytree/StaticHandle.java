package club.mytree;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * Created by vsevo on 22.05.17.
 * test version
 */
public class StaticHandle implements HttpHandler {

    @Override
    public void handle(HttpExchange t) throws IOException {
        String root = "./static";
        URI uri = t.getRequestURI();
        System.out.println("looking for: "+ root + uri.getPath());
        String path = uri.getPath();
        File file = new File(root + path).getCanonicalFile();


        if (!file.isFile()) {
            // Object does not exist or is not a file: reject with 404 error.
            String response = "404 (Not Found)\n";
            t.sendResponseHeaders(404, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            // Object exists and is a file: accept with response code 200.
            String mime = "text/html";
            if(path.substring(path.length()-3).equals(".js")) mime = "application/javascript";
            if(path.substring(path.length()-3).equals("css")) mime = "text/css";

            Headers h = t.getResponseHeaders();
            h.set("Content-Type", mime);
            t.sendResponseHeaders(200, 0);

            OutputStream os = t.getResponseBody();
            FileInputStream fs = new FileInputStream(file);
            final byte[] buffer = new byte[0x10000];
            int count;
            while ((count = fs.read(buffer)) >= 0) {
                os.write(buffer,0,count);
            }
            fs.close();
            os.close();
        }
    }
}
