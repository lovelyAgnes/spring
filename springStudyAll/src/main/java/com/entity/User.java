package com.entity;

import java.io.Serializable;

//import javax.persistence.Entity;

//@Entity hibernateע��
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	    private Integer id;

	    private String userName;

	    private String password;

	    private Integer age;

		public Integer getId() {
			return 12;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}
}
