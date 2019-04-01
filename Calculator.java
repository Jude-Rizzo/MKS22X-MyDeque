import java.util.*;

public class Calculator{

  //check if input is a mathematical sign
  private static boolean isMath(String s) {
    return (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-") || s.equals("%"));
  }
  //do the math
  private static double doMath(String s, double x, double y){
    if (s.equals("*")){
      return x * y;
    }
    if (s.equals("/")){
      return x / y;
    }
    if (s.equals("+")){
      return x + y;
    }
    if (s.equals("-")){
      return x - y;
    }
    else if (s.equals("%")){
      return x % y;
    }
    return 0.0;
  }
  /*Evaluate a postfix expression stored in s.
    *Assume valid postfix notation, separated by spaces.
    */
  public static double eval(String s){
    String[] sc = s.split(" ");
    MyDeque<Double> deq = new MyDeque<Double>(sc.length);
    for (int i = 0; i < sc.length; i++){
      if (isMath(sc[i])){
        double num1 = deq.removeLast();
        double num2 = deq.removeLast();
        deq.addLast(doMath(sc[i],num2,num1));
        //System.out.println("math num:" + deq.toString());
      }
      else{
        //System.out.println(sc[i]);
        deq.addLast(Double.parseDouble(sc[i]));
        //System.out.println("regular num:" + deq.toString());
      }
    }
    return deq.getLast();
  }
}
