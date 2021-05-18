package com.Yan.service.Impl;

import com.Yan.entity.Singer;
import com.Yan.mapper.SingerMapper;
import com.Yan.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *歌手serviceimpl
 * @Description:
 */
@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerMapper singerMapper;

    @Override
    public boolean insert(Singer singer) {
        return singerMapper.insert(singer)>0;
    }

    @Override
    public boolean update(Singer singer) {
        return singerMapper.update(singer)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return singerMapper.delete(id)>0;
    }

    @Override
    public Singer selectById(Integer id) {
        return singerMapper.selectById(id);
    }

    @Override
    public List<Singer> AllSinger() {
        return singerMapper.AllSinger();
    }

    @Override
    public List<Singer> singerofName(String name) {
        return singerMapper.singerofName(name);
    }

    @Override
    public List<Singer> singerofSex(Integer sex) {
        return singerMapper.singerofSex(sex);
    }
}
