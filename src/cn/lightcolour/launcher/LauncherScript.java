package cn.lightcolour.launcher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class LauncherScript {
    public static String java_path = System.getProperty("java.home") + "\\bin\\java.exe";
    public static String game_path = ".minecraft\\versions\\1.8.8\\1.8.8.jar";
    public static String natives_path = "C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\versions\\1.8.8\\1.8.8-natives";
    public static void write(String path,String filename) throws IOException {
        StringBuilder s = new StringBuilder();
        s.append("@echo off\n");
        s.append("set APPDATA=" + path + "\n");
        s.append("\"" + java_path + "\" -Dminecraft.client.jar=" + game_path + " -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=16M -XX:-UseAdaptiveSizePolicy -XX:-OmitStackTraceInFastThrow -Xmn128m -Xmx1792m -Dfml.ignoreInvalidMinecraftCertificates=true -Dfml.ignorePatchDiscrepancies=true -XX:HeapDumpPath=MojangTricksIntelDriversForPerformance_javaw.exe_minecraft.exe.heapdump -Djava.library.path=" + natives_path + " -Dminecraft.launcher.brand=EMCL -Dminecraft.launcher.version=1 -cp " + getLibraries("C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\versions\\1.8.8\\1.8.8.json") + "C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\versions\\1.8.8\\1.8.8.jar net.minecraft.client.main.Main --width 854 --height 480 --username Lightcolour --version \"HMCL 3.2.130\" --gameDir C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft --assetsDir C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\assets --assetIndex 1.8 --uuid 6b2a638616303c5fab54e1416327bd17 --accessToken c1f69ef2e8b04b49abd165dee3276704 --userProperties {} --userType mojang");
        WriteBat(path,"1.bat",s.toString());
    }

    public static void runScript(String path,String filename) {
        Process p;
        String cmd = path + "\\" + filename;

        try {
            p = Runtime.getRuntime().exec(cmd);
            InputStream fis=p.getInputStream();
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String line=null;
            while((line=br.readLine())!=null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getLibraries(String jsonpath) {
        String json = Utils.txtString(new File(jsonpath));
        JSONObject jsonObject = JSON.parseObject(json);
        JSONArray jsonArray = JSON.parseArray(jsonObject.get("libraries").toString());
        String re = "";
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject name_object = JSONObject.parseObject(jsonArray.get(i).toString());
            String[] libraries_arr = name_object.get("name").toString().split(":");
            String lib_path = libraries_arr[0];
            String[] lib_path_arr = lib_path.split("\\.");
            String temp = "";
            for (int j = 0; j < lib_path_arr.length; j++) {
                temp += lib_path_arr[j] + "\\";
            }
            lib_path = "C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\" + temp + libraries_arr[1] + "\\" + libraries_arr[2] + "\\" + libraries_arr[1] + "-" + libraries_arr[2] + ".jar";
            re +=lib_path + ";";
        }
        return re;
    }

    private static void WriteBat(String path,String filename,String text) throws IOException {
        FileOutputStream fileOutputStream = null;
        File file = new File(path + "\\" + filename);
        if(file.exists()) {
            file.createNewFile();
        }
        fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(text.getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }


}
