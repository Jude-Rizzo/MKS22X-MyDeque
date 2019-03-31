import java.util.*;


public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  //initialize those variables like a beast


  //consturctor
@SuppressWarnings("unchecked")
 public MyDeque(){
   data = (E[])new Object[10];
   size = 0;
   start = 0;
   end = 0;

 }

 private boolean isFull(){
   if(size == data.length) return true;
   return false;
 }


@SuppressWarnings("unchecked")
 public MyDeque(int length){
   data = (E[])new Object[length];
   size = 0;
   start = 0;
   end = 0;
 }

 public int size(){
   return size;
 }


public void addFirst(E element) throws NullPointerException{

  if(element == null){
    throw new NullPointerException("Can't add a null");
  }

  if(isFull()){
    resize();
  }
  size += 1;
  if(start > 0){
    start--;
    data[start] = element;
  }
  if(start == 0){
    start = data.length - 1;
    data[start] = element;
  }
}

 public String toString(){
   if(size == 0){
     return "{}";
   }
   String ans = "{";
   if(start < end){
     for(int i = start; i <= end; i++){

       if(data[i] != null) ans += data[i] + " ";

     } return ans + " }";
   }

   if(start > end){
     for(int i = start; i < data.length; i++){
       if(data[i] != null) ans += data[i] + " ";
     }
     for(int i = 0; i <= end; i++){
       if(data[i] != null) ans += data[i] + " ";
     }
   }
   return ans + "}";

 }



 private void resize(){
   E[] dataCopy = Arrays.copyOf(data, data.length);
   @SuppressWarnings("unchecked")
   E[] data = (E[]) new Object[size * 2 + 1];
   int index = 0;
   if(start > end){
     for(int i = start; i < data.length; i++){
       //starts at 0;
       data[i - start] = dataCopy[i];
       index +=1;
     }
     for(int i = 0; i <= end; i++){
       data[i + index] = dataCopy[i];
     }

     start = 0;
     end = end + index;
     //copy to end ad the from start
   }

   if(end >= start){
     for(int i = start; i <= end; i++){
       data[i - start] = dataCopy[i];
     }

     start = 0;
     end = end - start;
   }

 }


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
