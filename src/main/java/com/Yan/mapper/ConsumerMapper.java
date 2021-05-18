package com.Yan.mapper;

import com.Yan.entity.Consumer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *前台用户mapper
 * @Description:
 */
@Repository
public interface ConsumerMapper {
    /**
     * 增加
     * @param consumer
     * @return
     */
    public Integer insert(Consumer consumer);

    /**
     * 修改
     * @param consumer
     * @return
     */
    public Integer update(Consumer consumer);

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
    public Consumer selectById(Integer id);

    /**
     * 查询所有歌手
     * @return
     */
    public List<Consumer> AllConsumer();

    /**
     * 验证用户名和密码是否正确
     * @param username
     * @param password
     * @return
     */
    public Integer verifyPassword(String username,String password);

    /**
     * 根据名字来查询
     * @param username
     * @return
     */
    public Consumer consumerOfName(String username);

    /**
     * 根据性别查询
     * @return
     */
    public List<Consumer> consumerOfSex(Integer sex);
}
