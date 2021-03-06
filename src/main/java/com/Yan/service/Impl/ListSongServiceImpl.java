package com.Yan.service.Impl;

import com.Yan.entity.ListSong;
import com.Yan.mapper.ListSongMapper;
import com.Yan.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *歌曲列表实现类
 * @Description:
 */
@Service

public class ListSongServiceImpl implements ListSongService {

    @Autowired
    private ListSongMapper listSongMapper;

    @Override
    public boolean insert(ListSong listSong) {
        return listSongMapper.insert(listSong)>0;
    }

    @Override
    public boolean update(ListSong listSong) {
        return listSongMapper.update(listSong)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return listSongMapper.delete(id)>0;
    }

    @Override
    public boolean deleteBySongIdAndSongListId(Integer songId, Integer songListId) {
        return listSongMapper.deleteBySongIdAndSongListId(songId,songListId)>0;
    }

    @Override
    public ListSong selectById(Integer id) {
        return listSongMapper.selectById(id);
    }

    @Override
    public List<ListSong> AlllistSong() {
        return listSongMapper.AlllistSong();
    }

    @Override
    public List<ListSong> listSongOfSongListId(Integer songListid) {
        return listSongMapper.listSongOfSongListId(songListid);
    }
}
