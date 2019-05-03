package domain;
/**
 * liste des pivots possible droit ou gauche
 * @author sana
 *
 */
public enum Pivot {

	/**
	 * droite
	 */
	D(1),
	
	/**
	 * gauche
	 */
	G(-1);
	
	/**
	 * cette valeur permet de déterminer l'orientation
	 */
	private int valeurPivot;
	
	/**
	 * constructeur
	 * @param val
	 */
	private Pivot (int val) {
		this.valeurPivot = val;
	}
	
	/**
	 * retourne la valeur de pivot
	 * @return
	 */
	public int getValeurPivot() {
		return valeurPivot;
	}
	
	
}
