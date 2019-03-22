public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 10;
    start = 0;
    end = 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = initialCapacity;
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

    if(size == 1){
      return "{" + data[start] + " }";
    }
    String ans = "{";
    if(start < end){
      for(int i = start; i < end; i++){
        ans += data[i] + " ";
      }
      return ans + " ";
    } else {
      for(int i = start; i < size; i++){
        ans += data[i] + " ";
      }
      for(int i = 0; i < end; i++){
        ans += data[i] + " ";
      }
      return ans + "}";
    }
  }

  private boolean isFull(){
    for(int i = 0; i < size; i++){
      if(data[i] == null){
        return false;
      }
    }
    return true;
  }


  public void addFirst(E element){

  }


  public void addLast(E element){
  }


  //public E removeFirst(){
//  }


  //public E removeLast(){
  //}


  //public E getFirst(){
  //}


  //public E getLast(){
  //}
  @SuppressWarnings("unchecked")
  private void reSize(){
    //if size is 0 make it one
    if(size == 0){
      data = new(E[])new Object[1];
      start = 0;
      end = 0;
      return;
    }
    //make a copy array with double the size
    E[] dataCopy = new(E[])new Object[size];
    if(size == 1){
      dataCopy[start] = data[start]
      data = new(E[])new Object[size * 2];
      start = 0;
      end = 1;

      return;
    }
    //for new cases, copy data into dataCopy
    //then change up data do resize import junit.framework.TestCase;
    
    //copy all the starts into the beginning, then make the array in order again cuz y not

  }