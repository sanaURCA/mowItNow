package xebia.main;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import domain.Orientation;
import domain.Surface;
import domain.Tondeuse;
import xebia.main.controller.Avancer;
import xebia.main.controller.Controller;
import xebia.main.controller.PivotDroite;
import xebia.main.controller.PivoterGauche;

/**
 * Unit test for simple App.
 */
public class TondeuseTest {
	
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp()
    {
    	Controller controlleur = new Controller();
    	Surface surface = new Surface(5, 5);
    	
    	Tondeuse tondeuse1 = new Tondeuse(1, 2, Orientation.N);
    	surface.deplacerTondeuse(tondeuse1);
    	
    	//Instructions
    	
    	PivoterGauche pivoterGauche1 = new PivoterGauche(tondeuse1);
		Avancer avancer = new Avancer(surface, tondeuse1);
		controlleur.execute(pivoterGauche1);
		controlleur.execute(avancer);
		controlleur.execute(pivoterGauche1);
		controlleur.execute(avancer);
		controlleur.execute(pivoterGauche1);
		controlleur.execute(avancer);
		controlleur.execute(pivoterGauche1);
		controlleur.execute(avancer);
		controlleur.execute(avancer);
		assertEquals(1, tondeuse1.getCoordonnee().getX());
		assertEquals(3, tondeuse1.getCoordonnee().getY());
		assertEquals(Orientation.N, tondeuse1.getOrientation());
    	
    	Tondeuse tondeuse2 = new Tondeuse(3, 3, Orientation.E);
		surface.deplacerTondeuse(tondeuse2);

		// Instructions
		PivotDroite pivoterDroite2 = new PivotDroite(tondeuse2);
		Avancer avancer2 = new Avancer(surface, tondeuse2);
		controlleur.execute(avancer2);
		controlleur.execute(avancer2);
		controlleur.execute(pivoterDroite2);
		controlleur.execute(avancer2);
		controlleur.execute(avancer2);
		controlleur.execute(pivoterDroite2);
		controlleur.execute(avancer2);
		controlleur.execute(pivoterDroite2);
		controlleur.execute(pivoterDroite2);
		controlleur.execute(avancer2);
		assertEquals(5, tondeuse2.getCoordonnee().getX());
		assertEquals(1, tondeuse2.getCoordonnee().getY());
		assertEquals(Orientation.E, tondeuse2.getOrientation());
		
		System.out.println(tondeuse2.getOrientation());
		System.out.println(tondeuse2.getCoordonnee().getX());
		System.out.println(tondeuse2.getCoordonnee().getY());

    }
}
