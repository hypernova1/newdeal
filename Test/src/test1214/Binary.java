package test1214;

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