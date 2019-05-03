package xebia.main.controller;

import domain.Pivot;
import domain.Tondeuse;

/**
 * classe permettant à une tondeuse de pivoter à gauche
 * @author sana
 *
 */
public class PivoterGauche implements Commande {
	
	/**
	 * tondeuse en cours
	 */
	private Tondeuse tondeuse;
	
	/**
	 * constructeur
	 * @param tondeuse
	 */
	public PivoterGauche(Tondeuse tondeuse) {
		this.tondeuse = tondeuse;
	}
	
	/**
	 * lancer la commader execute
	 */
	public void execute() {
		tondeuse.pivoter(Pivot.G);
		
	}

}
