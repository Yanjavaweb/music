package com.Yan.mapper;

import com.Yan.entity.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *歌手mapper
 * @Description:
 */
@Repository
public interface SingerMapper {
    /**
     * 增加
     * @param singer
     * @return
     */
    public Integer insert(Singer singer);

    /**
     * 修改
     * @param singer
     * @return
     */
    public Integer update(Singer singer);

    /**
     * 删除
     * @param id
     * @return
     */
    public Integer delete(Integer id);

    /**
     * 根据id查询歌手
     * @param id
     * @return
     */
    public Singer selectById(Integer id);

    /**
     * 查询所有歌手
     * @return
     */
    public List<Singer> AllSinger();

    /**
     * 根据名字来模糊查询
     * @param name
     * @return
     */
    public List<Singer> singerofName(String name);

    /**
     * 根据性别查询
     * @return
     */
    public List<Singer> singerofSex(Integer sex);
}
