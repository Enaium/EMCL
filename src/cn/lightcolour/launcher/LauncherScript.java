package cn.lightcolour.launcher;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class LauncherScript {
    private static String APPDATA = System.getenv("APPDATA");
    public static void writeScript(String path,String filename,String java_path,String game_path,String natives_path,String json_path,int min_memory,int max_memory,int width_window,int height_window,String id) throws IOException {
        StringBuilder s = new StringBuilder();
        s.append("@echo off\n");
        s.append("set APPDATA=" + path + "\n");
        s.append("\""
                + java_path
                + "\" -Dminecraft.client.jar="
                + game_path
                + " -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=16M -XX:-UseAdaptiveSizePolicy -XX:-OmitStackTraceInFastThrow "
                + "-Xmn"
                + min_memory
                + "m -Xmx"
                + max_memory
                + "m -Dfml.ignoreInvalidMinecraftCertificates=true -Dfml.ignorePatchDiscrepancies=true -XX:HeapDumpPath=MojangTricksIntelDriversForPerformance_javaw.exe_minecraft.exe.heapdump -Djava.library.path="
                + natives_path
                + " -Dminecraft.launcher.brand=EMCL -Dminecraft.launcher.version=1.0 "
                + "-cp "
                + getLibraries(json_path)
                + game_path
                + " "
                + getmainClass(json_path)
                + " "
                + "--width "
                + width_window
                + " " +
                "--height "
                + height_window
                + " "
                + "--username "
                + id
                + " --version \"EMCL 1.0\" "
                + "--gameDir "
                + APPDATA + "\\.minecraft"
                + " "
                + "--assetsDir "
                + APPDATA + "\\.minecraft\\assets"
                + " "
                + "--assetIndex "
                + getassetIndex(json_path)
                + " --uuid 6b2a638616303c5fab54e1416327bd17 --accessToken c1f69ef2e8b04b49abd165dee3276704 --userProperties {} --userType mojang");
        WriteBat(path,filename,s.toString());
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

    public static void CheckFile() {

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
            lib_path = APPDATA + "\\.minecraft\\libraries\\" + temp + libraries_arr[1] + "\\" + libraries_arr[2] + "\\" + libraries_arr[1] + "-" + libraries_arr[2] + ".jar";
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

    private static String getassetIndex(String json_path) {
        File file = new File(json_path);
        String json = Utils.txtString(file);
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject assetIndexObject = JSONObject.parseObject(jsonObject.getString("assetIndex"));
        return assetIndexObject.get("id").toString();
    }

    private static String getmainClass(String json_path) {
        File file = new File(json_path);
        JSONObject jsonObject = JSON.parseObject(Utils.txtString(file));
        return jsonObject.get("mainClass").toString();
    }

}
