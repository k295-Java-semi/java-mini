package model.service;


import model.dto.Notice;

import java.sql.SQLException;
import java.util.List;

public interface NoticeService {
    void addNotice(Notice notice) throws SQLException;
    List<Notice> getAllNotices() throws SQLException;
}