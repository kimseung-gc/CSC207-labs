import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;
import java.util.function.BiConsumer;

/**
 * A simple implementation of binary search trees.
 */
public class SimpleBST<K,V> implements SimpleMap<K,V> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The root of our tree. Initialized to null for an empty tree.
   */
  BSTNode<K,V> root;

  /**
   * The comparator used to determine the ordering in the tree.
   */
  Comparator<? super K> comparator;

  /**
   * The size of the tree.
   */
  int size;
  
  /**
   * A cached value (useful in some circumstances.
   */
  V cachedValue;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new binary search tree that orders values using the 
   * specified comparator.
   */
  public SimpleBST(Comparator<? super K> comparator) {
    this.comparator = comparator;
    this.root = null;
    this.size = 0;
    this.cachedValue = null;
  } // SimpleBST(Comparator<K>)

  /**
   * Create a new binary search tree that orders values using a 
   * not-very-clever default comparator.
   */
  public SimpleBST() {
    this((k1, k2) -> k1.toString().compareTo(k2.toString()));
  } // SimpleBST()


  // +-------------------+-------------------------------------------
  // | SimpleMap methods |
  // +-------------------+

  @Override
  public V set(K key, V value) {
    return set(key, new BSTNode<K,V>(key, value), this.root);
  } // set(K,V)

  @Override
  public V get(K key) {
    if (key == null) {
      throw new NullPointerException("null key");
    } // if
    return get(key, root);
  } // get(K,V)

  @Override
  public int size() {
    return this.size;
  } // size()

  @Override
  public boolean containsKey(K key) {
    return containsKey(key, this.root);
  } // containsKey(K)

  @Override
  public V remove(K key) {
    if(!this.containsKey(key)){
      return null;
    } // if
    size--;
    return remove(key, this.root);
  } // remove(K)

  @Override
  public Iterator<K> keys() {
    return new Iterator<K>() {
      Iterator<BSTNode<K,V>> nit = SimpleBST.this.nodes();

      @Override
      public boolean hasNext() {
        return nit.hasNext();
      } // hasNext()

      @Override
      public K next() {
        return nit.next().key;
      } // next()

      @Override
      public void remove() {
        nit.remove();
      } // remove()
    };
  } // keys()

  @Override
  public Iterator<V> values() {
    return new Iterator<V>() {
      Iterator<BSTNode<K,V>> nit = SimpleBST.this.nodes();

      @Override
      public boolean hasNext() {
        return nit.hasNext();
      } // hasNext()

      @Override
      public V next() {
        return nit.next().value;
      } // next()

      @Override
      public void remove() {
        nit.remove();
      } // remove()
    };
  } // values()

  @Override
  public void forEach(BiConsumer<? super K, ? super V> action) {
    forEach(action, this.root);
  } // forEach

  // +----------------------+----------------------------------------
  // | Other public methods |
  // +----------------------+

  /**
   * Dump the tree to some output location.
   */
  public void dump(PrintWriter pen) {
    dump(pen, root, "");
  } // dump(PrintWriter)


  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Dump a portion of the tree to some output location.
   */
  void dump(PrintWriter pen, BSTNode<K,V> node, String indent) {
    if (node == null) {
      pen.println(indent + "<>");
    } else {
      pen.println(indent + node.key + ": " + node.value);
      if ((node.left != null) || (node.right != null)) {
        dump(pen, node.left, indent + "  ");
        dump(pen, node.right, indent + "  ");
      } // if has children
    } // else
  } // dump
  
  /**
   * Get the value associated with a key in a subtree rooted at node.  See the
   * top-level get for more details.
   */
  V get(K key, BSTNode<K,V> node) {
    if (node == null) {
      throw new IndexOutOfBoundsException("Invalid key: " + key);
    } // if
    int comp = comparator.compare(node.key, key);
    if (comp == 0) {
      return node.value;
    } else if (comp < 0) {
      return get(key, node.right);
    } else {
      return get(key, node.left);
    } // if/else
  } // get(K, BSTNode<K,V>)

  /**
   * Get an iterator for all of the nodes. (Useful for implementing the 
   * other iterators.)
   */
  Iterator<BSTNode<K,V>> nodes() {
    return new Iterator<BSTNode<K,V>>() {

      Stack<BSTNode<K,V>> stack = new Stack<BSTNode<K,V>>();
      boolean initialized = false;

      @Override
      public boolean hasNext() {
        checkInit();
        return !stack.empty();
      } // hasNext()

      @Override
      public BSTNode<K,V> next() {
        checkInit();
        if (hasNext()) {
          return stack.pop();
        } // if
        return null;
      } // next();

      void checkInit() {
        if (!initialized) {
          stack.push(SimpleBST.this.root);
          initialized = true;
        } // if
      } // checkInit
    }; // new Iterator
  } // nodes()

  /**
   * Helper method for set. It can replace the node associated with key
   * with the replacingNode (comes handy when removing).
   */
  V set(K key, BSTNode<K, V> replacingNode, BSTNode<K, V> current) throws IllegalStateException{
    /* Check for undeclared roots */
    if(this.root == null){
      /* if undeclared, declare the root with the replacing node */
      this.root = replacingNode;
      /* increment the size */
      size++;
      /* return null */
      return null;
    } else if(current == null){
      throw new IllegalStateException("FATAL! The set function could not replace the nodes!\n"+
                                      "Either improper access to the set function or improper\n" +
                                      "initialization of the binary search tree!");
    } // if/else
    /* temporary variable for returning */
    V ret = current.value;
    /* When the right is not null, */
    if(current.right != null){
      /* Do the comparison on the right of the current node */
      int comparison = this.comparator.compare(key, current.right.key);
      /* If key matches */
      if(comparison == 0){
        /* replace the nodes */
        current.right = replacingNode;
        /* return the temporarily saved value */
        return ret;
      } // if
    } // if
    /* When the left is not null, */
    if(current.left != null){
      /* Do the comparison on the left of the current node */
      int comparison = this.comparator.compare(key, current.left.key);
      /* When the keys match */
      if(comparison == 0){
        /* Replace the node */
        current.left = replacingNode;
        /* return the temporarily saved value */
        return ret;
      } // if
    } // if
    /* Otherwise, do the comparison on the current node */
    int comparison = this.comparator.compare(key, current.key);
    /* When they match */
    if(comparison == 0){
      /* Replace the values */
      current.value = replacingNode.value;
      return ret;
    }else if(comparison < 0){
      if(current.left == null){
        size++;
        current.left = replacingNode;
        return null;
      } // if
      return set(key, replacingNode, current.left);
    } // if/else
    if(current.right == null){
      size++;
      current.right = replacingNode;
      return null;
    } // if
    return set(key, replacingNode, current.right);
  } // set()

  /**
   * Helper method
   * @param action
   * @param nextNode
   */
  void forEach(BiConsumer<? super K, ? super V> action, BSTNode<K, V> nextNode){
    if(nextNode == null){
      return;
    }// if
    action.accept(nextNode.key, nextNode.value);
    forEach(action, nextNode.left);
    forEach(action, nextNode.right);
  } // forEach(BiConsumer<? super K, ? super V>, BSTNode<K, V>)

  /**
   * Searches through the tree whether the key is inside.
   * @param key
   * @param node
   * @return
   */
  boolean containsKey(K key, BSTNode<K, V> node){
    if(node == null){
      return false;
    } // if
    int comparison = this.comparator.compare(key, node.key);
    if(comparison == 0){
      return true;
    } else if(comparison < 0){
      return containsKey(key, node.left);
    }// if/else
    return containsKey(key, node.right);
  } // containsKey(K, BSTNode<K, V>)

  /**
   * Gets the right most node of the headNode
   * @param headNode
   * @return
   */
  BSTNode<K, V> getRightMost(BSTNode<K, V> headNode){
    if(headNode == null){
      return null;
    } else if(headNode.right == null){
      return headNode;
    } // if/else
    return getRightMost(headNode.right);
  } // getRightMost(BSTNode<K, V>)

  /**
   * The helper method for remove.
   * @param key
   * @param current
   * @return
   */
  V remove(K key, BSTNode<K, V> current){
    if(current == null){
      return null;
    }//if
    int comp = comparator.compare(key, current.key);
    if(comp == 0){
      V ret = current.value;
      BSTNode<K, V> rightMostOfLeft = getRightMost(current.left);
      if(rightMostOfLeft == null){
        current = current.right;
        return ret;
      } // if
      K temp = rightMostOfLeft.key;
      current.value = rightMostOfLeft.value;
      set(rightMostOfLeft.key, rightMostOfLeft.left, this.root);
      current.key = temp;
      return ret;
    }else if (comp < 0){
      return remove(key, current.left);
    } // if/else
    return remove(key, current.right);
  } // remove(K, BSTNode<K, V>)
} // class SimpleBST
