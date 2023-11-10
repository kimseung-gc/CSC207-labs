/**
 * Cursors for general trees.
 */
public interface TreeCursor<T> {
  /**
   * Get the value at the current location in the tree.
   */
  public T getValue();
  
  /**
   * Determine if we can move up in the tree.
   */
  public boolean hasParent();
  
  /**
   * Determine whether we have child i.
   */
  public boolean hasChild(int i);
  
  /**
   * Move down in the tree to the ith child.
   */
  public void down(int i);
  
  /**
   * Move up in the tree.
   */
  public void up();
} // TreeCursor<T>
