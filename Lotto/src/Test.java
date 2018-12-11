public class Test {
  
  //시간 초과.........
  public static String solution(String[] participant, String[] completion) {
    String answer = "";
    int j = 0;
    while(j != completion.length) {
      for(int i = 0; i < participant.length; i++) {
        if(completion[j].equals(participant[i])) {
            participant[i] = null;
            i = participant.length - 1;
        }
      }
      j++;
    }
    for(int i = 0; i < participant.length; i++) {
      if(participant[i] != null) {
        answer = participant[i];
      }
    }
    return answer;
  }
  
  public static void main(String[] args) {
    String[] a = {"mislav", "stanko", "mislav", "ana"};
    String[] b = {"stanko", "ana", "mislav"};
    
    System.out.println(solution(a, b));
    
    
  }
}
