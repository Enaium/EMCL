package cn.lightcolour.launcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Auth {

    public static String Check() throws IOException {
        String url = "https://status.mojang.com/check";
        String s = getpost(url);
        String re = "";
        s = getSubString(s,"[","]");
        String[] arr = s.split(",");
        for (int i = 0;arr.length > i;i++) {
            String[] a = getSubString(arr[i],"{","}").split(":");
            String left = getSubString(a[0],"\"","\"");
            String right = getSubString(a[1],"\"","\"");
            re += "Server:" + left + "," + "Check:" + right + "\n";
        }
        return re;
    }

    public static String getUUID(String id) throws IOException {
        String url = "https://api.mojang.com/users/profiles/minecraft/" + id;
        String s = getpost(url);
        s = getSubString(s,"{","}");
        String[] arr = s.split(",");
        for (int i = 0;arr.length > i;i++) {
            String[] a = arr[i].split(":");
            String left = a[0];
            String right = a[1];
            if(left.equals("\"id\"")) {
                return getSubString(right,"\"","\"");
            }
        }
        return "";
    }


    private static String getpost(String url) throws IOException {
        String result = "";
        BufferedReader in = null;
        String urlNameString = url;
        URL realUrl = new URL(urlNameString);
        URLConnection connection = realUrl.openConnection();
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        connection.connect();

        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }

        return result;
    }

    private static String getSubString(String text, String left, String right) {
        String result = "";
        int zLen;
        if (left == null || left.isEmpty()) {
            zLen = 0;
        } else {
            zLen = text.indexOf(left);
            if (zLen > -1) {
                zLen += left.length();
            } else {
                zLen = 0;
            }
        }
        int yLen = text.indexOf(right, zLen);
        if (yLen < 0 || right == null || right.isEmpty()) {
            yLen = text.length();
        }
        result = text.substring(zLen, yLen);
        return result;

    }
}
