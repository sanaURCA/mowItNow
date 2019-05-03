package domain;

import java.util.Observable;

/**
 * La classe Tondeuse represente les tondeuses pouvant parcourir une surface.
 * 
 * Elle est caracterisee par des coordonnees et une orientation indiquant sa
 * position sur la surface.
 * 
 * La tondeuse est capable de pivoter à  gauche ou à  droite et d'avancer d'une
 * case selon son orientation.
 * 
 * @author Sana Arbi
 * 
 */
public class Tondeuse extends Observable {

	/**
	 * La position de la tondeuse sur la surface.
	 */
	private Coordonnee coordonnee;

	/**
	 * La direction de la tondeuse (N,,E,S,W)
	 */
	private Orientation orientation;

	/**
	 * Creation d'une tondeuse à  partir de sa position
	 * 
	 * @param x
	 *            abscisse initiale de la tondeuse
	 * @param y
	 *            ordonnee initiales de la tondeuse
	 * @param orientation
	 *            orientation initiale de la tondeuse
	 */
	public Tondeuse(int x, int y, Orientation orientation) {
		this.coordonnee = new Coordonnee(x, y);
		this.orientation = orientation;
	}

	/**
	 * Fait pivoter la tondeuse à  droite ou à gauche
	 * 
	 * @param pivot
	 *            le type de pivot (Droite ou Gauche)
	 */
	public void pivoter(Pivot pivot) {
		Orientation[] orientations = Orientation.values();
		int nombreOrientation = orientations.length;
		int index = (this.orientation.ordinal() + pivot.getValeurPivot() + nombreOrientation) % nombreOrientation;
		this.orientation = orientations[index];
	}

	/**
	 * Fait avance la tondeuse vers la nouvelle destination.
	 * 
	 * La surface est informee de ce changement.
	 * 
	 * @param destination
	 *            les nouvelles coordonnees de la tondeuse
	 */
	public void avance(Coordonnee destination) {
		Coordonnee origine = this.coordonnee;
		this.coordonnee = destination;
		setChanged();
		notifyObservers(origine);
	}

	/**
	 * @return les coordonnees de la tondeuse
	 */
	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	/**
	 * @return l'orientation de la tondeuse
	 */
	public Orientation getOrientation() {
		return orientation;
	}

}
