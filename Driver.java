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
    System.out.println("Should be {1 }: " + test);
    //now loop addFirst
    for(int i = 2; i < 1001; i++){
      test.addFirst(i);
    }

    try{
      test.addFirst(null);
    } catch(NullPointerException e){
      System.out.println("error was busted");
    }


    System.out.println("testing loop, should go down from 1001 to 0: " + test);
    //cool

  }
}
