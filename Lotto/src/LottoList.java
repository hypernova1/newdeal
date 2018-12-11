import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class LottoList {
  
  private List<Integer> lottoList;
  
  public LottoList(List<Integer> list) {
    this.lottoList = list;
  }
  
  public List<Integer> selectNumber() {
    
    while(lottoList.size() < 6) {
      
      int no = (int)(Math.random() * 45 + 1);
      
      if(lottoList.contains(no)) {
        selectNumber();
      }
      lottoList.add(no);
    }
    bubbleSort(lottoList);
    
    return lottoList;
    
  }
  
  public void fileOut(List<Integer> lottoList) {
    
    File file = new File("C:/lotto/lottoNoList.txt");
    try (FileOutputStream fos = new FileOutputStream(file)){

      fos.write("[".getBytes());
      for(int i = 0; i < lottoList.size(); i++) {
        
        fos.write(lottoList.get(i).toString().getBytes());
        
        if(i != lottoList.size() -1) {
          fos.write(", ".getBytes());
        }
      }
      fos.write("]".getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public List<Integer> getLottoList(){
    return lottoList;
  }
  
  public static void bubbleSort(List<Integer> list) {
    for(int i = 0; i < list.size() - 1; i++) {
      for(int j = 0; j < list.size() - 1; j++) {
        
        int firstValue = list.get(j);
        int secondValue = list.get(j + 1);
        
        if(firstValue > secondValue) {
          int temp = list.get(j); //       
          list.add(j , list.get(j + 1));// 
          list.remove(j + 1);
          list.add(j + 1, temp);
          list.remove(j + 2);
        }
      }
    }
    
  }
  
}