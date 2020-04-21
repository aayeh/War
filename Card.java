/**
 * Card Class
 */
public class Card{
  //creating variables
  int m_suit;
  int m_value;

  /**
   * Setting suit and value of card
   * @param suit  [suit of the card]
   * @param value [value of the card]
   */
  public Card(int suit, int value){
    m_suit = suit;
    m_value = value;
  }

  /**
   * returns suit of card
   * @return [suit of card]
   */
  public int getSuit(){
    return m_suit;
  }

  /**
   * returns value of card
   * @return [value of card]
   */
  public int getValue(){
    return m_value;
  }

  /**
   * compares the card to see which has a higher value
   * @param  compareCard [card being compared]
   * @return             [either 1, -1, or 0 depending on which has a higher value]
   */
  public int compare(Card compareCard){
    if(m_value > compareCard.getValue())
      return 1;
    else if(m_value < compareCard.getValue())
      return -1;
    else
      return 0;
  }
}
