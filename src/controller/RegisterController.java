package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import domain.UserVO;

public class RegisterController implements Controller {
	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		if (req.getMethod().equalsIgnoreCase("POST")) {
			String id = req.getParameter("id");
			String pass = req.getParameter("password");
			String name = req.getParameter("name");
			UserVO user = new UserVO(id, pass, name);

			HttpSession session = req.getSession();
			if (MemberDAO.getInstance().register(user)) {
				session.setAttribute("msg", "성공적으로 회원가입 되었습니다.");
				return "redircet://"; // 로그인 성공 후 리다이랙트
			} else {
				session.setAttribute("msg", "회원가입 실패");
				return "register";
			}
		}

		return "register";
	}
}
