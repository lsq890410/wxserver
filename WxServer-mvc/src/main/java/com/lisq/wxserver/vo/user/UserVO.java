package com.lisq.wxserver.vo.user;

public class UserVO {
	private int id ;
	private String skey;
	private String create_time;
	private String last_visit_time;
	private String session_key;
	private String appsession;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSkey() {
		return skey;
	}
	public void setSkey(String skey) {
		this.skey = skey;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getLast_visit_time() {
		return last_visit_time;
	}
	public void setLast_visit_time(String last_visit_time) {
		this.last_visit_time = last_visit_time;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public String getAppsession() {
		return appsession;
	}
	public void setAppsession(String appsession) {
		this.appsession = appsession;
	}
}
