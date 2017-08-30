package com.isoft.erp.dao.generator;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * Created by dell on 2017/4/26.
 */
public class JsonParser {

    public static void main(String[] args){
        try {
            File file=new File("D:\\workspace\\erp-parent\\erp-web\\src\\main\\webapp\\json\\bee.json");
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bis=new BufferedInputStream(fileInputStream);
            BufferedOutputStream bos=new BufferedOutputStream(
                    new FileOutputStream("D:\\json_copy.txt"));
            byte[] bys=new byte[1024*2];
            int lens=0;
            String str="";
            while ((lens=bis.read(bys))!=-1){//每次读入的字节长度和输出的字节长度要保持相同,否则会出现字节的错乱和覆盖
                bos.write(bys,0,lens);
                str=new String(bys,0,lens);
                System.out.println(str);
            }
            Bean bean = JSON.parseObject(str, Bean.class);
            System.out.println(bean);
            bos.flush();//注意缓冲区流要刷出到文件否则不会显示
            bos.close();
            bis.close();
            fileInputStream.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
