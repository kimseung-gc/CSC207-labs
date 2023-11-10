package Class12.util;

public class BasicCounter implements Counter{
  protected int count;
  protected int start;

  public BasicCounter(int start){
    this.start = start;
    this.count = start;
  }

  public BasicCounter(){
    this.start = 0;
    this.count = 0;
  }

  public void increment() throws Exception{
    this.count++;
  }

  public void reset(){
    this.count = this.start;
  }

  public String toString(){
    return "[" + this.count + "]";
  }

  public int get(){
    return this.count;
  }
}
