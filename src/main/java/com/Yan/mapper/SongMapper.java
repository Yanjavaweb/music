package com.Yan.mapper;

import com.Yan.entity.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *歌曲mapper
 * @Description:
 */
@Repository
public interface SongMapper {
    /**
     * 增加
     * @param song
     * @return
     */
    public Integer insert(Song song);

    /**
     * 修改
     * @param song
     * @return
     */
    public Integer update(Song song);

    /**
     * 删除
     * @param id
     * @return
     */
    public Integer delete(Integer id);

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
     * 根据名字来模糊查询
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
