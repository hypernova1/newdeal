package test1214;

import java.util.Scanner;

public class IdCard {

  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
    
    System.out.println("주민번호 입력(-포함):");
    String number = null;
    
    while(true) {
      number = scan.nextLine();
      if(!checkdigit(number)) {
        System.out.println("자릿수가 맞지 않음 다시입력");
        continue;
      }
      if(!checkNumber(number)) {
        System.out.println("뒷자리가 이상함 다시 입력");
        continue;
      }
      
      System.out.println(checkGender(number));
      scan.close();
      break;
 
    }
  }  
  public static boolean checkdigit(String id) {
    
    if(id.length() != 14) return false;
    
    return true;
  }
  
  public static boolean checkNumber(String id) {
    
    String a = id.substring(7, 8);
    boolean result;
    
    switch(a) {
      case "1": case "2": case "3": case "4":
        result = true; break;
      default:
        result = false; break;
    }
    return result;
  }
  
  public static String checkGender(String id) {
    
    String a = id.substring(7, 8);
    String gender;
    switch(a) {
      case "1": case "3": gender = "male"; break;
      case "2": case "4": gender = "female"; break;
      default: gender = null;
    }
    
    return gender;
    
    
  }
  
}
