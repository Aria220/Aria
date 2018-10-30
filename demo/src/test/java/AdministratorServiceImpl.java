

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.yixutech.demo.entity.Administrator;
import com.yixutech.demo.mapper.AdministratorMapper;
import com.yixutech.demo.service.exception.PasswordNotMatchException;
import com.yixutech.demo.service.exception.UserNameConflictException;
import com.yixutech.demo.service.exception.UserNotFoundException;

@Service("administratorService")
public class AdministratorServiceImpl implements IAdministratorService{

	@Autowired
	private AdministratorMapper administratorMapper;

	public Administrator reg(Administrator Administrator) {
		Administrator data = findAdministratorByUserName(Administrator.getUserName());
		if(data==null) {
			String md5Password = getEncryptedPassword(Administrator.getPassword());
			Administrator.setPassword(md5Password);
			administratorMapper.insert(Administrator);
			return Administrator;
		} else {
			throw new UserNameConflictException("用户名"+Administrator.getUserName()+"已存在");
		}
		
	}

	public Administrator login(String userName, String password) {
		Administrator Administrator = findAdministratorByUserName(userName);
		if(Administrator!=null) {
			String pwd = getEncryptedPassword(password);
			if(pwd.equals(Administrator.getPassword())) {
				Administrator.setPassword(null);
				Administrator.setUserName(null);
				return Administrator;
			} else {
				throw new PasswordNotMatchException("密码错误");
			}
		} else {
			throw new UserNotFoundException("用户不存在");
		}

	}

	public Integer changePassword(Integer id, String oldPassword, String newPassword) {
		
		return null;
	}

	public Administrator findAdministratorById(Integer id) {
		return administratorMapper.findAdministratorById(id);
	}

	public Administrator findAdministratorByUserName(String userName) {
		return administratorMapper.findAdministratorByUserName(userName);
	}

	public String getEncryptedPassword(String password) {
		password = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
		return password;
	}

}
