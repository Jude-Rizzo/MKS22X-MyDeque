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
    data = resize();

  }
  size += 1;
  if(start > 0){
    start--;
    data[start] = element;
  } else {
  if(start == 0){
    start = data.length - 1;
    data[start] = element;
  }
}
//you have to now deal with the case if end = start after you adds
if(end == start){
  //first deal with the fact that if theyre not on the ends
  if(end != 0){
    end -= 1;
  } else {
    //then end is 0
    end = data.length - 1;
  }

}

//System.out.println(Arrays.toString(data));
//System.out.println("start : " + data[start]);
//System.out.println("end : " + data[end]);

//OK, so resize is the issue

}


public E getFirst() throws NoSuchElementException{
  if(size == 0) throw new NoSuchElementException("que is empty");
  return data[start];
}

public E removeFirst() throws NoSuchElementException{
  E val = getFirst();
  data[start] = null;
  if(start == data.length - 1){
    start = 0;
    return val;
  }
  start ++;
  return val;
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



 private E[] resize(){
   E[] dataCopy = Arrays.copyOf(data, data.length);
   @SuppressWarnings("unchecked")
   E[] data = (E[]) new Object[size * 2 + 1];
   int index = 0;

   //only case where start and end are equal are for size 1
   if(start == end){
     return data;
   }
   if(start > end){
     for(int i = start; i < dataCopy.length; i++){
       //starts at 0;
       data[i - start] = dataCopy[i];
       index +=1;

       //System.out.println(Arrays.toString(data));
       //System.out.println("loop 1");
     }
     for(int i = 0; i <= end; i++){
       data[i + index] = dataCopy[i];
       //System.out.println(Arrays.toString(data));
       //System.out.println("loop 2");
     }

     start = 0;
     end = end + index;
     //copy to end ad the from start
   } else {

    if(end > start){
     for(int i = start; i <= end; i++){
       data[i - start] = dataCopy[i];
       //System.out.println(Arrays.toString(data));
       //System.out.println("loop 3");
     }

     start = 0;
     end = end - start;
   }
 }
   return data;
 }


 public static void main(String[] ans){
   //test const



   MyDeque<Integer> test = new MyDeque<Integer>(2);

   System.out.println("\n");
   System.out.println("Testing the adds now");
   test.addFirst(1);
   System.out.println("Should be {1 }: " + test);
   //now loop addFirst
   for(int i = 2; i < 5; i++){
     test.addFirst(i);
   }
   System.out.println("testing loop, should go down from 20 to 0: " + test);
 }





}
