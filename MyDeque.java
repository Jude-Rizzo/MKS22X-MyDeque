import java.util.*;


public class MyDeque<E>{
  private E[] data;
  public int size, start, end, fits;
  //initialize those variables like a beast


  //consturctor
@SuppressWarnings("unchecked")
 public MyDeque(){
   data = (E[])new Object[10];
   size = 0;
   start = 0;
   end = 0;
   fits = 10;

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
   fits = length;
 }

 public int size(){
   return size;
 }


 public void addFirst(E element) {
   if (element == null) throw new NullPointerException();
   if (size == fits)
     resize();

   if (size == 0)
     if (end == fits) end = 1;
     else end += 1;
   else if (start == 0)
     start = fits-1;
   else
     start--;

   data[start] = element;
   size++;
 }

 public void addLast(E element) {
   if (element == null) throw new NullPointerException();
   if (size == fits)
     resize();

   if (end == fits) {
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

public E removeFirst() {
  if (size == 0) throw new NoSuchElementException();
  E out = data[start++];
  if (start == fits) start = 0;
  size--;
  return out;
}

  public E removeLast(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    E ans = data[end];
    if (end == 0){
      end = size-1;
    }
    else{
      end--;
    }
    size--;
    return ans;
  }

  public String toString() {
		String ans = "{";
		if (size == 0) {}
		else if (start < end) {
			for (int i = start; i < end; i++) {
				ans +=(data[i].toString());
				ans += (" ");
			}
		} else {
			for (int i = start; i < fits; i++) {
				ans += (data[i].toString());
				ans += (" ");
			}
			for (int i = 0; i < end; i++) {
				ans += data[i].toString();
				ans += (" ");
			}
		}
		ans += "}";
		return ans;
	}



 private void resize() {
   @SuppressWarnings("unchecked")
   E[] copy = (E[])new Object[fits <<1];
   int j = -1;

   if (start < end) {
     for (int i = start; i < end; i++)
       copy[++j] = data[i];
   } else {
     for (int i = start; i < data.length; i++)
       copy[++j] = data[i];
     for (int i = 0; i < end; i++)
       copy[++j] = data[i];
   }

   fits <<=1;
   data = copy;
   start = 0;
   end = j+1;
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
