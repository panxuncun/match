package com.guet.match.controller;

import com.guet.match.common.CommonResult;
import com.guet.match.dto.SignDto;
import com.guet.match.service.OrganizeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Auther: sefer
 * @Date: 2020/3/24
 * @Description: 主办方控制器
 */
@Api(tags = "主办方")
@RestController
public class OrganizerController {
    @Autowired
    private OrganizeService organizeService;
    
    @ApiOperation("获取指定主办方信息")
    @GetMapping("organizer/info/{id}")
    public CommonResult getOrganizerById(@PathVariable long id){
        return null;
    }
    
    @ApiOperation("获取符合条件的主办方")
    @GetMapping("organizer/list")
    public CommonResult getOrganizerList(@RequestParam(required = false) int type){
        return null;
    }

    //code 200可用; 500不可用
    @ApiOperation("账号查重")
    @GetMapping("organizer/duplicateCheck")
    public CommonResult duplicateCheck(@RequestParam String username){
        return organizeService.isDuplicate(username) ? CommonResult.failed("该账号已被注册") : CommonResult.success(null, "账号可用");
    }
    @ApiOperation("主办方注册")
    @PostMapping("organizer/sign")
    public CommonResult sign(@RequestBody SignDto dto){
        switch (organizeService.sign(dto)){
            case 1:
                return CommonResult.success(null);
            case 2:
                return CommonResult.failed("用户名已被注册");
            default:
                return CommonResult.failed("操作失败，请重试");
        }

    }
    
    @ApiOperation("申请成为主办方")
    @PostMapping("organizer/apply")
    public CommonResult applyForOrganizer(){
        return null;
    }
    
    @ApiOperation("审核主办方+停用主办方（含工作人员）（有比赛进行怎么办，肯定不能停用啊）（还有他的工作人员也要一起消灭）")
    @PostMapping("organizer/check")
    public CommonResult checkOrganizer(){
        return null;
    }

    @ApiOperation("变更主办方资料（变更管理员的，或者材料，变更之后要重新审核）")
    @PostMapping("organizer/update")
    public CommonResult updateOrganizer(){
        return null;
    }
    
    @ApiOperation("批量生成工作人员（传入赛事id）")
    @PostMapping("organizer/staff/batch_add")
    public CommonResult batchAddOrganizer(){
        return null;
    }

    @ApiOperation("导出工作人员（传入赛事id）")
    @GetMapping("organizer/staff/export")
    public CommonResult exportStaff(){
        return null;
    }

    @ApiOperation("停用启用工作人员")
    @PostMapping("organizer/staff/switch")
    public CommonResult staffSwitch(){
        return null;
    }
    

}
