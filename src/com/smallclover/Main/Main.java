package com.smallclover.Main;

import com.smallclover.utils.StrKit;

import java.io.*;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by smallclover on 2016/7/13.
 *
 * 360浏览器图片获取，前提是本地缓存已经存在
 *
 */
public class Main {

    /*public static final String filePath = "D:\\360\\360Chrome\\Chrome\\User Data\\Default\\Wallpapers";
    //D:\360\360Chrome\Chrome\User Data\Default\Wallpapers
    //C:\Users\asus\Desktop\pic
    */
//    public static final String DEFAULT_STOREPATH = "C:\\Users\\asus\\Desktop\\pic";
    public static final String DEFAULT_STOREPATH = System.getProperty("user.home") + "\\Desktop\\pic";//用户主目录，程序在哪里执行，哪里就是主目录
    public static String filePath;//缓存目录
    public static String storePath;//指定的存储位置
    private static int bigPicNumber = 0;
    private static int smallPicNumber = 0;

    private static void modifiedPictureType(String picName){
    }

    /**
     * 创建指定的存储目录
     * @param filePath_1
     * @param storePath_1
     * @return
     */
    public static boolean createMkdirs(String filePath_1, String storePath_1){
        if(StrKit.isBlank(filePath_1)){
            System.out.println("缓存目录不可以为空");
        }
        if(StrKit.isBlank(storePath_1)){
            System.out.println("指定的存储目录为空，将使用默认的存储目录，存储位置为程序运行的目录的pic文件下");
            storePath = DEFAULT_STOREPATH;
        }else {
            storePath = storePath_1;
        }
        filePath = filePath_1;
        File file = new File(storePath);
        if (file.mkdir()){
            System.out.println("目录创建成功");
            return true;
        }
        return false;
    }

    /**
     * 获得文件列表
     * @param path
     * @throws IOException
     */
    private static void getFileList(File path) throws IOException {
        //判断传入对象是否为一个文件夹对象
        if(!path.isDirectory()){
            System.out.println("你输入的不是一个文件夹，请检查路径是否有误！！");
        }
        else{
            File[] t = path.listFiles();
            for(int i=0;i<t.length;i++){
                //判断文件列表中的对象是否为文件夹对象，如果是则执行tree递归，直到把此文件夹中所有文件输出为止
                if(t[i].isDirectory()){
                    System.out.println("目录： " + t[i].getName());
                    getFileList(t[i]);
                }
                else{
                    //后缀为x的是缩略图
                    if(t[i].getName().charAt(t[i].getName().length() - 1) != 'x'){
                        copyFileAndRename(t[i].getName(), bigPicNumber ++);
                        System.out.println("文件： "+t[i].getName());
                    }else{
                        smallPicNumber++;
                        System.out.println("文件： " + t[i].getName() + " 缩略图，不进行复制");
                    }
                }
            }
        }
    }

    /**
     * 复制文件到指定目录，并且修改名字
     * @param fileName
     * @param number
     * @throws IOException
     */
    private static void copyFileAndRename(String fileName, int number) throws IOException {
        FileInputStream input = new FileInputStream(filePath +"\\" + fileName);
        FileOutputStream output = new FileOutputStream(storePath + "\\" + number + ".jpg");

        int in = input.read();
        while (in != -1){
            output.write(in);
            in = input.read();
        }
    }

    public static void main(String[] args) throws IOException {
/*        File path_1 = new File(filePath);
        getFileList(path_1);
        System.out.println("大图数量：" + bigPicNumber);
        System.out.println("缩略图数量：" + smallPicNumber);*/

        Scanner sc = new Scanner(System.in);
        createMkdirs(sc.nextLine(), sc.nextLine());

 /*       Map<String, String> env = System.getenv();
        System.out.println(env.get("USERNAME"));
        System.out.println(env.get("COMPUTERNAME"));
        System.out.println(env.get("USERDOMAIN"));
        System.out.println("用户的主目录:"+System.getProperty("user.home"));
        System.out.println("用户的当前工作目录:"+System.getProperty("user.dir"));*/
    }
}
