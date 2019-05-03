package domain;

import java.util.Observable;
import java.util.Observer;

/**
 * la pelouse rectagulaire sur laquele se déplacent les tondeuses
 */

public class Surface implements Observer {
	
	/**
	 * coordonnee du coin supérieur droit
	 */
	private Coordonnee coordCoinSupDroit;
	
	/**
	 * coordonnee du coin inférieur gauche
	 */
	private static final Coordonnee coordCoinInfGauche = new Coordonnee(0, 0);
	
	/**
	 * liste des tondeuses présentes sur la surface tondeuse [x][y]
	 */
	private Tondeuse[][] tondeuses;
	
	/**
	 * constructeur
	 * creation de la surface
	 * @param x
	 * @param y
	 * @throws IllegalArgumentException
	 *        si l'abscisse ou l'ordonnee est negative
	 */
	public Surface(int x, int y) {
		if ((x<0) || (y<0)) {
			throw new IllegalArgumentException("Abcisse ou ordonnee négative");
		}
		
		this.coordCoinSupDroit = new Coordonnee(x,y);
		this.tondeuses = new Tondeuse[x+1][y+1];
	}
	
	/**
	 * déplacer une tondeuse sur la surface à l'emplacement indiqué par les coordonnees
	 * @param tondeuse
	 * @throws IllegalArgumentException si l'emplacement est occupé
	 */
	public void deplacerTondeuse(Tondeuse tondeuse) {
		Coordonnee coordonneTondeuse = tondeuse.getCoordonnee();
		if (! isEmplacementDisponible(coordonneTondeuse)) {
			throw new IllegalArgumentException("Emplacement impossible");
		}
		int x = coordonneTondeuse.getX();
		int y = coordonneTondeuse.getY();
		tondeuses[x][y] = tondeuse;
		tondeuse.addObserver(this);
	}
	/**
	 * verifier si un emplacement est libre et doit être à l'intérieur de la surface
	 * @param coordonneTondeuse
	 * @return
	 */
	public boolean isEmplacementDisponible(Coordonnee coordonneTondeuse) {
		boolean isDisponible;
		int x = coordonneTondeuse.getX();
		int y = coordonneTondeuse.getY();
		isDisponible = (isInterieur(coordonneTondeuse) && tondeuses[x][y] == null);
		return isDisponible;
	}
	
	/**
	 * vérifier si les coordonnees sont à l'intérieur de la surface
	 * @param coordonneTondeuse
	 * @return
	 */
	private boolean isInterieur(Coordonnee coordonneTondeuse) {
		int x = coordonneTondeuse.getX();
		int y = coordonneTondeuse.getY();
		boolean abcisseValide = (x >= coordCoinInfGauche.getX()) && (x <= coordCoinSupDroit.getX());
		boolean ordonneeValide = (y >= coordCoinInfGauche.getY()) && (y <= coordCoinSupDroit.getY());
		return abcisseValide && ordonneeValide;
	}
	
	/**
	 * permet de mettre à jour les coordonnees de la tondeuse lorsqu'elle se déplace sur la surface
	 * cette méthode appartient à l'interface java.util.Observer
	 */
	public void update(Observable observable, Object arg) {
		Coordonnee origine = (Coordonnee) arg;
		Tondeuse tondeuse = (Tondeuse) observable;
		tondeuses[origine.getX()][origine.getY()] = null;
		tondeuses[tondeuse.getCoordonnee().getX()][tondeuse.getCoordonnee().getY()] = tondeuse;
	}

}
