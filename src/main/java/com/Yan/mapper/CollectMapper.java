package com.Yan.mapper;

import com.Yan.entity.Collect;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *收藏mapper
 * @Description:
 */
@Repository
public interface CollectMapper {
    /**
     * 增加
     * @param collect
     * @return
     */
    public Integer insert(Collect collect);

    /**
     * 删除
     * @param id
     * @return
     */
    public Integer delete(Integer id);

    /**
     * 根据用户id和歌曲id删除收藏
     * @param userId
     * @param songId
     * @return
     */
    public Integer deleteByUserIdSongId(Integer userId,Integer songId);

    /**
     * 查询所有收藏
     * @return
     */
    public List<Collect> AllCollect();

    /**
     * 查询单个用户的收藏列表
     * @return
     */
    public List<Collect> collectOfUserId(Integer userId);

    /**
     * 查询某个用户是否已经收藏了该歌曲
     * @param songId
     * @return
     */
    public Integer existSongId(Integer userId,Integer songId);


}
