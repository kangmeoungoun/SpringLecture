package kr.co.softcampus.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.softcampus.beans.UserBean;
import kr.co.softcampus.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;
	
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	
	public boolean checkUserIdExist(String user_id ) {
		String user_name = userdao.checkUserIdExist(user_id);
		if(user_name ==null) {
			return true;
		}else {
			return false;
		}
	}
	public void addUserInfo(UserBean joinUserBean) {
		userdao.addUserInfo(joinUserBean);
	}
	public void getLoginUserInfo(UserBean tempLoginUserBean) {
		UserBean tempLoginUserBean2 = userdao.getLoginUserInfo(tempLoginUserBean);
		
		if(tempLoginUserBean2!= null) {
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUserLogin(true);
		}
	}
	public void getModifyUserInfo(UserBean modifyUserBean) {
		UserBean tempModifyUserBean =  userdao.getModifyUserInfo(loginUserBean.getUser_idx());
		modifyUserBean.setUser_id(tempModifyUserBean.getUser_id());
		modifyUserBean.setUser_name(tempModifyUserBean.getUser_name());
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
	}
	public void modifyUserInfo(UserBean modifyUserBean) {
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		userdao.modifyUserInfo(modifyUserBean);
	}
}
