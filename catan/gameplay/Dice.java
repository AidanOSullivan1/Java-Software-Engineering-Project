package gameplay;

import java.util.Random;

public class Dice {
	private Random dice;
	
	/**
	 * constructor for Dice object only used within the gameplay pacckage.
	 */
	protected Dice() {
		this.dice = new Random();
	}
	
	/**
	 * rollDice simulates the rolling of 2 6-sided die
	 * @return an int between 1 and 6, the value of your roll.
	 */
	public int rollDice(){
	    int roll = (dice.nextInt(6)+1); //6+1
	    
	    System.out.println("  _____");
	    System.out.println(" /\\'  .\\    _____");
	    System.out.println("/: \\____\\  / .  /\\");
	    System.out.println("\\' / .  / /____/..\\");
	    System.out.println(" \\/____/  \\'  '\\  /");
	    System.out.println("           \\'__'\\/ ");
	    System.out.println("\nYou rolled "+roll+"!\n");
	    return roll;
	}

}
