package test1217;

// 자기 자신을 제외한 모든 양의 약수들의 합이 자기 자신이 되는 자연수를 완전수라고 한다. 예를 들면, 6과 28은 완전수이다.
// 6=1+2+3 // 1,2,3은 각각 6의 약수 28=1+2+4+7+14 // 1,2,4,7,14는 각각 28의 약수
// 입력으로 n을 받고 출력으로 n 이하의 모든 완전수를 출력력하는 코드 작성
public class PerfectNumber {
  public static void main(String[] args) {
    for (int i : method(10000)) {
      System.out.println(i);
    }
    
  }

  public static int[] method(int num) {
    int[] result = new int[10];
    int index = 0;
    for (int i = num; i >= 6; i--) {
      int sum = 0;
      for (int j = i; j > 1; j--) {
        if (i % j == 0) sum += i / j;
      }
      if (sum == i) result[index++] = i;
    }
    return result;
  }
}
