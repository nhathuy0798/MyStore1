package huy.mywebapp.beans;

public class UserAccount {

	   public static final String GENDER_MALE ="M";
	   public static final String GENDER_FEMALE = "F";
	   
	   private String userName;
	   private String gender;
	   private String password;
	   private boolean role_admin;
	   

	   public UserAccount() {
	       
	   }
	   
	   public String getUserName() {
	       return userName;
	   }

	   public void setUserName(String userName) {
	       this.userName = userName;
	   }

	   public String getGender() {
	       return gender;
	   }

	   public void setGender(String gender) {
	       this.gender = gender;
	   }

	   public String getPassword() {
	       return password;
	   }

	   public void setPassword(String password) {
	       this.password = password;
	   }

	public boolean isRole_admin() {
		return role_admin;
	}

	public void setRole_admin(boolean role_admin) {
		this.role_admin = role_admin;
	}

	}