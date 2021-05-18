package com.Yan.service;

import com.Yan.entity.Rank;

/**
 * Created with IntelliJ IDEA.
 *评分service
 * @Description:
 */
public interface RankService {
    /**
     * 增加
     * @param rank
     * @return
     */
    public boolean insert(Rank rank);

    /**
     * 查询所有评分
     * @return
     */
    public Integer ScoreSum(Integer songListId);

    /**
     * 查询总评分人数
     * @param songListId
     * @return
     */
    public Integer PeopleNum(Integer songListId);

    /**
     * 计算平均分
     * @param songListId
     * @return
     */
    public Integer rankOfSongListId(Integer songListId);

}
