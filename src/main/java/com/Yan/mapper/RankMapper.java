package com.Yan.mapper;

import com.Yan.entity.Rank;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *评价mapper
 * @Description:
 */
@Repository
public interface RankMapper {

    /**
     * 增加
     * @param rank
     * @return
     */
    public Integer insert(Rank rank);

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

}
