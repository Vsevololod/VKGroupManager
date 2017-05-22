package club.mytree;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by vsevo on 09.04.17.
 * test version
 */

class VkClient {

    private static final String baseVkUrl = "https://api.vk.com/method/";
    private static final String USERS_GET_METHOD = "users.get";
    private static final String GROUPS_GET_MEMBERS_METHOD = "groups.getMembers";

    private HttpClient client;

    static int[] parseUsersInGroup(String str){
        JSONObject main = (JSONObject) JSON.parse(str);
        JSONObject res = main.getJSONObject("response");
        int users[] = new int[res.getInteger("count")];
        int i =0;
        for(Object item : res.getJSONArray("items") ){
            users[i++]= (int)item;
        }
        return users;
    }

    static List<UserOnline> parseOnlineUsers(String str) {
        List<UserOnline> onlineUsers = new LinkedList<>();
        JSONObject main = (JSONObject) JSON.parse(str);
        int i = 0;
        JSONObject temp;
        for (Object item : main.getJSONArray("response")) {
            temp = (JSONObject) item;
            onlineUsers.add(new UserOnline(temp.getInteger("uid"), temp.getInteger("online")));
            i++;
        }
        return onlineUsers;
    }

    private HttpGet createRequest(String method, List<NameValuePair> params){
        String url = baseVkUrl + method+"?";

        params.add(new BasicNameValuePair("v", "5.52"));
        String paramString = URLEncodedUtils.format(params, "utf-8");

        url += paramString;
        HttpGet request = new HttpGet(url);
        request.setHeader("Cookie", "remixlang=0;");
        request.setHeader("Accept-Encoding", "gzip");
        request.addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");

        return request;
    }

    String getUsersInGroup(String group_id) {
        String r="";
        List<NameValuePair> params = new LinkedList<>();
        params.add(new BasicNameValuePair("group_id", group_id));

        HttpGet req = createRequest(GROUPS_GET_MEMBERS_METHOD,params);
        try {
            HttpResponse response = client.execute(req);
            r = getResponseString(response);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return r;
    }

    String isUsersOnline(int[] users) {
        String r = "";

        StringBuilder usersIds = new StringBuilder();
        for(int userId : users){
            usersIds.append(userId).append(',');
        }

        List<NameValuePair> params = new LinkedList<>();
        params.add(new BasicNameValuePair("user_ids",usersIds.toString()));
        params.add(new BasicNameValuePair("fields","online"));


        HttpPost rq = new HttpPost(baseVkUrl+USERS_GET_METHOD);
        rq.setHeader("Cookie", "remixlang=0;");
        rq.setHeader("Accept-Encoding", "gzip");
        rq.addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");


        try {
            rq.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse response = client.execute(rq);
            r = getResponseString(response);
            int i=0;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
    }

    VkClient() {
        client = HttpClientBuilder.create().build();
    }

    private String getResponseString(HttpResponse lastResponse) {
        StringBuilder result = new StringBuilder();
        try (
                BufferedReader rd = new BufferedReader(
                        new InputStreamReader(lastResponse.getEntity().getContent()))
        ) {
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result.toString();
    }
}
