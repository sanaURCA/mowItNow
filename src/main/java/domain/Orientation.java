package domain;

/**
 * liste des orientations
 * chaque orientation est défini par une coordonnee qui représente la direction
 * @author sana
 *
 */
public enum Orientation {

	
	
	/**
	 * Nord
	 */
	N(new Coordonnee(0,1)),
	
	/**
	 * Est
	 */
	E(new Coordonnee(1,0)),
	
	/**
	 * Sud
	 */
	S(new Coordonnee(0, -1)),
	
	/**
	 * West
	 */
	W(new Coordonnee(-1,0));
	
	
	private Coordonnee direction;
	
	/**
	 * constructeur
	 * @param direction
	 */
	private Orientation (Coordonnee direction) {
		this.direction = direction;
	}
	
	/**
	 * retourne la direction
	 * @return
	 */
	public Coordonnee getDirection() {
		return direction;
	}
	
}
