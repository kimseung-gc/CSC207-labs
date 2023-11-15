import org.junit.jupiter.api.BeforeEach;

/**
 * Tests of chained hash tables.
 */
public class ChainedHashTableTests extends SimpleMapTests {
  /**
   * Set up the string map.
   */
  @BeforeEach
  public void setupChainedHashTableTests() {
    stringMap = new ChainedHashTable<String,String>();
    runIteratorTests = false;
  } // setupChainedHashTableTests()
} // class ChainedHashTableTests