import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LottoArray {
  
  private int[] lottoList = new int[6];
  
  public int[] selectLotto() {
    
    
    for(int i = 0; i < lottoList.length; i++) {
      int no = (int)(Math.random() * 45 + 1);
      
      lottoList[i] = no;
    }
    
    bubbleSort(lottoList);
    
    return lottoList;
  }
  
  public void fileOut(int[] lottoList) {
    
    File file = new File("C:/lotto/lottoNoList2.txt");
    try (FileOutputStream fos = new FileOutputStream(file)){

      fos.write("[".getBytes());
      for(int i = 0; i < lottoList.length; i++) {
        
        fos.write(Integer.valueOf(lottoList[i]).toString().getBytes());
        
        if(i != lottoList.length -1) {
          fos.write(", ".getBytes());
        }
      }
      fos.write("]".getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static void bubbleSort(int[] list) {
    for(int i = 0; i < list.length - 1; i++) {
      for(int j = 0; j < list.length - 1; j++) {
        
        int firstValue = list[j];
        int secondValue = list[j + 1];
        
        if(firstValue > secondValue) {
          int temp = list[j];
          list[j] = list[j + 1];
          list[j + 1] = temp;
        }
      }
    }
  }
  
}
