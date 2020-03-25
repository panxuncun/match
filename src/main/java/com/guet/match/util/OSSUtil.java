package com.guet.match.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.util.UUID;

/**
 * @Auther: sefer
 * @Date: 2020/3/25
 * @Description: OSS工具
 */
public class OSSUtil {
    static Logger logger = LoggerFactory.getLogger(OSSUtil.class);
    static String endpoint = "oss-cn-shenzhen.aliyuncs.com";
    static String accessKeyId = "LTAIoV3yu80wkajd";
    static String accessKeySecret = "OUvfNyPq8bTmwDANtdYBLa7j9I9rYz";
    static String bucketName = "guet-resource";


    //上传文件到OSS,返回OSS中的文件名
    public static String upload(MultipartFile file) {
        if (file == null) {
            return null;
        }
        //生成随机文件名
        String fileName = UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            ossClient.putObject(bucketName, fileName, new ByteArrayInputStream(file.getBytes()));
            ossClient.shutdown();
            logger.info("OSS: 文件上传成功, 原始文件{}, 目标文件{}", file.getOriginalFilename(), fileName);
            return fileName;
        } catch (Exception e) {
            logger.error("OSS: 文件上传出错, 原始文件{}", file.getOriginalFilename());
            return null;
        }
    }

    //批量上传文件，全部成功时返回OSS文件名数组。不允许空文件。
    public static String[] uploadByArr(MultipartFile file[]) {
        String[] urlArr = new String[file.length];
        int i = 0;
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            for (; i < file.length; i++) {
                if (file[i] == null || file[i].isEmpty()) {
                    logger.error("OSS: 错误，存在空文件, 开始回滚");
                    deleteByArr(urlArr);
                    return null;
                }
                //生成随机文件名
                String fileName = UUID.randomUUID().toString().replace("-", "") + file[i].getOriginalFilename().substring(file[i].getOriginalFilename().lastIndexOf("."));
                ossClient.putObject(bucketName, fileName, new ByteArrayInputStream(file[i].getBytes()));
                logger.info("OSS: 文件上传成功, 原始文件{}, 目标文件{}", file[i].getOriginalFilename(), fileName);
                urlArr[i] = fileName;
            }
            ossClient.shutdown();
        } catch (Exception e) {
            logger.error("OSS: 文件上传出错, 原始文件{}", file[i].getOriginalFilename());
            return null;
        }
        return urlArr;
    }


    //删除单个文件by name
    public static boolean delete(String fileName) {
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            ossClient.deleteObject("guet-resource", fileName);
            ossClient.shutdown();
            logger.info("OSS: 文件删除成功, 文件名称{}", fileName);
            return true;
        } catch (Exception e) {
            logger.error("OSS: 文件删除失败, 可能该文件不存在, 文件名称{}", fileName);
            return false;
        }
    }

    //批量删除文件by arr
    public static void deleteByArr(String[] fileNameArr) {
        for (int i = 0; i < fileNameArr.length; i++) {
            if (fileNameArr[i] == null || fileNameArr.length == 0) {
                continue;
            }
            try {
                OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
                ossClient.deleteObject("guet-resource", fileNameArr[i]);
                ossClient.shutdown();
                logger.info("OSS: 文件删除成功, 文件名称{}", fileNameArr[i]);
            } catch (Exception e) {
                logger.error("OSS: 文件删除失败, 可能该文件不存在, 文件名称{}", fileNameArr[i]);
            }
        }
    }
}