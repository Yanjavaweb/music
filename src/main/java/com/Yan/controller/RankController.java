package com.Yan.controller;

import com.Yan.entity.Rank;
import com.Yan.service.RankService;
import com.Yan.utils.Status.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *评分controller
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/rankController")
@Api(tags = "rankController",description="评分管理")
public class RankController {
    @Autowired
    private RankService rankService;

    @ApiOperation("添加评分")
    @PostMapping(value = "/add")
    public Object addRank(HttpServletRequest request){
        String songListId=request.getParameter("songListId").trim();
        String consumerId=request.getParameter("consumerId").trim();
        String scope=request.getParameter("scope").trim();

        Rank rank=new Rank();
        rank.setSongListId(Integer.parseInt(songListId));
        rank.setConsumerId(Integer.parseInt(consumerId));
        rank.setScope(Integer.parseInt(scope));
        boolean flag = rankService.insert(rank);
        if(flag){
            return AjaxResult.success("评分成功",rank);
        }
        return AjaxResult.error("评分失败");
    }
    @ApiOperation("计算平均分")
    @GetMapping(value = "/rankOfSongListId")
    public Object rankOfSongListId(HttpServletRequest request){
        String songListId=request.getParameter("songListId").trim();
        Integer re = rankService.rankOfSongListId(Integer.parseInt(songListId));
        if(re>=0){
            return AjaxResult.success("计算平均分成功",re);
        }
        return AjaxResult.error("计算平均分失败");
    }
}
