public class Driver{

  public static void main(String[] ans){
    //test const
    System.out.println("Testing the empty constructor");
    MyDeque<Integer> tester = new MyDeque<Integer>();
    System.out.println("Should be empty {} : " + tester.toString());
    MyDeque<Integer> test = new MyDeque<Integer>(2);
    System.out.println("Should be empty {} : " + tester.toString());
    System.out.println("\n");
    System.out.println("Testing the adds now");
    test.addFirst(1);
    test.addFirst(2);

  //  System.out.println("Should be {1 }: " + test);
    System.out.println(test);
    System.out.println("size: " +  test.size());
    System.out.println(test.removeFirst());
    System.out.println(test);
    System.out.println("\n");
    System.out.println("size: " + test.size());
    System.out.println(test.removeFirst());
    System.out.println(test);
    System.out.println(test.removeFirst());
    System.out.println("size: " + test.size());
}
}
