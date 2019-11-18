package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import domain.LoginDTO;
import domain.UserVO;

public class MainController implements Controller{
	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		if(req.getMethod().equalsIgnoreCase("post")) {
			//원래는 여기서 값이 넘어오지 않는가도 검사를 해야해.
			String id = req.getParameter("id");
			String pass = req.getParameter("password");
			LoginDTO dto = new LoginDTO(id, pass);
			
			UserVO user = MemberDAO.getInstance().login(dto); //로그인 처리
			if(user != null) {
				HttpSession s = req.getSession();
				s.setAttribute("user", user);
				
				return "redirect::/";
			}else {
				HttpSession s = req.getSession();
				s.setAttribute("msg", "로그인 실패, 아이디와 비밀번호 확인");
				resp.sendRedirect("/");
			}
		}
		return "main";
	}
}
