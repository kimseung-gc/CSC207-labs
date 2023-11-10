import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Stack;

/**
 * Simple binary trees.
 */
public class BinaryTree<T> implements Iterable<T> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The root of the tree
   */
  BinaryTreeNode<T> root;

  /**
   * The number of values in the tree.
   */
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty, tree.
   */
  public BinaryTree() {
    this.size = 0;
    this.root = null;
  } // BinaryTree

  /**
   * Create a new, somewhat balanced, tree.
   */
  public BinaryTree(T[] values) {
    this.size = values.length;
    this.root = makeTree(values, 0, values.length);
  } // BinaryTree(T[])

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Dump the tree to some output location.
   */
  public void dump(PrintWriter pen) {
    dump(pen, root, "");
  } // dump(PrintWriter)

  /**
   * Get an iterator for the tree.
   */
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      public boolean hasNext() {
        // STUB
        return false;
      } // hasNext()

      public T next() {
        // STUB
        return null;
      } // next()
    }; // new Iterator()
  } // iterator()

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Dump a portion of the tree to some output location.
   */
  void dump(PrintWriter pen, BinaryTreeNode<T> node, String indent) {
    if (node == null) {
      pen.println(indent + "<>");
    } else {
      pen.println(indent + node.value);
      if ((node.left != null) || (node.right != null)) {
        dump(pen, node.left, indent + "  ");
        dump(pen, node.right, indent + "  ");
      } // if has children
    } // else
  } // dump

  /**
   * Build a tree from a subarray from lb (inclusive) to ub (exclusive).
   */
  BinaryTreeNode<T> makeTree(T[] values, int lb, int ub) {
    if (ub <= lb) {
      return null;
    } else if (ub - lb == 1) {
      return new BinaryTreeNode<T>(values[lb]);
    } else {
      int mid = lb + (ub - lb) / 2;
      return new BinaryTreeNode<T>(values[mid], makeTree(values, lb, mid),
          makeTree(values, mid + 1, ub));
    } // if/else
  } // makeTree(T[], int, int)

  void elements01(PrintWriter pen){
    elements01(pen, this.root);
    pen.print("\n");
    pen.flush();
  }// elements01(PrintWriter)

  void elements02(PrintWriter pen){
    elements02(pen, this.root);
    pen.print("\n");
    pen.flush();
  }// elements01(PrintWriter)

  /**
   * Helper function for printing elements in one line
   */
  void elements01(PrintWriter pen, BinaryTreeNode<T> node){
    if (node != null) {
      pen.print(node.value + " ");
      if ((node.left != null) || (node.right != null)) {
        elements01(pen, node.left);
        elements01(pen, node.right);
      } // if has children
    } // if not null
  }// elements01(PrintWriter, BinaryTreeNode<T>)



  void elements02(PrintWriter pen, BinaryTreeNode<T> node){
    if (node != null) {
      if ((node.left != null) || (node.right != null)) {
        elements02(pen, node.left);
        elements02(pen, node.right);
      } // if has children
      pen.print(node.value + " ");
    } // else
  }// elements01(PrintWriter, BinaryTreeNode<T>)

  /**
   * Print all of the elements in some order or other.
   * 
   * Note: We are trying to avoid recursion.
   */
  public void print(PrintWriter pen) {
    // A collection of the remaining things to print
    Stack<Object> remaining = new Stack<Object>();
    remaining.push(this.root);
    // Invariants: 
    //   remaining only contains Strings or Nodes
    //   All values in the tree are either
    //     (a) already printed,
    //     (b) in remaining, or
    //     (c) in or below a node in remaining
    while (!remaining.isEmpty()) {
      Object next = remaining.pop();
      if (next instanceof BinaryTreeNode<?>) {
        @SuppressWarnings("unchecked")
        BinaryTreeNode<T> node = (BinaryTreeNode<T>) next;
        if (node.right != null) {
          remaining.push(node.right);
        } // if (node.right != null)
        if (node.left != null) {
          remaining.push(node.left);
        } // if (node.left != null)
        remaining.push(node.value);
      } else {
        pen.print(next);
        pen.print(" ");
      } // if/else
    } // while
    pen.println();
  } // print(PrintWriter)

  /**
   * Print all of the elements in some order or other.
   * 
   * Note: We are trying to avoid recursion.
   */
  public void print2(PrintWriter pen) {
    // A collection of the remaining things to print
    Stack<Object> remaining = new Stack<Object>();
    remaining.push(this.root);
    // Invariants: 
    //   remaining only contains Strings or Nodes
    //   All values in the tree are either
    //     (a) already printed,
    //     (b) in remaining, or
    //     (c) in or below a node in remaining
    while (!remaining.isEmpty()) {
      Object next = remaining.pop();
      if (next instanceof BinaryTreeNode<?>) {
        @SuppressWarnings("unchecked")
        BinaryTreeNode<T> node = (BinaryTreeNode<T>) next;
        if (node.right != null) {
          remaining.push(node.right);
        } // if (node.right != null)
        if (node.left != null) {
          remaining.push(node.left);
        } // if (node.left != null)
        if((node.right == null)&&(node.left == null)){
          pen.print(node.value);
          pen.print(" ");
        }else{
          remaining.add(remaining.size(), node.value);
        }
      } else {
        pen.print(next);
        pen.print(" ");
      } // if/else
    } // while
    pen.println();
  } // print(PrintWriter)
} // class BinaryTree
