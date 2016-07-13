package com.smallclover.utils;

/**
 * Created by smallclover on 2016/7/13.
 */
public class StrKit {

    public static boolean isBlank(String str){
        return (str.trim() == null) || (str.trim().length() == 0) || (str.trim() == "");
    }
}
