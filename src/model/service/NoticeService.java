package model.service;

import java.util.List;

import model.dto.Notice;
import pension.exception.AddException;
import pension.exception.DeleteException;
import pension.exception.FindException;
import pension.exception.ModifyException;

public interface NoticeService {
	// 모든 공지사항 조회
	List<Notice> getAllNotices() throws FindException;

	// 특정 공지사항 조회
	Notice getNotice(int noticeNo) throws FindException;

	// 공지사항 추가
	void addNotice(Notice notice) throws AddException;

	// 공지사항 수정
	void modifyNotice(Notice notice) throws ModifyException;

	// 공지사항 삭제
	void removeNotice(int noticeNo) throws DeleteException;

}
