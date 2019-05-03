package xebia.main.controller;

import domain.Pivot;
import domain.Tondeuse;

/**
 * classe permettant à une tondeuse de pivoter à droite
 * @author sana
 *
 */
public class PivotDroite implements Commande {
	
	/**
	 * la tondeuse en cours
	 */
	private Tondeuse tondeuse;
	
	/**
	 * constructeur
	 * @param tondeuse
	 */
	public PivotDroite(Tondeuse tondeuse) {
		this.tondeuse = tondeuse;
	}
	
	/**
	 * lancer la commande pivoter à droite
	 */
	@Override
	public void execute() {
		tondeuse.pivoter(Pivot.D);
		
	}

}
