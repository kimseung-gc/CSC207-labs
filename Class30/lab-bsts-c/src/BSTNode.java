/**
 * Nodes in a binary search tree.
 */
class BSTNode<K,V> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The key.  May not be null.
   */
  K key;

  /**
   * The associated value.
   */
  V value;

  /**
   * The left subtree.
   */
  BSTNode<K,V> left;

  /**
   * The right subtree.
   */
  BSTNode<K,V> right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new node.
   */
  public BSTNode(K key, V value) {
    this.key = key;
    this.value = value;
    this.left = null;
    this.right = null;
  } // BSTNode(K,V)

} // class BSTNode<K,V>
