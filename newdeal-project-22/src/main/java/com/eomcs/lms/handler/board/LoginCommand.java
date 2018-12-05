package com.eomcs.lms.handler.board;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.Command;

@Component("/auth/login")
public class LoginCommand implements Command {
  
  private Scanner keyboard;
  private MemberDao dao;
  
  public LoginCommand(Scanner keyboard, MemberDao dao) {
    this.keyboard = keyboard;
    this.dao = dao;
  }

  @Override
  public void execute() {
    
    System.out.print("이메일? ");
    String email = keyboard.nextLine();
    
    System.out.println("비밀번호?");
    String password = keyboard.nextLine();
    
    Member member = null;
    try {
      member = dao.findByEmailPassword(email, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    if(member != null)
      System.out.printf("%s 로그인 성공", member.getName());
    else
      System.out.println("정보 틀림");
    
  }
}
