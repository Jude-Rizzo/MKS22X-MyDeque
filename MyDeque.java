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
   size = size * 2 + 1;
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





}
