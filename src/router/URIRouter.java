package router;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardController;
import controller.Controller;
import controller.MainController;

@WebServlet("/")
public class URIRouter extends HttpServlet {
	// Model1 - legacy
	// Model2 - Model view Controller (MVC)

	private Map<String, Controller> uriMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		uriMap.put("/", new MainController());
		uriMap.put("/board", new BoardController());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI(); // 사용자가 요청한 URI
		String context = req.getContextPath();

		uri = uri.substring(context.length());
		Controller c = uriMap.get(uri);

		String views = c.service(req, resp);

		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/" + views + ".jsp");
		rd.forward(req, resp);
	}
}
