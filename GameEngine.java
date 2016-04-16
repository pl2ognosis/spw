

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;

public class GameEngine implements KeyListener,GameReporter{
	GamePanel gp;




	private Timer timer;
	private Long score = 0;
	private double difficulty = 0.1;

	public GameEngine(GamePanel gp,SpaceShip v){
		this.gp = gp;
		this.v = v;

		gp.sprites.add(v);

		timer = new Timer(50,new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0){
				process();
			}


		});
		timer.setRepeats(true);
	}

	public void start(){
		timer.start();

	}

	public void die(){
		timer.stop();
	}
}