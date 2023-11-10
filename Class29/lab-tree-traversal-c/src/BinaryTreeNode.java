/**
 * Nodes in a binary tree.
 */
class BinaryTreeNode<T> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The value in this node.
   */
  T value;
  
  /**
   * The left subtree.
   */
  BinaryTreeNode<T> left;
  
  /**
   * The right subtree.
   */
  BinaryTreeNode<T> right;
 
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public BinaryTreeNode(T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  } // BinaryTreeNode(T, BinaryTreeNode, BinaryTreeNode)
  
  public BinaryTreeNode(T value) {
    this(value, null, null);
  } // BinaryTreeNode(T)
} // class BinaryTreeNode<T>
