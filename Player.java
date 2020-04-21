import java.util.LinkedList;

/**
 * Player class
 */
public class Player{
  //creating variables
  int m_playerNumber;
  LinkedList<Card> m_playerDeck;

  /**
   * Setting player number and giving them a deck
   * @param playerNumber [number of the player]
   */
  public Player(int playerNumber){
    m_playerNumber = playerNumber;
    m_playerDeck = new LinkedList<Card>();
  }

  /**
   * flips card
   * @return [card on the top of their deck]
   */
  public Card flip(){
    return m_playerDeck.removeFirst();
  }

  /**
   * Collects the new card
   * @param newCard [new card]
   */
  public void collect(Card newCard){
    m_playerDeck.addLast(newCard);
  }

  /**
   * size of player deck
   * @return [size of player deck]
   */
  public int getNumCards(){
    return m_playerDeck.size();
  }

  /**
   * if someone has won
   * @return [true or false depending if someone won]
   */
  public boolean hasWon(){
    if(m_playerDeck.size() >= 52)
    return true;
    return false;
  }

  /**
   * collects pile
   * @param pile [pile of deck]
   */
  public void collectPile(LinkedList<Card> pile){
    while(pile.size() > 0)
    collect(pile.removeFirst());
  }
}
