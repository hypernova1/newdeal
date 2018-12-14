package test1213;
/*
 * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
 * 124 나라에는 자연수만 존재합니다. 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
 * 
1  1     6 14    11  42
2  2     7 21    12  44                   {1,2,4}
3  4     8 22    13 111
4 11     9 24              1 0바퀴  +1 배열      [0]    1
5 12    10 41              2 0바퀴  +2 배열      [1]    2
                           3 0바퀴  +3 배열      [2]    4
                           4 1바퀴  +1 배열 [0][0]   11
                           5 1바퀴  +2 배열 [0][1]   12
                           6 1바퀴  +3 배열 [0][2]   14
                           7 2바퀴  +1 배열 [1][0]   21
                           8 2바퀴  +2 배열 [1][1]   22 
                           9 2바퀴  +3 배열 [1][2]   24 
                          10 3바퀴  +1 배열 [2][0]   41 
                          11 3바퀴  +2 배열 [2][1]   42   
                          12 3바퀴  +3 배열 [2][2]   44
                       13 4바퀴  +1 배열 [0][0][0]  111 
                       14 4바퀴  +2 배열 [0][0][1]  112 
                       15 4바퀴  +3 배열 [0][0][2]  114 
                       
 */


public class Quiz {

  public static void main(String[] args) {
    System.out.println("결과: " + translator(13));
  }
  public static String translator(int a) {
    
    String[] arr = {"1", "2", "4"};
    String[] arr2;
    StringBuilder sb = new StringBuilder();
    int index = 1;
    while(true) {
      
      arr2 = new String[index];
      for(int i = 0; i < arr2.length; i++) {
      }
    }
    
  }
}

