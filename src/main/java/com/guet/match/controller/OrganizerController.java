package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.dto.*;
import com.guet.match.service.OrganizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;



/**
 * @Auther: sefer
 * @Date: 2020/3/24
 * @Description: 主办方控制器
 */
@Api(tags = "主办方")
@RestController
public class OrganizerController {
    Logger logger = LoggerFactory.getLogger(OrganizerController.class);
    @Autowired
    private OrganizeService organizeService;

    @ApiOperation("获取指定主办方信息")
    @GetMapping("organizer/info/{id}")
    public CommonResult getOrganizerById(@PathVariable Long id) {
        return null;
    }

    //状态:-1->初始态; 0->等待审核、1->审核通过、2->审核未通过； 3->停用； 4->删除标记
    @ApiOperation("获取指定状态的主办方list")
    @GetMapping("organizer/list")
    public CommonResult getOrganizerList(@RequestParam(required = false) Integer status) {
        return CommonResult.success(organizeService.getOrganizerList(status));
    }

    //code 200可用; 500不可用
    @ApiOperation("账号查重")
    @GetMapping("organizer/duplicateCheck")
    public CommonResult duplicateCheck(@RequestParam String username) {
        return organizeService.isDuplicate(username) ? CommonResult.failed("该账号已被注册") : CommonResult.success(null, "账号可用");
    }

    @ApiOperation("主办方注册")
    @PostMapping("organizer/sign")
    public CommonResult sign(@RequestBody SignParam dto) {
        switch (organizeService.sign(dto)) {
            case 1:
                return CommonResult.success(null);
            case 2:
                return CommonResult.failed("用户名已被注册");
            default:
                return CommonResult.failed("操作失败，请重试");
        }

    }

    @ApiOperation("申请成为主办方")
    @PostMapping("organizer/apply/{id}")
    public CommonResult applyForOrganizer(@PathVariable Long id) {
        return organizeService.applyForOrganizer(id);
    }

    @ApiOperation("更新主办方资料")
    @PostMapping("organizer/update")
    public CommonResult updateOrganizer(ApplyOrganizerParam dto, @RequestParam(value = "file", required = false) MultipartFile file[]) {
        return organizeService.update(dto, file) == 1 ? CommonResult.success(null) : CommonResult.failed();
    }


    @ApiOperation("审核主办方、停用主办方。所以工作人员登陆的时候要检查它们的主办方是否可用。")
    @PostMapping("organizer/status/update")
    public CommonResult checkOrganizer(@RequestBody CheckOrganizerParam dto) {
        return organizeService.changeStatus(dto);
    }


    @ApiOperation("批量生成主办方工作人员 by 赛事id")
    @PostMapping("organizer/staff/batchAdd")
    public CommonResult batchAddOrganizer(@RequestBody AddStaffParam dto) {
        return organizeService.batchAdd(dto);
    }

    @ApiOperation("导出主办方工作人员 by 赛事 id）")
    @GetMapping("organizer/staff/export/{contestId}")
    public void exportStaffInfo(HttpServletResponse response,@PathVariable Long contestId){
        logger.info("下载请求：导出主办方工作人员");
        try {
            HSSFWorkbook excel = organizeService.exportStaffInfo(contestId);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=staff_info.xls");
            response.flushBuffer();
            excel.write(response.getOutputStream());
        } catch (Exception e) {
            logger.error("导出excel文件出错, 传入参数contestId->{}",contestId);
        }
    }

    @ApiOperation("updateStaffStatus")
    @PostMapping("organizer/staff/status/update")
    public CommonResult updateStaffStatus(@RequestBody UpdateStatusParam dto) {
        return organizeService.updateStaffStatus(dto) == 1 ? CommonResult.success(null) : CommonResult.failed("请刷新页面重试，可能该人员已删除");
    }

}
