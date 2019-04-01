import java.util.*;

public class Calculator{


  private static boolean operator(String s) {
    return (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("%"));
  }

  private static double calculate(String s, double a, double b){
    if (s.equals("*")){
      return a * b;
    }
    if (s.equals("/")){
      return a / b;
    }
    if (s.equals("+")){
      return a + b;
    }
    if (s.equals("-")){
      return a - b;
    }
    else if (s.equals("%")){
      return a % b;
    }
    return 0.0;
  }
  /*Evaluate a postfix expression stored in s.
    *Assume valid postfix notation, separated by spaces.
    */
  public static double eval(String s){
    String[] sc = s.split(" ");
    Deque<Double> deq = new Deque<Double>(sc.length);
    for (int i = 0; i < sc.length; i++){
      if (operator(sc[i])){
        double num1 = deq.removeLast();
        double num2 = deq.removeLast();
        deq.addLast(calculate(sc[i],num2,num1));

      }
      else{

        deq.addLast(Double.parseDouble(sc[i]));
      
      }
    }
    return deq.getLast();
  }
}
