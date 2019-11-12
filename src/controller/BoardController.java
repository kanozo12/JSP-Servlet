package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController implements Controller{
	@Override
	public String service(HttpServletRequest req, HttpServletResponse resp) {
	
		return "index";
	}
}
