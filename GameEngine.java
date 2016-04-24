

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

	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private SpaceShip v;


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

	public void generateEnemy(){
		Enemy e = new Enemy((int)(Math.random()*390),30);
		gp.sprites.add(e);
		enemies.add(e);
	}


	public void die(){
		timer.stop();
	}

	void controlVehicle(KeyEvent e){
		switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				v.move(-1);
				break;
			case KeyEvent.VK_RIGHT:
				v.move(1);
				break;
			case KeyEvent.VK_D:
				difficulty +=0.1;
				break;
		}
	}

	@Override
	public void KeyPressed(KeyEvent e){
		controlVehicle(e);
	}

	@Override
	public void KeyReleased(KeyEvent e){

	}

	@Override
	public void KeyTyped(KeyEvent e){
		
	}



		}
	}
}