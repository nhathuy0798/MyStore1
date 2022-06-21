package huy.mywebapp.beans;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

	private int id;
	private UserAccount user;
	private List<Item> items;
	private int status;
	
	public Order() {
		this.status = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
