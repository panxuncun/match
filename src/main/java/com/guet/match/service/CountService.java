package com.guet.match.service;

import cn.hutool.core.date.DateUtil;
import com.guet.match.common.CommonResult;
import com.guet.match.mapper.CmsContestMapper;
import com.guet.match.mapper.CmsEnrollmentRecordMapper;
import com.guet.match.model.CmsContestExample;
import com.guet.match.model.CmsEnrollmentRecordExample;
import com.guet.match.model.UmsOrganizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: sefer
 * @Date: 2020/5/9
 * @Description: 因为poi的包和hutool冲突，故新建
 */

@Service
public class CountService {
    Logger logger = LoggerFactory.getLogger(CountService.class);
    @Autowired
    private CmsEnrollmentRecordMapper enrollmentRecordMapper;

    @Autowired
    private CmsContestMapper contestMapper;

    @Autowired
    private OrganizeService organizeService;

    public Long getOrganizerId(Principal principal) {
        UmsOrganizer organizer = organizeService.getOrganizerByUsername(principal.getName());
        return organizer.getId();
    }


    //统计：报名情况
    public CommonResult countEnrollment(Principal principal,Integer day) {
        logger.info("=====pri id->{}",getOrganizerId(principal));

        //得到ids
        CmsContestExample example = new CmsContestExample();
        example.createCriteria().andOrganizerIdEqualTo(getOrganizerId(principal));
        List<Long> ids = contestMapper.selectByExample(example).stream().map(item->item.getId()).collect(Collectors.toList());
        if (ids.size() == 0){
            return CommonResult.success(new ArrayList<>());
        }


        List<Map> countArr = new ArrayList<>();
        for (int i = day - 1; i >= 0; i--) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            Date beginOfDay = DateUtil.beginOfDay(calendar.getTime());
            Date endOfDay = DateUtil.endOfDay(calendar.getTime());
            CmsEnrollmentRecordExample example1 = new CmsEnrollmentRecordExample();
            example1.createCriteria().andContestIdIn(ids).andCreateTimeBetween(beginOfDay, endOfDay);
            Map map = new HashMap<>();
            map.put("value",enrollmentRecordMapper.countByExample(example1));
            map.put("dayTag",calendar.get(Calendar.DAY_OF_MONTH) + "号"); //要求字符串
            countArr.add(map);
            logger.info("统计====={}", map.toString());
        }
        return CommonResult.success(countArr);
    }
}
