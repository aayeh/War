import java.util.LinkedList;

/**
 * Deck class
 */
public class Deck{
  //Creating deck linkedlist
  LinkedList<Card> deck;

  /**
   * Creating the deck
   */
  public Deck(){
    deck = new LinkedList<Card>();
    for(int m_suit = 1; m_suit <= 4; m_suit++)
    for(int m_value = 2; m_value <= 14; m_value++)
    deck.addLast(new Card(m_suit, m_value));
  }

  /**
   * Dealing the deck
   * @return [description]
   */
  public Card deal(){
    int random = (int)(deck.size() * Math.random());
    return deck.remove(random);
  }

  /**
   * Returning deck size
   * @return [deck size]
   */
  public int getSize(){
    return deck.size();
  }
}
