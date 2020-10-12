/* Manuel Guerra
 * manuelaguerra
 * Section: 11H4
 * Project Number: 4
 * Program that uses arrays and objects to keep track of new pokemon
 * Fixes: 1) Changed getspecies() to getSpecies() lines 39, 64, 92, and 125 of the Pokedex class
 * Total: 1 conceptual change (Capitalization fix)
 */

public class Pokedex {
	
	//Initializes Pokemon array
	static Pokemon[] pokemon;
	
	//Creates Pokemon object and sets Pokedex limit based on user input
	public Pokedex(int size) {
		Pokemon[] Pokemon = new Pokemon[size];
		pokemon = Pokemon;
	}
	
	//Method for Pokedex option 1: List Pokemon (case 1)
	public String[] listPokemon() {
		int pokemonSize = 0;
		
		//Makes sure that the pokemon entered are valid
		for(int i = 0; i < pokemon.length; i++) {
			if(pokemon[i] == null) {
				break;
			}
			else {
				pokemonSize++;
			}
		}
		//Creates new object for the list of pokemon
		String[] pokemonList = new String[pokemonSize];
		
		//Recalls all the stored pokemon and returns an array of pokemon
		for(int j = 0; j < pokemonSize; j++) {
			pokemonList[j] = pokemon[j].getSpecies();
		}
		if(pokemon[0] == null) {
			pokemonList = null;
			return pokemonList;
		}
		else {
			return pokemonList;
		}
	}
	
	//Method for Pokedex option 2: Add Pokemon (case 2)
	public boolean addPokemon(String species) {
		
		for(int i = 0; i < pokemon.length; i++) {
			//Makes sure user input is valid
			if(pokemon[i] == null) {
				continue;
			}
			//Makes sure that the user knows the pokedex reached its limit
			if(pokemon[pokemon.length-1] != null) {
				System.out.println("Max");
				return true;
			}
			//Makes sure that the user knows that the same pokemon has already been entered
			if(pokemon[i].getSpecies().equalsIgnoreCase(species)) {
				System.out.println("Duplicate");
				return false;
			}
		}
		
		//Allows a new pokemon to be entered in the pokedex
		for(int i = 0; i< pokemon.length; i++) {
			if(pokemon[i] == null) {
				pokemon[i] = new Pokemon(species);
				return true;
			}
		}
		return true;
	}
	
	//Method for Pokedex option 3: Check a Pokemon's Stats (case 3)
	public int[] checkStats(String species) {
		//Initialized attack, defense, and speed stats
		int attack;
		int defense;
		int speed;
		
		//Creates new object for pokemon stats
		Pokemon updatedPokemonStats = new Pokemon(species);
		
		//Checks for pokemon in the pokedex and shows their complete stats
		for(int i = 0; i < pokemon.length; i++) {
			if(pokemon[i] != null && pokemon[i].getSpecies().contains(species)) {
				attack = updatedPokemonStats.getAttack();
				defense = updatedPokemonStats.getDefense();
				speed = updatedPokemonStats.getSpeed();
				
				//Stats are updated then stored into a single array
				int[] stats = {attack, defense, speed};
				return stats;
			}	
		}
		//Gives default zero stats
		int[] stats = null;
		return stats;
	}
	
	//Method for Pokedex option 4: Sort Pokemon (case 4)
	public void sortPokemon() {
		Pokemon sort;
		int pokemonSize = 0;
		
		//Makes sure that the pokemon entered are valid
		for(int i = 0; i < pokemon.length; i++) {
			if(pokemon[i] == null) {
				break;
			}
			else {
				pokemonSize++;
			}
		}
		//Loop used to define species alphabetically
		for(int i = 0; i < pokemonSize - 1; ++i) {
			int minimum = i;
			for(int j = i + 1; j < pokemonSize; j++) {
				if(pokemon[j].getSpecies().compareToIgnoreCase(pokemon[minimum].getSpecies()) < 0) {
					minimum = j;
				}
			}
			//Sorts pokemon alphabetically in the pokedex
			sort = pokemon[i];
			pokemon[i] = pokemon[minimum];
			pokemon[minimum] = sort;
		}
	}
}
