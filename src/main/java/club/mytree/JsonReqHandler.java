package club.mytree;

import com.alibaba.fastjson.JSON;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vsevo on 26.04.17.
 * test version
 */
public class JsonReqHandler implements HttpHandler {
    String type;
    SQLiteConnection sql;

    JsonReqHandler(String type) {
        this.type = type;
        sql = new SQLiteConnection(Main.GROUP_NAME);
    }

    private static Map<String, String> splitQuery(String query) {
        Map<String, String> query_pairs = new LinkedHashMap<>();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            try {
                query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return query_pairs;
    }


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String r = getResult(httpExchange.getRequestURI().getQuery());
        byte[] bytes = r.getBytes();
        httpExchange.getResponseHeaders().add("Content-Type", "application/json");
        httpExchange.sendResponseHeaders(200, bytes.length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(bytes);
        os.close();
    }

    private String getResult(String query) {
        switch (type) {
            case "main":
                return JSON.toJSONString(sql.getAllData());
            case "online":
                Map<String, String> query_pairs = splitQuery(query);//1493820000,1494000000

                return JSON.toJSONString(sql.getUsersOnline(
                        Integer.parseInt(query_pairs.get("start")),
                        Integer.parseInt(query_pairs.get("end"))
                ));
            default:
                throw new IllegalArgumentException("not implemented");
        }
    }
}
