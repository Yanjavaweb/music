package com.Yan.service;

import com.Yan.entity.Consumer;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *前台用户service
 * @Description:
 */
public interface ConsumerService {
    /**
     * 增加
     * @param consumer
     * @return
     */
    public boolean insert(Consumer consumer);

    /**
     * 修改
     * @param consumer
     * @return
     */
    public boolean update(Consumer consumer);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

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
    public boolean verifyPassword(String username,String password);

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
