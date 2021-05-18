package com.Yan.service.Impl;

import com.Yan.entity.SongList;
import com.Yan.mapper.SongListMapper;
import com.Yan.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *歌单实现类
 * @Description:
 */
@Service
public class SongListServiceImpl implements SongListService {

    @Autowired
    private SongListMapper songListMapper;

    @Override
    public boolean insert(SongList songList) {
        return songListMapper.insert(songList)>0;
    }

    @Override
    public boolean update(SongList songList) {
        return songListMapper.update(songList)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return songListMapper.delete(id)>0;
    }

    @Override
    public SongList selectById(Integer id) {
        return songListMapper.selectById(id);
    }

    @Override
    public List<SongList> AllSongList() {
        return songListMapper.AllSongList();
    }

    @Override
    public List<SongList> SongListOfTitle(String title) {
        return songListMapper.SongListOfTitle(title);
    }

    @Override
    public List<SongList> likeTitle(String title) {
        return songListMapper.likeTitle(title);
    }

    @Override
    public List<SongList> likeStyle(String style) {
        return songListMapper.likeStyle(style);
    }
}
