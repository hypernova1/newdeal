package test1217;

import java.util.Scanner;

// 가위바위보 계단오르기 게임
//
// 1. 계단 개수를 지정한다
//
// 2. 컴퓨터와 가위바위보를 해서 이긴 사람이 계단을 올라간다(입력값 : 가위/바위/보)
// 가위로 이기면 : 2칸
// 바위로 이기면 : 3칸
// 보로 이기면 :5칸
//
// 3. 이기면 '이겼습니다' 출력
// 지면 '졌습니다' 출력
//
// 4. 게임이 끝나면
// '다시 하시겠습니까?'를 출력
// y -> 1번부터 다시 시작
// n -> 게임 끝
public class Peeping {
  public static void main(String[] args) {
    game();
  }

  public static void game() {
    Scanner scan = new Scanner(System.in);
    System.out.println("계단 수를 정하세요");
    int stair = scan.nextInt();
    int myStair = stair;
    int enemyStair = stair;
    String val = null;

    while (true) {
      System.out.println("가위 바위 보(S, R, P)!");
      val = scan.next().toUpperCase();
      if (!(val.equals("S") || val.equals("R") || val.equals("P"))) {
        System.out.println("잘못된 값 다시 입력");
        continue;
      }

      RSP enemy = RSP.values()[(int) (Math.random() * 2 + 1)];
      RSP me = RSP.valueOf(val);

      if (me.win == enemy.toString()) {
        myStair -= me.value;
        System.out.printf("이김! 나: %d, 적: %d\n", myStair, enemyStair);
      } else if (me.defeat == enemy.toString()) {
        enemyStair -= enemy.value;
        System.out.printf("짐 나: %d, 적: %d\n", myStair, enemyStair);
      } else {
        System.out.println("비김");
      }

      if (myStair <= 0 || enemyStair <= 0) {
        System.out.println("다시 하시겠습니까? (y/n)");
        val = scan.next();
        if (val.toLowerCase().equals("y"))
          game();
        else if (val.toLowerCase().equals("n")) {
          scan.close();
          System.out.println("종료");
          return;
        }
      }
    }
  }

  enum RSP {
    S("P", "R", 2), R("S", "P", 3), P("R", "S", 5);
    private String win;
    private String defeat;
    private int value;

    private RSP(String win, String defeat, int value) {
      this.win = win;
      this.defeat = defeat;
      this.value = value;
    }
  }
}
