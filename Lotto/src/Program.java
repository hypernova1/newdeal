import java.util.ArrayList;

public class Program {
  public static void main(String[] args) {
    
    LottoList lotto = new LottoList(new ArrayList<>());
    LottoArray lotto2 = new LottoArray();
    lotto.fileOut(lotto.selectNumber());
    lotto2.fileOut(lotto2.selectLotto());
    
  }
}
