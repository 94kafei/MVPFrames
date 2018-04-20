package me.mvp.frame.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;

/**
 * ProjectUtils
 */
public class ProjectUtils {

    // 目录名称
    public static String PROJECT_NAME = "MVP";
    // 项目目录
    public static String ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + PROJECT_NAME + File.separator;
    // DB路径
    public static String DB = ROOT_PATH + "db/";
    // 日志路径
    public static String LOG = ROOT_PATH + "log/";
    // 缓存路径
    public static String CACHE = ROOT_PATH + "cache/";
    // 其他路径
    public static String OTHER = ROOT_PATH + "other/";
    // Camera
    public static String CAMERA = ROOT_PATH + "camera/";

    /**
     * 初始化项目文件夹
     *
     * @return
     */
    public static boolean init() {
        boolean result = true;
        if (DeviceUtils.isExitsSdcard()) {
            result = FileUtils.makeFolders(ROOT_PATH);
            result = FileUtils.makeFolders(DB);
            result = FileUtils.makeFolders(LOG);
            result = FileUtils.makeFolders(CACHE);
            result = FileUtils.makeFolders(OTHER);
            result = FileUtils.makeFolders(CAMERA);
        }
        return result;
    }

    /**
     * 初始化项目文件夹
     *
     * @return
     */
    public static boolean init(String name) {
        PROJECT_NAME = !TextUtils.isEmpty(name) ? name : PROJECT_NAME;
        ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + PROJECT_NAME + File.separator;
        DB = ROOT_PATH + "db/";
        LOG = ROOT_PATH + "log/";
        CACHE = ROOT_PATH + "cache/";
        OTHER = ROOT_PATH + "other/";
        CAMERA = ROOT_PATH + "camera/";
        return init();
    }
}