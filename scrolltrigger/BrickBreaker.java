import java.awt.*;
import java.awt.event.*;

public class BrickBreaker extends Frame implements Runnable, KeyListener {
    private Paddle paddle;
    private Ball ball;
    private Brick[][] bricks;
    private int score;
    private boolean running;
    private Button scoreButton;

    public BrickBreaker() {
        this.setTitle("Brick Breaker Game");
        this.setSize(400, 600);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.addKeyListener(this);
        this.setBackground(Color.BLACK);

        // Score button
        scoreButton = new Button("Score: 0");
        scoreButton.setEnabled(false);
        this.add(scoreButton);

        paddle = new Paddle(150, 500);
        ball = new Ball(200, 300);
        bricks = new Brick[5][8];
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                bricks[i][j] = new Brick(j * 50, i * 30);
            }
        }
        score = 0;
        running = true;

        new Thread(this).start(); // Start the game loop
    }

    public static void main(String[] args) {
        new BrickBreaker();
    }

    @Override
    public void paint(Graphics g) {
        paddle.draw(g);
        ball.draw(g);
        for (Brick[] row : bricks) {
            for (Brick brick : row) {
                if (brick != null) {
                    brick.draw(g);
                }
            }
        }
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 40);
    }

    @Override
    public void run() {
        while (running) {
            ball.move();
            checkCollisions();
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        showGameOver();
        System.exit(0);
    }

    private void checkCollisions() {
        // Paddle collision
        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.reverseY();
        }

        // Brick collisions
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                if (bricks[i][j] != null && ball.getBounds().intersects(bricks[i][j].getBounds())) {
                    bricks[i][j] = null; // Break the brick
                    ball.reverseY();
                    score++;
                    scoreButton.setLabel("Score: " + score); // Update score button
                }
            }
        }

        // Ball out of bounds
        if (ball.getY() > this.getHeight()) {
            running = false; // Stop the game loop
        }
    }

    private void showGameOver() {
        System.out.println("Game Over! Final Score: " + score);
        Dialog dialog = new Dialog(this, "Game Over", true);
        dialog.setSize(200, 100);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label("Final Score: " + score));
        Button closeButton = new Button("Close");
        closeButton.addActionListener(e -> dialog.dispose());
        dialog.add(closeButton);
        dialog.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            paddle.move(-10);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            paddle.move(10);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    class Paddle {
        private int x, y, width = 60, height = 10;

        public Paddle(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int dx) {
            x += dx;
            if (x < 0) x = 0;
            if (x > 400 - width) x = 400 - width; // Keep paddle within window
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }

        public void draw(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
        }
    }

    class Ball {
        private int x, y, diameter = 15;
        private int xSpeed = 2, ySpeed = -2;

        public Ball(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move() {
            x += xSpeed;
            y += ySpeed;

            // Bounce off walls
            if (x < 0 || x > 400 - diameter) {
                xSpeed = -xSpeed;
            }
            if (y < 0) {
                ySpeed = -ySpeed;
            }
        }

        public void reverseY() {
            ySpeed = -ySpeed;
        }

        public int getY() {
            return y;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, diameter, diameter);
        }

        public void draw(Graphics g) {
            g.setColor(Color.RED);
            g.fillOval(x, y, diameter, diameter);
        }
    }

    class Brick {
        private int x, y, width = 50, height = 20;

        public Brick(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }

        public void draw(Graphics g) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, width, height);
        }
    }
}
