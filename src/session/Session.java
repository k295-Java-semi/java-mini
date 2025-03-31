package session;

public class Session {
    private int userId;
    private String role;

//    public Session() {}
    
    public Session(int userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }
    
    public String getRole() {
    	return role;
    }
    
    @Override
	public String toString() {
		return "Session [userId = " + userId + " role = " + role +"]";
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(userId);
	}
	

    @Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null | getClass() != obj.getClass()) return false;
		Session other = (Session) obj;
		return userId == other.userId;
	}
}