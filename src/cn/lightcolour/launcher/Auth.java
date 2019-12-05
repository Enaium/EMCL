package cn.lightcolour.launcher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Auth {

    public static String getUUID(String id) throws IOException {
        String url = "https://api.mojang.com/users/profiles/minecraft/" + id;
        String s = Utils.request(url);
        return JSON.parseObject(s).get("id").toString();
    }

    public static String Auth(final String username, final String password) throws IOException {
        final URL url = new URL("https://authserver.mojang.com/authenticate");
        final HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        conn.setUseCaches(false);
        conn.setInstanceFollowRedirects(true);
        conn.setConnectTimeout(20000);
        conn.setReadTimeout(300000);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.connect();
        final DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        final String json = "{\"agent\": {\"name\": \"Minecraft\",\"version\": 1},\"username\": \"" + username
                + "\",\"password\": \"" + password + "\"}";
        out.writeBytes(json);
        final DataInputStream in = new DataInputStream(conn.getInputStream());
        return in.readLine();
    }
}
