package com.smallclover.utils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by smallclover on 2016/8/23.
 */
public class FileKit {

    private static Map<String, Object> fileInfo = null;

    /**
     *
     * @param file
     * @return
     */
    public static Map<String,Object> getPictureInfo(File file){

        fileInfo = new HashMap<>();

        fileInfo.put("name",file.getName());//文件名称
        fileInfo.put("isExist", file.exists());//文件是否存在
        fileInfo.put("path", file.getPath());//文件的相对路径
        fileInfo.put("AbsoulutePath", file.getAbsolutePath());//文件的绝对路径
        fileInfo.put("Parent", file.getParent());//文件的上一级路径
        fileInfo.put("isFile", file.isFile());//是否是文件类型
        fileInfo.put("isDirectory", file.isDirectory());//是否是文件夹类型
        fileInfo.put("length", file.length());//文件大小
        fileInfo.put("lastModifiedTime", new Date(file.lastModified()));//文件最后修改时间

/*        System.out.println("文件名称：" + file.getName());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件的相对路径：" + file.getPath());
        System.out.println("文件的绝对路径：" + file.getAbsolutePath());
        System.out.println("文件可以读取：" + file.canRead());
        System.out.println("文件可以写入：" + file.canWrite());
        System.out.println("文件上级路径：" + file.getParent());
        System.out.println("文件大小：" + file.length() + "B");
        System.out.println("文件最后修改时间：" + new Date(file.lastModified()));
        System.out.println("是否是文件类型：" + file.isFile());
        System.out.println("是否是文件夹类型：" + file.isDirectory());*/
        return fileInfo;
    }
}
