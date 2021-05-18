package com.Yan.service.Impl;

import com.Yan.entity.Consumer;
import com.Yan.mapper.ConsumerMapper;
import com.Yan.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *前台用户实现类
 * @Description:
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Override
    public boolean insert(Consumer consumer) {
        return consumerMapper.insert(consumer)>0;
    }

    @Override
    public boolean update(Consumer consumer) {
        return consumerMapper.update(consumer)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return consumerMapper.delete(id)>0;
    }

    @Override
    public Consumer selectById(Integer id) {
        return consumerMapper.selectById(id);
    }

    @Override
    public List<Consumer> AllConsumer() {
        return consumerMapper.AllConsumer();
    }

    @Override
    public boolean verifyPassword(String username, String password) {
        return consumerMapper.verifyPassword(username,password)>0;
    }

    @Override
    public Consumer consumerOfName(String username) {
        return consumerMapper.consumerOfName(username);
    }

    @Override
    public List<Consumer> consumerOfSex(Integer sex) {
        return consumerMapper.consumerOfSex(sex);
    }
}
