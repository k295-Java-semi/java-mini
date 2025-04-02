package model.service;

import java.util.List;

import model.dao.NoticeDao;
import model.dto.Notice;
import pension.exception.AddException;
import pension.exception.DeleteException;
import pension.exception.FindException;
import pension.exception.ModifyException;

public abstract class NoticeServiceImpl implements NoticeService {
	private NoticeDao noticeDao;

	public NoticeServiceImpl(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public void addNotice(Notice notice) throws AddException {
		noticeDao.saveNotice(notice);
	}

	@Override
	public void modifyNotice(Notice notice) throws ModifyException {
		noticeDao.updateNotice(notice);
	}

	@Override
	public void removeNotice(int noticeNo) throws DeleteException {
		noticeDao.deleteNotice(noticeNo);
	}

	@Override
	public Notice getNotice(int noticeNo) throws FindException {
		return noticeDao.findNoticeById(noticeNo);
	}

	@Override
	public List<Notice> getAllNotices() throws FindException {
		return noticeDao.findAllNotices();
	}
}