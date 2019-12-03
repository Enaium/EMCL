package cn.lightcolour.launcher;

import java.io.*;

public class LauncherScript {
    public static void write(String path,String filename) throws IOException {
        StringBuilder s = new StringBuilder();
        s.append("@echo off\n");
        s.append("set APPDATA=" + path + "\n");
        s.append("\"C:\\Program Files\\Java\\jdk1.8.0_221\\jre\\bin\\java.exe\" -Dminecraft.client.jar=.minecraft\\versions\\1.8.8\\1.8.8.jar -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=16M -XX:-UseAdaptiveSizePolicy -XX:-OmitStackTraceInFastThrow -Xmn128m -Xmx1792m -Dfml.ignoreInvalidMinecraftCertificates=true -Dfml.ignorePatchDiscrepancies=true -XX:HeapDumpPath=MojangTricksIntelDriversForPerformance_javaw.exe_minecraft.exe.heapdump -Djava.library.path=C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\versions\\1.8.8\\1.8.8-natives -Dminecraft.launcher.brand=HMCL -Dminecraft.launcher.version=3.2.130 -cp C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\oshi-project\\oshi-core\\1.1\\oshi-core-1.1.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\java3d\\vecmath\\1.5.2\\vecmath-1.5.2.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\net\\java\\dev\\jna\\jna\\3.4.0\\jna-3.4.0.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\net\\java\\dev\\jna\\platform\\3.4.0\\platform-3.4.0.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\com\\ibm\\icu\\icu4j-core-mojang\\51.2\\icu4j-core-mojang-51.2.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\net\\sf\\jopt-simple\\jopt-simple\\4.6\\jopt-simple-4.6.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\com\\paulscode\\codecjorbis\\20101023\\codecjorbis-20101023.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\com\\paulscode\\codecwav\\20101023\\codecwav-20101023.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\com\\paulscode\\libraryjavasound\\20101123\\libraryjavasound-20101123.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\com\\paulscode\\librarylwjglopenal\\20100824\\librarylwjglopenal-20100824.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\com\\paulscode\\soundsystem\\20120107\\soundsystem-20120107.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\io\\netty\\netty-all\\4.0.23.Final\\netty-all-4.0.23.Final.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\com\\google\\guava\\guava\\17.0\\guava-17.0.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\org\\apache\\commons\\commons-lang3\\3.3.2\\commons-lang3-3.3.2.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\commons-io\\commons-io\\2.4\\commons-io-2.4.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\commons-codec\\commons-codec\\1.9\\commons-codec-1.9.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\net\\java\\jinput\\jinput\\2.0.5\\jinput-2.0.5.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\net\\java\\jutils\\jutils\\1.0.0\\jutils-1.0.0.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\com\\google\\code\\gson\\gson\\2.2.4\\gson-2.2.4.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\com\\mojang\\authlib\\1.5.21\\authlib-1.5.21.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\com\\mojang\\realms\\1.7.48\\realms-1.7.48.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\org\\apache\\commons\\commons-compress\\1.8.1\\commons-compress-1.8.1.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\org\\apache\\httpcomponents\\httpclient\\4.3.3\\httpclient-4.3.3.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\commons-logging\\commons-logging\\1.1.3\\commons-logging-1.1.3.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\org\\apache\\httpcomponents\\httpcore\\4.3.2\\httpcore-4.3.2.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\org\\apache\\logging\\log4j\\log4j-api\\2.0-beta9\\log4j-api-2.0-beta9.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\org\\apache\\logging\\log4j\\log4j-core\\2.0-beta9\\log4j-core-2.0-beta9.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\org\\lwjgl\\lwjgl\\lwjgl\\2.9.4-nightly-20150209\\lwjgl-2.9.4-nightly-20150209.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\org\\lwjgl\\lwjgl\\lwjgl_util\\2.9.4-nightly-20150209\\lwjgl_util-2.9.4-nightly-20150209.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\libraries\\tv\\twitch\\twitch\\6.5\\twitch-6.5.jar;C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\versions\\1.8.8\\1.8.8.jar net.minecraft.client.main.Main --width 854 --height 480 --username Lightcolour --version \"HMCL 3.2.130\" --gameDir C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft --assetsDir C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\assets --assetIndex 1.8 --uuid 6b2a638616303c5fab54e1416327bd17 --accessToken c1f69ef2e8b04b49abd165dee3276704 --userProperties {} --userType mojang");
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

    public static void WriteBat(String path,String filename,String text) throws IOException {
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
