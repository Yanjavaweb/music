package com.Yan.mapper;


import com.Yan.entity.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *歌单mapper
 * @Description:
 */
@Repository
public interface SongListMapper {
    /**
     * 增加
     * @param songList
     * @return
     */
    public Integer insert(SongList songList);

    /**
     * 修改
     * @param songList
     * @return
     */
    public Integer update(SongList songList);

    /**
     * 删除
     * @param id
     * @return
     */
    public Integer delete(Integer id);

    /**
     * 根据id查询歌单
     * @param id
     * @return
     */
    public SongList selectById(Integer id);

    /**
     * 查询所有歌单
     * @return
     */
    public List<SongList> AllSongList();

    /**
     * 根据名字来精确查询
     * @param title
     * @return
     */
    public List<SongList> SongListOfTitle(String title);

    /**
     * 根据名字来模糊查询
     * @param title
     * @return
     */
    public List<SongList> likeTitle(String title);

    /**
     * 根据风格模糊查询
     * @param style
     * @return
     */
    public List<SongList> likeStyle(String style);
}
