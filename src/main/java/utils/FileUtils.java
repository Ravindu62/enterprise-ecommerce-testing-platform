package utils;

import java.io.File;


public class FileUtils {


    private FileUtils(){

    }



    public static boolean isFileExists(
            String path){


        File file =
                new File(path);


        return file.exists();

    }



    public static void createDirectory(
            String path){


        File directory =
                new File(path);


        if(!directory.exists()){

            directory.mkdirs();

        }

    }


}