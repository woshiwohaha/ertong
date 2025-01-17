package com.child.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Upload {
    private static  SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
    /*
    * 上传图片并返回图片的相对地址
    */
    public static String uploadImage(MultipartFile file,String realUploadPath,String uriPath) throws IOException
    {
        String date = df.format(new Date());
        //如果目录不存在则创建目录
        File uploadFile=new File(realUploadPath);
        if(!uploadFile.exists()){
            uploadFile.mkdirs();
        }
        String [] tmp = file.getOriginalFilename().split("\\.");
        //创建输入流
        InputStream inputStream=file.getInputStream();
        //生成输出地址URL
        String outputPath=realUploadPath+"/"+date+"."+tmp[tmp.length-1];
        //创建输出流
        OutputStream outputStream=new FileOutputStream(outputPath);
        //设置缓冲区
        byte[] buffer=new byte[1024];
        //输入流读入缓冲区，输出流从缓冲区写出
        while((inputStream.read(buffer))>0)
        {
            outputStream.write(buffer);  //将图片复制到目标文件夹里，然后就可以使用http请求访问该图片
        }
        outputStream.close();
        //返回原图上传后的相对地址
        return CommonVal.hostPort+"/"+uriPath+"/"+date+"."+tmp[tmp.length-1];
    }
    
}
