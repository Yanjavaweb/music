package com.Yan.service.Impl;

import com.Yan.entity.Song;
import com.Yan.mapper.SongMapper;
import com.Yan.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *歌曲实现类
 * @Description:
 */
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;

    @Override
    public boolean insert(Song song) {
        return songMapper.insert(song)>0;
    }

    @Override
    public boolean update(Song song) {
        return songMapper.update(song)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return songMapper.delete(id)>0;
    }

    @Override
    public Song selectById(Integer id) {
        return songMapper.selectById(id);
    }

    @Override
    public List<Song> AllSong() {
        return songMapper.AllSong();
    }

    @Override
    public List<Song> songofName(String name) {
        return songMapper.songofName(name);
    }

    @Override
    public List<Song> songofSingerId(Integer id) {
        return songMapper.songofSingerId(id);
    }
}
