package com.eomcs.lms.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Controller
@RequestMapping("/auth")
public class AuthController {
  
  private MemberDao memberDao;

  public AuthController(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @RequestMapping("login")
  public String login(String email, String password, HttpSession session) throws Exception {
    
    Map<String, Object> params = new HashMap<>();
    
    params.put("email", email);
    params.put("password", password);
    
    Member member = memberDao.findByEmailPassword(params);

    if(member != null) {
      session.setAttribute("loginUser", member);
      return "redirect:/app/board/list";
    } else {
      session.invalidate();
      return "redirect:./form";
    }
  }
  
  @RequestMapping("form")
  public String form() throws ServletException, IOException {
    return "auth/form";
  }
  
  @RequestMapping("logout")
  public String logout(HttpSession session) throws ServletException {
    session.invalidate();
    return "redirect:./login";
  }
}
