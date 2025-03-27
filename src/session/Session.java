package session;

public class Session {
    private String userId;

    public Session() {}
    
    public Session(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
    
    @Override
	public String toString() {
		return "Session [userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		return userId.hashCode();
	}
	

    @Override
	public boolean equals(Object obj) {
		Session other = (Session) obj;
		if(userId.equals(other.userId)) {
			return true;
		}else {
			return false;
		}
	}
}