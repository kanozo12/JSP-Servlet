package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String service(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
