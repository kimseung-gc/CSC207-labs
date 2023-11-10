package Class6;

public class exp{
  int val;
  exp next;
  exp start;
  exp last;

  public exp(int value){
    this.val = value;
    this.start = this;
    this.last = this;
  }

  public exp(){
    this.val = 0;
    this.start = this;
    this.last = this;
  }

  public void append(int num){
    this.last.next = new exp(num);
    
  }
}