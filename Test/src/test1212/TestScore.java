package test1212;

public class TestScore {
  public static void main(String[] args) {
    
    //1
    int[] score = new int[] {79,88,97, 54, 56, 85};
    int max = score[0];
    int min = score[0];
    
    for(int i = 1; i < score.length; i++) {
      max = (max < score[i]) ? score[i] : max;
      min = (min > score[i]) ? score[i] : min;
    }
    System.out.println(max + " " + min);
    
    //1. 총 과목수
    //2. 점수의 합
    //3. 점수의 평균을 구하세요  (2,3 번은 하나의 for문에서)
    int sum = 0;
    float average = 0f;
    int[] jumsu = {100,55,90,60,78};
    
    for(int i = 0; i < jumsu.length; i++) {
      sum += jumsu[i];
      if(i == jumsu.length - 1) {
        average = (float) sum / jumsu.length;
      }
    }
    
    System.out.println("과목수: " + (jumsu.length));
    System.out.println("점수의 합: " + sum);
    System.out.println("평균: " + average);
  }
}
