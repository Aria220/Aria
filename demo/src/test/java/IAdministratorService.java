

import com.yixutech.demo.entity.Administrator;

public interface IAdministratorService {
	
	/**
	 * 用户注册
	 * @param Administrator
	 * @return
	 */
	Administrator reg(Administrator administrator);
	/**
	 * 用户登录
	 * @param Administratorname
	 * @param password
	 * @return
	 */
	Administrator login(String userName,String password);
	/**
	 * 修改密码
	 * @param id 
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	Integer changePassword(Integer id,String oldPassword,String newPassword);
	/**
	 * 通过id查找用户数据
	 * @param id
	 * @return
	 */
	Administrator findAdministratorById(Integer id);
	/**
	 * 通过用户名查找用户数据
	 * @param Administratornam
	 * @return
	 */
	Administrator findAdministratorByUserName(String userName);
	/**
	 * 对密码加密
	 * @param password
	 * @param salt
	 * @return
	 */
	String getEncryptedPassword(String password);
}
