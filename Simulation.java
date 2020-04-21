import java.util.Scanner;
/**
 * Simulation class
 */
public class Simulation{
  //stating variables
  int m_numGames, m_numBattles, m_numWars, m_numDoubleWars;
  int m_maxBattles, m_minBattles, m_maxWars, m_minWars;
  int m_avgBattles, m_avgWars, m_avgDoubleWars;

  /**
   * Default constructor
   * @param numGames [number of games entered by user to play]
   */
  public Simulation(int numGames){
    m_numGames = numGames;
    m_numBattles = 0;
    m_numWars = 0;
    m_numDoubleWars = 0;
    m_maxBattles = Integer.MIN_VALUE;
    m_minBattles = Integer.MAX_VALUE;
    m_maxWars = Integer.MIN_VALUE;
    m_minWars = Integer.MAX_VALUE;
  }

  /**
   * main method
   * @param args [main method]
   */
  public static void main(String[] args){
    //new scanner and ask user input
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter how many games you want to play: ");
    int numGames = kb.nextInt();

    //create the simulation and play, calculate, and report
    Simulation simulator = new Simulation(numGames);

    simulator.simulate();
    simulator.calculate();
    simulator.report();
  }
  /**
   * Simulate class to play the game
   */
  public void simulate(){
    for(int i = 0; i < m_numGames; i++){
      Game newGame = new Game();
      newGame.playGame();

      m_numBattles += newGame.getNumBattles();
      m_numWars += newGame.getNumWars();
      m_numDoubleWars += newGame.getNumDoubleWars();

      if(newGame.getNumBattles() < m_minBattles)
      m_minBattles = newGame.getNumBattles();
      if(newGame.getNumBattles() > m_maxBattles)
      m_maxBattles = newGame.getNumBattles();
      if(newGame.getNumWars() < m_minWars)
      m_minWars = newGame.getNumWars();
      if(newGame.getNumWars() > m_maxWars)
      m_maxWars = newGame.getNumWars();
    }

  }
  /**
   * calculates average
   */
  public void calculate(){
    m_avgBattles = (m_numBattles / m_numGames);
    m_avgWars = (m_numWars / m_numGames);
    m_avgDoubleWars = (m_numDoubleWars / m_numGames);
  }
  /**
   * reports the statistics of the game
   */
  public void report(){
    System.out.println("Average number of battles: " + m_avgBattles);
    System.out.println("Average number of wars: " + m_avgWars);
    System.out.println("Average number of double wars: " + m_avgDoubleWars);
    System.out.println("Max number of battles: " + m_maxBattles);
    System.out.println("Min number of battles: " + m_minBattles);
    System.out.println("Max number of wars: " + m_maxWars);
    System.out.println("Min number of wars: " + m_minWars);
  }
}
