package Class12.util;

public class DecrementableCounter extends BasicCounter {
  public DecrementableCounter(int start) {
    super(start);
  } // DecrementableCounter(int)

  public void decrement(){
    count--;
  }
} // class DecrementableCounter
