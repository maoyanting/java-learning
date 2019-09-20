package com.sandao.javalearning.utils;

import io.swagger.models.auth.In;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/**
 * @author maoyanting
 * @version V1.0
 * @date 2019/09/18
 */
public class GzipFileUtil {
    public static void main(String[] args) {
        String sourcedir ="/Users/maoyanting/Documents/maoyantingCode/github/java-learning/src/main/java/com/sandao/javalearning/log/rest_2019-08-30.log.0.gz";
//        unGzipFile(sourcedir);
        doUncompressFile(sourcedir);
    }
    public static void unGzipFile(String sourcedir) {
        String ouputfile = "";
        try {
            //建立gzip压缩文件输入流
            FileInputStream fin = new FileInputStream(sourcedir);
            //建立gzip解压工作流
            GZIPInputStream gzin = new GZIPInputStream(fin);
            //建立解压文件输出流
            ouputfile = sourcedir.substring(0,sourcedir.lastIndexOf('.'));
            ouputfile = ouputfile.substring(0,ouputfile.lastIndexOf('.'));
            FileOutputStream fout = new FileOutputStream(ouputfile);

            int num;
            byte[] buf=new byte[1024];

            while ((num = gzin.read(buf,0,buf.length)) != -1)
            {
                fout.write(buf,0,num);
            }

            gzin.close();
            fout.close();
            fin.close();
        } catch (Exception ex){
            System.err.println(ex.toString());
        }
    }

    /**
     * Uncompress the incoming file.
     * @param inFileName Name of the file to be uncompressed
     */
    private static void doUncompressFile(String inFileName) {

        try {

            if (!getExtension(inFileName).equalsIgnoreCase("gz")) {
                System.err.println("File name must have extension of \".gz\"");
                System.exit(1);
            }

            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(inFileName))));
            } catch(FileNotFoundException e) {
                System.err.println("File not found. " + inFileName);
                System.exit(1);
            }

            String cipPattern = "(?<=_cip:)((?:(?!_cip:).)*?)(?=_sip:)";
            Pattern r = Pattern.compile(cipPattern);

            Map<String, Integer> count = new HashMap<>();

            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null)
            {
                System.out.println("----------- TIME   ---------"+lineTxt.substring(0,24));
                System.out.println("------"+lineTxt);
                Matcher m = r.matcher(lineTxt);
                if (m.find( )) {
                    String cip = m.group(0);
                    if (count.containsKey(cip)){
                        count.put(cip,count.get(cip)+1);
                    }else {
                        count.put(cip,1);
                    }
                } else {
                    System.out.println("NO MATCH");
                }
            }
            bufferedReader.close();

            System.out.println("----------- Closing the file and stream ------------");
            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * Used to extract and return the extension of a given file.
     * @param f Incoming file to get the extension of
     * @return <code>String</code> representing the extension of the incoming
     *         file.
     */
    public static String getExtension(String f) {
        String ext = "";
        int i = f.lastIndexOf('.');

        if (i > 0 &&  i < f.length() - 1) {
            ext = f.substring(i+1);
        }
        return ext;
    }

    /**
     * Used to extract the filename without its extension.
     * @param f Incoming file to get the filename
     * @return <code>String</code> representing the filename without its
     *         extension.
     */
    public static String getFileName(String f) {
        String fname = "";
        int i = f.lastIndexOf('.');

        if (i > 0 &&  i < f.length() - 1) {
            fname = f.substring(0,i);
        }
        return fname;
    }

}
