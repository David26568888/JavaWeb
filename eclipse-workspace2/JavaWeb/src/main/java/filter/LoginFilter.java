package filter;

import java.io.IOException;

import org.eclipse.tags.shaded.org.apache.bcel.generic.IF_ACMPEQ;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//有登入才放行的過濾器
//@WebFilter(urlPatterns = {"/user","/user/delete","/user/change/password"})
@WebFilter(urlPatterns = {"/user/*","/beverage","/japanese/class/level","/chart"})
public class LoginFilter extends HttpFilter{
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//判斷是否有登入
		HttpSession session = req.getSession(false);
		if(session==null||session.getAttribute("username")==null) {
			//記住requestURL
			String requestURI =req.getRequestURI();
			session =req.getSession();
			session.setAttribute("requestURI", requestURI);
			
			req.setAttribute("message",requestURI+ "網址需要登入才能使用，請貴賓先登入");
		
			req.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(req, resp);
			
			return;
		}
		//放行
		chain.doFilter(req, resp);
	}
}
