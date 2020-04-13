package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.dto.ApplyOrganizerParam;
import com.guet.match.util.OSSUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: sefer
 * @Date: 2020/4/7
 * @Description: 图片等文件上传相关
 */

@Api(tags = "上传")
@RestController
public class UploadController {

    Logger logger = LoggerFactory.getLogger(UploadController.class);

    @ApiOperation("小程序+富文本：上传单个图片")
    @PostMapping("upload/img")
    public CommonResult uploadImg(@RequestParam(value = "file") MultipartFile file) {
        //上传一张图片到OSS,成功则返回文件名
        String fileName = OSSUtil.upload(file);
        if (fileName == null) {
            return CommonResult.failed("上传失败");
        }
        //返回文件名
        return CommonResult.success(fileName);
    }

    @ApiOperation("小程序：批量上传图片")
    @PostMapping("upload/muti")
    public CommonResult uploadImgs(@RequestParam(value = "file") MultipartFile file[]) {
        logger.info("批量上传图片");
        //上传新的图片到OSS,全部成功则返回文件名数组 urlArr
        String[] fileNameArr = OSSUtil.uploadByArr(file);
        if (fileNameArr == null || fileNameArr.length == 0) {
            return CommonResult.failed("上传失败");
        }
        //返回文件名数组
        return CommonResult.success(fileNameArr);
    }


}
