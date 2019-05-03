package xebia.main.controller;

import domain.Coordonnee;
import domain.Surface;
import domain.Tondeuse;

/**
 * action "avancer" permet à la tondeuse d'avancer d'une case 
 * si le mouvement est impossible, la tondeuse reste dans sa place.
 * @author sana
 *
 */
public class Avancer implements Commande {
	
	/**
	 * tendeuse 
	 */
	private Tondeuse tondeuse; 
	
	/**
	 * surface
	 */
	private Surface surface;
	
	/**
	 * constructeur
	 * 
	 * @param surface
	 * @param tondeuse
	 */
	public Avancer(Surface surface, Tondeuse tondeuse) {
		this.tondeuse = tondeuse;
		this.surface = surface;
	}

	/**
	 * faire avancer la tondeuse d'une case
	 */
	public void execute() {
		Coordonnee source = tondeuse.getCoordonnee();
		Coordonnee directionSuivante = tondeuse.getOrientation().getDirection();
		Coordonnee destination = source.add(directionSuivante);
		if (surface.isEmplacementDisponible(destination)) {
			tondeuse.avance(destination);
		}	
	}	
}
