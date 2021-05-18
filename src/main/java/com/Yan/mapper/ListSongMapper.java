package com.Yan.mapper;

import com.Yan.entity.ListSong;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *歌曲列表mapper
 * @Description:
 */
@Repository
public interface ListSongMapper {
    /**
     * 增加
     * @param listSong
     * @return
     */
    public Integer insert(ListSong listSong);

    /**
     * 修改
     * @param listSong
     * @return
     */
    public Integer update(ListSong listSong);

    /**
     * 删除
     * @param id
     * @return
     */
    public Integer delete(Integer id);

    /**
     * 根据歌曲id和歌单id删除
     * @param songId
     * @param songListId
     * @return
     */
    public Integer deleteBySongIdAndSongListId(Integer songId,Integer songListId);

    /**
     * 根据id查询歌曲
     * @param id
     * @return
     */
    public ListSong selectById(Integer id);

    /**
     * 查询所有歌曲列表
     * @return
     */
    public List<ListSong> AlllistSong();

    /**
     * 根据歌单id查询
     * @return
     */
    public List<ListSong> listSongOfSongListId(Integer songListId);
}
