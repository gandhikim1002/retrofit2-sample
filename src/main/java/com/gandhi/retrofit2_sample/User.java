package com.gandhi.retrofit2_sample;

public class User {

	private String login;
    private long id;
    private String url;
    
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "User [login=" + login + ", id=" + id + ", url=" + url + "]";
	}
    
}