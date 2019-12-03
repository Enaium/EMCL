package cn.lightcolour.launcher;

import java.io.IOException;


public class Auth {
    public static String Check() throws IOException {
        String url = "https://status.mojang.com/check";
        String s = Utils.requset(url);
        String re = "";
        s = Utils.getSubString(s,"[","]");
        String[] arr = s.split(",");
        for (int i = 0;arr.length > i;i++) {
            String[] a = Utils.getSubString(arr[i],"{","}").split(":");
            String left = Utils.getSubString(a[0],"\"","\"");
            String right = Utils.getSubString(a[1],"\"","\"");
            re += "Server:" + left + "," + "Check:" + right + "\n";
        }
        return re;
    }

    public static String getUUID(String id) throws IOException {
        String url = "https://api.mojang.com/users/profiles/minecraft/" + id;
        String s = Utils.requset(url);
        s = Utils.getSubString(s,"{","}");
        String[] arr = s.split(",");
        for (int i = 0;arr.length > i;i++) {
            String[] a = arr[i].split(":");
            String left = a[0];
            String right = a[1];
            if(left.equals("\"id\"")) {
                return Utils.getSubString(right,"\"","\"");
            }
        }
        return "";
    }
}
