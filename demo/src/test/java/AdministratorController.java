

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.yixutech.demo.service.IAdministratorService;

@Controller
@RequestMapping("/admin")
public class AdministratorController {
	//@Autowired
	//private IAdministratorService administratorService;
	
	@RequestMapping("/reg")
	public String showReg() {
		return "admin_reg";
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "admin_login";
	}
	
	@RequestMapping("/change_password")
	public String showChangePassword() {
		return "user_change_password";
	}
	
}
