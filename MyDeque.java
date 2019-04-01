import java.util.*;


public class MyDeque<E>{
  private E[] data;
  public int size, start, end;
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


 public void addFirst(E element) {
   if (element == null) throw new NullPointerException();
   if (size == data.length)
     resize();

   if (size == 0)
     if (end == data.length) end = 1;
     else end += 1;
   else if (start == 0)
     start = data.length-1;
   else
     start--;

   data[start] = element;
   size++;
 }

 public void addLast(E element) {
   if (element == null) throw new NullPointerException();
   if (size == data.length) // we are full
     resize();

   if (end == data.length) {
     data[0] = element;
     end = 1;
   } else {
     data[end] = element;
     end++;
   }

   size++;
 }

//System.out.println(Arrays.toString(data));
//System.out.println("start : " + data[start]);
//System.out.println("end : " + data[end]);

//OK, so resize is the issue


public E getLast() throws NoSuchElementException{
  if(size == 0) throw new NoSuchElementException("que is empty");
  return data[end];
}


public E getFirst() throws NoSuchElementException{
  if(size == 0) throw new NoSuchElementException("que is empty");
  return data[start];
}

public E removeFirst(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    E og = data[start];
    if (start == size-1){
      start = 0;
    }
    else{
      start++;
    }
    size--;
    return og;
  }
  public E removeLast(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    E og = data[end];
    if (end == 0){
      end = size-1;
    }
    else{
      end--;
    }
    size--;
    return og;
  }

 public String toString(){
   if(size == 0){
     return "{}";
   }

   if(size == 1){
     return "{" + data[end] + " }";
   }

   String ans = "{";
   if(start <= end){
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
     if(size == 0) return data;
     if(size == 1){
       data[0] = dataCopy[start];
       end = 0;
       start = 0;
     }
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
   MyDeque<Integer> test = new MyDeque<Integer>();
   System.out.println(test);
   test.addLast(0);
   test.addLast(1);
   for(int i = 2; i < 20; i ++){
     test.addFirst(i);
   }
   System.out.println(test);

   for(int i = 0; i < 20; i ++){
     test.removeFirst();
   }


   System.out.println(test);

   //System.out.println(test.removeFirst());
  // System.out.println("size: " + test.size());


  }
}
