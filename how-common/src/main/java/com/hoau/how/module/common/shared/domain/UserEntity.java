package com.hoau.how.module.common.shared.domain;

import java.util.List;
import java.util.Set;

import com.hoau.hbdp.framework.entity.BaseEntity;
import com.hoau.hbdp.framework.entity.IRole;
import com.hoau.hbdp.framework.entity.IUser;
import com.hoau.hbdp.framework.server.web.session.SessionValue;
@SessionValue
public class UserEntity extends BaseEntity implements IUser {
	
	private String id;
	
	private String userCode;
	
	private String userName;
	
	private String password;
	

	@Override
	public String getId() {
		return id;

	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public List<IRole> getRoles() {
		
		return null;
	}

	@Override
	public void setRoles(List<IRole> roles) {
		
	}

	@Override
	public Set<String> getRoleids() {
		
		return null;
	}

	@Override
	public Set<String> queryAccessUris() {
		return null;

	}

	@Override
	public void setRoleids(Set<String> paramSet) {
		
	}

	@Override
	public void setUserName(String paramString) {
		this.userName = paramString;
	}

	@Override
	public String getUserName() {
		return userName;

	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
