package com.Yan.service.Impl;

import com.Yan.entity.Rank;
import com.Yan.mapper.RankMapper;
import com.Yan.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *评分实现类
 * @Description:
 */
@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankMapper rankMapper;

    @Override
    public boolean insert(Rank rank) {
        return rankMapper.insert(rank)>0;
    }

    @Override
    public Integer ScoreSum(Integer songListId) {
        return rankMapper.ScoreSum(songListId);
    }

    @Override
    public Integer PeopleNum(Integer songListId) {
        return rankMapper.PeopleNum(songListId);
    }

    @Override
    public Integer rankOfSongListId(Integer songListId) {
        Integer rankPeople=rankMapper.ScoreSum(songListId);
        if(rankPeople==0){
            return 5;
        }
        return rankMapper.ScoreSum(songListId) / rankPeople;
    }
}
