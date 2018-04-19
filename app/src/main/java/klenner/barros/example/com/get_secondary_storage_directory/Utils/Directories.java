package klenner.barros.example.com.get_secondary_storage_directory.Utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Directories {

    private final static List<String> sdCardPossiblePath = Arrays.asList("external_sd", "ext_sd", "external", "extSdCard", "sdcard2", "media_rw");

    public static String getPrimaryStoreDir() {
        return Environment.getExternalStorageDirectory().toString();
    }
    public static String getSecondaryStoreDir(Context context) {
        String secStore = null;
        try {
            File[] externalFilesDirs = context.getExternalFilesDirs(null);
            if (externalFilesDirs != null && externalFilesDirs.length > 1 && externalFilesDirs[1] != null) {
                secStore = externalFilesDirs[1].getAbsolutePath();
                secStore=secStore.split("Android")[0];
            } if (secStore==null) {
                for (String sdPath : sdCardPossiblePath) {
                    File file = new File("/mnt/", sdPath);
                    if (file.exists() && file.isDirectory() && file.canWrite()) {
                        try {
                            secStore = file.getAbsolutePath();
                        }catch (Exception e){
                            Log.e("",e.getMessage(),e);
                            secStore=null;
                        }
                    }
                }
                if (secStore == null) {
                    secStore = System.getenv("SECONDARY_STORAGE");
                }
            }
        }catch (Exception e){
            Log.e("",e.getMessage(),e);
        }
        return secStore;
    }
}
