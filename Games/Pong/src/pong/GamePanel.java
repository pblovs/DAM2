package pong;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GamePanel extends JPanel implements Runnable{
	
	static final int GAME_WIDTH = 1000;
	static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 20;
	static final int PADDLE_HEIGHT = 200;

	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score score;
	JButton rebootButton;
	JLabel winner;
	boolean gameStopped = false;
	int winnerID;

	
	GamePanel(){
		newPaddles();
		newBall();
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		this.setLayout(null);
		
		gameThread = new Thread(this);
		
		winner = new JLabel("PLAYER "+winnerID+" WINS");
		winner.setVisible(false);
		winner.setHorizontalAlignment(SwingConstants.CENTER);
		winner.setFont(new Font("Tahoma", Font.BOLD, 52));
		winner.setBounds((GAME_WIDTH/2)-250, (GAME_HEIGHT/2)-150, 500, 100);
		this.add(winner);
		
		rebootButton = new JButton("REBOOT");
		rebootButton.setVisible(false);
		rebootButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rebootButton.setBackground(new Color(255, 255, 255));
		rebootButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		rebootButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Score.player1 = 0;
				Score.player2 = 0;

				newPaddles();
				newBall();
				gameStopped = false;
				rebootButton.setVisible(false);
				winner.setVisible(false);
				repaint();
			}
		});
		rebootButton.setBounds((GAME_WIDTH/2)-100, (GAME_HEIGHT/2)-25, 200, 50);
		this.add(rebootButton);

		
		gameThread.start();
	}
	
	public void newBall() {
		//random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),(GAME_HEIGHT/2)-(BALL_DIAMETER/2), BALL_DIAMETER, BALL_DIAMETER);

	}
	
	public void newPaddles() {
		paddle1 = new Paddle(0, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2);
	}
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g); 

	    image = createImage(getWidth(), getHeight());
	    graphics = image.getGraphics();
	    draw(graphics);
	    g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
	}
	
	private void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
	}
	
	public void checkCollision() {
		
		//bounce ball in the top and bottom edges 
		if(ball.y <= 0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		//bounces ball off paddles
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity); //lo transforma a negativo
			ball.xVelocity++; //cada vez va mas rapido
			if(ball.yVelocity>0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		if(ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity); //lo transforma a negativo
			ball.xVelocity++; //cada vez va mas rapido
			if(ball.yVelocity>0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		//stops paddles at window edges
		if(paddle1.y <= 0) {
			paddle1.y = 0;
		}
		if(paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
			paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
		}
		if(paddle2.y <= 0) {
			paddle2.y = 0;
		}
		if(paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT)) {
			paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;
		}
		
		//give a player 1 point and creates new paddles and ball
		if (ball.x <= 0) {
			score.player2++;
			newPaddles();
			newBall();
		}
		if (ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBall();
		}
	}
	
	public void checkWin() {
	    if(Score.player1 == 10 || Score.player2 == 10) {
	        gameStopped = true;
	        rebootButton.setVisible(true);
	        if (Score.player1 == 10) {
	            winnerID = 1;
	        } else if (Score.player2 == 10){
	            winnerID = 2;
	        }
	        
	        winner.setText("PLAYER " + winnerID + " WINS");
	        winner.setVisible(true);
	    }
	}

	
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ms = 1000000000/amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now-lastTime)/ms;
			lastTime = now;
			if(delta >= 1) {
			    if(!gameStopped){  // solo mover si no está parado
			        move();
			        checkCollision();
			    }
			    checkWin();
			    repaint();
			    delta--;
			}
		}
	}

	public class AL extends KeyAdapter{
		
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);

		}

	}
}
