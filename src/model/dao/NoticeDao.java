package model.dao;


import model.dto.Notice;

import java.util.List;

public interface NoticeDao {
    void insertNotice(Notice notice) throws Exception;
    List<Notice> selectAllNotices() throws Exception;
}