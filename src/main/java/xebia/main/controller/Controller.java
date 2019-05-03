package xebia.main.controller;

/**
 * envoyer une commande à la tondeuse
 * @author sana
 *
 */
public class Controller {

	/**
	 * lancer une commande 
	 * @param commande
	 */
	public void execute(Commande commande) {
		
		commande.execute();
	}
}
