package com.sandao.javalearning.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/08/01
 */
public class PicDownloadUtil {
    public static void main(String[] args) throws Exception {
        String picUrl = "https://pic1.zhimg.com/v2-db168102e05a711e936be851a685ac3c_r.jpg";
        downloadPic(picUrl);
    }

    /**
     * 下载图片
     */
    public static void downloadPic(String picUrl) throws Exception {
        URL url = new URL(picUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5 * 1000);
        InputStream inStream = conn.getInputStream();

        File picImg = new File("gakki.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(picImg);

        byte[] b = new byte[1024];
        int len = 0;
        while ((len = inStream.read()) != -1) {
            fileOutputStream.write(b, 0, len);
        }
        fileOutputStream.close();
    }
}
