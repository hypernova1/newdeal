package com.eomcs.lms.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Controller("/auth/login")
public class LoginController implements PageController {
  
  private MemberDao memberDao;

  public LoginController(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    Map<String, Object> params = new HashMap<>();
    
    params.put("email", request.getParameter("email"));
    params.put("password", request.getParameter("password"));
    
    Member member = memberDao.findByEmailPassword(params);

    HttpSession session = request.getSession();
    if(member != null) {
      session.setAttribute("loginUser", member);
      return "redirect:/app/board/list";
    } else {
      session.invalidate();
      return "redirect:./form";
    }
  
    
  }
}
