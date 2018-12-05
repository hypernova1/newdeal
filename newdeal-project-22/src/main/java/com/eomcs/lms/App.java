package com.eomcs.lms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.handler.Command;

public class App {

  private static Stack<String> commandHistory = new Stack<>();
  private static Queue<String> commandHistory2 = new LinkedList<>();
  private static Scanner keyboard;

  public static void main(String[] args) throws Exception {

    
    // AppConfig 클래스가 메모리에 로딩되어 있지 않다면, 즉시 로딩 후 그 로딩된 클래스 정보를 리턴
    Class<?> clazz = Class.forName("com.eomcs.lms.AppConfig");
    clazz.getMethods();

    // Spring IoC 컨테이너 준비
    AnnotationConfigApplicationContext iocContainer =
        new AnnotationConfigApplicationContext(AppConfig.class);

    /*
     * System.out.println(iocContainer.getBeanDefinitionCount());
     * 
     * String[] names = iocContainer.getBeanDefinitionNames();
     * 
     * for(String name : names) { System.out.printf("%s ==> %s\n", name,
     * iocContainer.getBean(name).getClass().getName()); }
     */


    while (true) {
      
      keyboard = (Scanner) iocContainer.getBean("keyboard");
      
      String command = prompt();
      commandHistory.push(command);
      commandHistory2.offer(command);
      
      try {
        Command commandHandler = (Command) iocContainer.getBean(command);

        if (commandHandler != null) {
          try {
            commandHandler.execute();
          } catch (Exception e) {
            System.out.println("명령어 처리중 오류 발생");
          }

        }
      } catch (Exception e) {
        if (command.equals("quit")) {
          System.out.println("안녕!");
          break;
          
        } else if (command.equals("history")) {
          printCommandHistory();
          
        } else if (command.equals("history2")) {
          printCommandHistory2();
          
        } else {
          System.out.println("실행할 수 없는 명령입니다.");
        }
        
        System.out.println();
      }
    }
    keyboard.close();
    iocContainer.close();
  }

  private static void printCommandHistory() {
    Iterator<String> iterator = commandHistory.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private static void printCommandHistory2() {
    Iterator<String> iterator = commandHistory2.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
