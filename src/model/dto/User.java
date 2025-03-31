package model.dto;

public class User {
    private int userId;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String role;

    public User(String name, String phone, String email, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = "guest";
    }
    
    public User(String name, String phone, String email, String password, String role) {
    	this(name, phone, email, password);
    	this.role = role;
    }
    
    public User (String email, String password) {
    	this.email = email;
    	this.password = password;
    }

<<<<<<< HEAD
    public User(int int1, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
=======
    public User (int userId, String email, String password, String phone) {
    	this(email, password);
    	this.userId = userId;
    	this.phone = phone;
    }
>>>>>>> develop

	public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return
                "이름 : '" + name + '\'' +
                ", 전화번호 : '" + phone + '\'' +
                ", 이메일 : '" + email + '\'';
    }
}