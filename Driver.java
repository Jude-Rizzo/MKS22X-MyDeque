public class Driver{

  public static void main(String[] ans){
    //test const
    System.out.println("Testing the empty constructor");
    MyDeque<Integer> tester = new MyDeque<Integer>();
    System.out.println("Should be empty {} : " + tester.toString());
    MyDeque<Integer> test = new MyDeque<Integer>(10);
    System.out.println("Should be empty {} : " + tester.toString());
    System.out.println("\n");
    System.out.println("Testing the adds now");
    test.addFirst(1);
    System.out.println(test);

  }
}
