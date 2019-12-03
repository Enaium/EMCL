package cn.lightcolour.launcher;

import java.io.*;

public class Main
{
    public static void main(final String[] args) throws IOException {
        LauncherScript.ShowLibraries("C:\\Users\\lightcolour\\Desktop\\HMCL\\.minecraft\\versions\\1.8.8\\1.8.8.json");
        LauncherScript.write("C:\\Users\\lightcolour\\Desktop","1.bat");
//        LauncherScript.runScript("C:\\Users\\lightcolour\\Desktop","1.bat");
    }
}
