package com.Yan.service;

import com.Yan.entity.ListSong;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *歌曲列表service
 * @Description:
 */
public interface ListSongService {
    /**
     * 增加
     * @param listSong
     * @return
     */
    public boolean insert(ListSong listSong);

    /**
     * 修改
     * @param listSong
     * @return
     */
    public boolean update(ListSong listSong);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 根据歌曲id和歌单id删除
     * @param songId
     * @param songListId
     * @return
     */
    public boolean deleteBySongIdAndSongListId(Integer songId,Integer songListId);

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
    public List<ListSong> listSongOfSongListId(Integer songListid);
}
