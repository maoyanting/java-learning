package com.sandao.javalearning.algorithm;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * 淘宝笔试
 * @author maoyanting
 * @version V1.0
 * @date 2020/04/13
 */
@Slf4j
public class LogInput {

    private static final ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("readLog-pool-%d").build();
    private static final ExecutorService pool = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        String dir = "/home/admin/logs";
        File[] files = new File(dir).listFiles();
        if (files == null){
            log.info("文件夹不存在");
            return;
        }
        for (File file : files){
            if (!file.isFile() || !file.exists() || !".log".equals(file.getName())) {
                continue;
            }
            try {
                pool.execute(() -> {
                    try {
                        readLogFile(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }catch (Exception e){
                log.error("读取失败");
            }
        }
        pool.shutdown();
    }

    /**
     * grep "Login" |
     * uniq -c | 在行首位置输出该行重复的次数
     * sort -nr 降序 要以数值来排序
     */
    public static void readLogFile(File file) throws IOException{
        String encoding = "GBK";
        InputStreamReader read;
        try {
            read = new InputStreamReader(new FileInputStream(file), encoding);
        } catch (Exception e) {
            log.error("读取失败");
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(read);
        ConcurrentHashMap<String,Integer> grepStringMap = new ConcurrentHashMap<>();
        String lineTxt;
        while ((lineTxt = bufferedReader.readLine()) != null) {
            //每行数据 grep "Login"
            if (lineTxt.contains("Login")){
                //重复次数
                if (!grepStringMap.containsKey(lineTxt)) {
                    grepStringMap.put(lineTxt, 1);
                } else {
                    grepStringMap.put(lineTxt, (grepStringMap.get(lineTxt)+1));
                }
            }
        }
        read.close();  //输入流关闭
        //排序
        List<Map.Entry<String, Integer>> arraylist = new ArrayList<>(grepStringMap.entrySet());
        arraylist.sort((obj1, obj2) -> (obj2.getValue()).compareTo(obj1.getValue()));
        //输出
        if (arraylist.isEmpty()){
            return;
        }
        for (Map.Entry<String, Integer> item : arraylist) {
            System.out.println(item.getValue() + item.getKey());
        }
    }


}
