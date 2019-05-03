package domain;

/**
 * représente les coordonnées sur la surface
 * @author sana
 *
 */
public class Coordonnee {

	/**
	 * abcisse 
	 */
	private int x;
	
	/**
	 * ordonnee
	 */
	private int y;
	
	/**
	 * constructeur
	 * @param x
	 * @param y
	 */
	public Coordonnee(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * additionne les coordonnees
	 * @param coordonnee
	 * @return nouvelle coordonnee
	 */
	public Coordonnee add (Coordonnee coordonnee) {
		return new Coordonnee(this.x + coordonnee.getX(), this.y + coordonnee.getY());
	}
	
	/**
	 * comparer les coordonnees
	 */
	public boolean equals(Object object) {
		boolean isEqual = false;
		if (object instanceof Coordonnee) {
			Coordonnee coord = (Coordonnee)object;
			isEqual = (this.x == coord.getX()) && (this.y == coord.getY());
		}
		return isEqual;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}



}
