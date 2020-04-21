import java.util.LinkedList;

public class Game{
  //creating variables
  int m_numBattles, m_numWars, m_numDoubleWars, m_gameWinner;

  Deck deck;
  Player playerOne, playerTwo;

  LinkedList<Card> playerOnePile = new LinkedList<Card>();
  LinkedList<Card> playerTwoPile = new LinkedList<Card>();

  /**
   * Default constructor
   */
  public Game(){
    m_numBattles = 0;
    m_numWars = 0;
    m_numDoubleWars = 0;
    m_gameWinner = 0;

    deck = new Deck();
    playerOne = new Player(1);
    playerTwo = new Player(2);
  }

  /**
   * returns number of battles
   * @return [number of battles]
   */
  public int getNumBattles(){
    return m_numBattles;
  }

  /**
   * returns number of wars
   * @return [number of wars]
   */
  public int getNumWars(){
    return m_numWars;
  }

  /**
   * returns number of double wars
   * @return [number of double wars]
   */
  public int getNumDoubleWars(){
    return m_numDoubleWars;
  }

  /**
   * returns the winner
   * @return [winner]
   */
  public int getWinner(){
    return m_gameWinner;
  }

  /**
   * plays the game
   */
  public void playGame(){
    while(deck.getSize() > 0){
      playerOne.collect(deck.deal());
      playerTwo.collect(deck.deal());
    }

    while(m_gameWinner == 0){
      playerOnePile.addFirst(playerOne.flip());
      playerTwoPile.addFirst(playerTwo.flip());

      int battleWinner = playerOnePile.getFirst().compare(playerTwoPile.getFirst());
      m_numBattles++;

      if(battleWinner == 0){
        m_numWars++;
        battleWinner = war();
      }
      //random order to prevent infinite game
      int randomAddOrder = (int)(Math.random() * 2);

      if(battleWinner > 0){
        if(randomAddOrder == 1){
          playerOne.collectPile(playerOnePile);
          playerOne.collectPile(playerTwoPile);
        }
        else{
          playerOne.collectPile(playerTwoPile);
          playerOne.collectPile(playerOnePile);
        }
      }
      else if(battleWinner < 0){
        if(randomAddOrder == 1){
          playerTwo.collectPile(playerOnePile);
          playerTwo.collectPile(playerTwoPile);
        }
        else{
          playerTwo.collectPile(playerTwoPile);
          playerTwo.collectPile(playerOnePile);
        }
      }

      if(playerOne.hasWon())
      m_gameWinner = 1;
      else if(playerTwo.hasWon())
      m_gameWinner = 2;
    }
  }
  /**
   * if a war happens
   * @return [winner of the war]
   */
  private int war(){
    for(int i = 0; playerOne.getNumCards() > 0 && i < 4; i++)
    playerOnePile.addFirst(playerOne.flip());
    for(int i = 0; playerTwo.getNumCards() > 0 && i < 4; i++)
    playerTwoPile.addFirst(playerTwo.flip());

    int m_warWinner = playerOnePile.getFirst().compare(playerTwoPile.getFirst());

    if(m_warWinner == 0){
      m_numDoubleWars++;
      m_warWinner = war();
    }

    return m_warWinner;
  }
}
