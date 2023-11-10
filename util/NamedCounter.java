package Class12.util;

public class NamedCounter extends BasicCounter {
  String name;
  public NamedCounter(String name, int start) {
    
    super(start);
    this.name = name;
  } // NamedCounter(String, int)

  @Override
  public String toString() {
    return this.name + super.toString();
  } // toString()
} // class NamedCounter 