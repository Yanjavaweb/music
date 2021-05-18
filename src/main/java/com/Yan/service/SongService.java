package com.Yan.service;

import com.Yan.entity.Song;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *歌曲service
 * @Description:
 */
public interface SongService {
    /**
     * 增加
     * @param song
     * @return
     */
    public boolean insert(Song song);

    /**
     * 修改
     * @param song
     * @return
     */
    public boolean update(Song song);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 根据id查询歌曲
     * @param id
     * @return
     */
    public Song selectById(Integer id);

    /**
     * 查询所有歌曲
     * @return
     */
    public List<Song> AllSong();

    /**
     * 根据名字来查询
     * @param name
     * @return
     */
    public List<Song> songofName(String name);

    /**
     * 根据歌手id查询
     * @return
     */
    public List<Song> songofSingerId(Integer id);
}
