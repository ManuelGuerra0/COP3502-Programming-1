/* Manuel Guerra
 * manuelaguerra
 * Section: 11H4
 * Project Number: 4
 * Program that uses arrays and objects to keep track of new pokemon
 * Fixes: 1) Changed getspecies() to getSpecies() in line 34 of the String getSpecies method
 * Total: 1 conceptual change (Capitalization fix)
 */

public class Pokemon {
	
	//Initializes String species and the integers attack, defense, and speed
	String species;
	private int attack;
	private int defense;
	private int speed;
	
	//Increases attack based on boost
	public void grow(int boost) {
		this.attack = attack + boost;
	}
	
	//Increases defense based on boost
	public void harden(int boost) {
		this.defense = defense + boost;
	}
	
	//Increases speed based on boost
	public void haste(int boost) {
		this.speed = speed + boost;
	}
	
	//Returns the name of the Pokemon
	public String getSpecies() {
		return species;
	}
	
	//Stores the name of the Pokemon
	public void setSpecies(String spc) {		
		this.species = spc;
	}
	
	//Returns the current attack stat
	public int getAttack() {
		return this.attack;
	}
	
	//Stores the attack stat of the Pokemon
	public void setAttack(int atk) {
		this.attack = atk;
	}
	
	//Returns the current defense stat
	public int getDefense() {
		return this.defense;
	}
	
	//Stores the defense stat of the Pokemon
	public void setDefense(int def) {
		this.defense = def;
	}
	
	//Returns the current speed stat
	public int getSpeed() {
		return this.speed;
	}
	
	//Stores the speed stat of the Pokemon
	public void setSpeed(int spd) {
		this.speed = spd;
	}
	
	//Calculates the Pokemon's attack, defense, and speed stats based on name length
	public Pokemon(String species) {
		this.species = species;
		this.attack = (species.length() * 4) + 2;
		this.defense = (species.length()*2) + 7;
		this.speed = (species.length()*3) + 5;
	}
}
