package model.dao;


import model.dto.Notice;

import java.util.List;

public interface NoticeDao {
    // 모든 공지사항 조회
    public List<Notice> findAllNotices();

    // 특정 공지사항 조회
    public Notice findNoticeById(int id);

    // 공지사항 추가
    public void saveNotice(Notice notice);

    // 공지사항 수정
    public void updateNotice(Notice notice);

    // 공지사항 삭제
    public void deleteNotice(int id);

}
