package test1214;

<<<<<<< HEAD
/*
  양의 정수 N 내의 이진 간격은 N의 2진수 표시에서 양쪽 끝에 있는 1로 둘러싸인 연속 0의 최대 시퀀스다.
    예를 들어 숫자 9는 이진수 표현 1001을 가지고 있고 길이 2의 이진 간격을 포함하고 있다.
    숫자 529는 이진수 표현 1000010001을 가지고 있고 길이 4와 길이3의 이진 간격을 포함하고 있다.
    숫자 20은 10100의 이진법을 가지고 있고 길이 1의 이진 간격을 포함하고 있다.
    숫자 15는 이진수 표현 1111을 가지고 있고 이진 간격은 없다.
    숫자 32는 100000을 나타내고 이진 간격은 없다.
    
    이는 양의 정수 N으로 주어진 가장 긴 이진 간격의 길이를 반환한다.
    N에 이진 간격이 없으면 함수 0을 반환해야 한다.
    예를 들어 N이 이진수 표현 10000010001이고 가장 긴 이진 간격이 5이므로 함수가 5를 반환해야 한다.
    N은 이진수 표현 '100000'이 있고 따라서 이진 간격이 없기 때문에 N = 32는 0을 반환해야 한다.
    
    다음과 같은 가정에 대한 효율적인 알고리즘 작성
    N은 [1..2,147, 483, 647]범위의 정수다.*/
public class Binary {
  public static void main(String[] args) {
  
    System.out.println(method(529));
  
  }
  
  public static int method(int input) {
    double value = input;
    int intervalCnt = 0;
    int count = 0;
    int[] arr = new int[10];
    int index = 0;
    
    while (!(value / 2 < 1 || value <= 0)) {
  
      if (value % 2 == 1 && (int) (value / 2) % 2 == 0) {
        intervalCnt++;
        index++;
        count = 0;
      }
      
      arr[index] = count++;
      
      value = (value % 2 == 1) ? (value - 1) / 2 : value / 2;
      
    }
    if (intervalCnt == 0) return 0;
    
    int max = arr[0];
    for (int k = 0; k < index + 1; k++) {
      max = (max > arr[k]) ? max : arr[k];
    }
    return max;
    
  }
}
=======
public class Binary {
   public static void main(String[] args) {
      System.out.println(method(529));      //4
      System.out.println(method(2015));     //1
      System.out.println(method(15));       //0
      System.out.println(method(32));       //0
      System.out.println(method(18976));    //3
      System.out.println(method(2130952));  //6
   }

   public static int method(double value) {
      // 공간의 개수
      int spaceCnt = 0;
      // 공간의 크기 (0의 개수)
      int size = 0;
      int[] arr = new int[10];

      while (!(value / 2 < 1 || value <= 0)) {
         // 나머지가 1이고 다음으로 나눠지는 값이 0일 때  ex) xxx01xxx
         if (value % 2 == 1 && (int) (value / 2) % 2 == 0) {
            // 공간 개수 증가
            spaceCnt++;
            // 공간 크기 증가
            size = 1;
         } else if (value % 2 == 0 && size >= 1) {
            //나머지가 0이고  공간이 1개 이상 일때 ex) xxx01xx
            arr[spaceCnt - 1] = size++; //공간의 크기 증가 후 배열에 삽입
         }

         value = (value % 2 == 1) ? (value - 1) / 2 : value / 2;
      }

      size = arr[0];
      // 가장 큰 공간 찾기
      for (int k = 0; k < spaceCnt - 1 + 1; k++)
         size = (size > arr[k]) ? size : arr[k];

      return size;
   }
}
>>>>>>> work
