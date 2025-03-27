package model.dto;

import java.sql.Date;

public class Notice {
	private User user; // 싱글톤으로
    private int noticeId;
    private String content;
    private Date postDate;
    

    public Notice(int noticeId, String content, Date postDate) {
        this.noticeId = noticeId;
        this.content = content;
        this.postDate = postDate;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

   
    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", content='" + content + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}