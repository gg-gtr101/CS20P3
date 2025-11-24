package JavaGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * SpaceShooter
 * A classic arcade-style 2D shooter game contained in a single file.
 * * Instructions:
 * 1. Compile: javac SpaceShooter.java
 * 2. Run: java SpaceShooter
 * * Controls:
 * - Left/Right Arrow Keys: Move Ship
 * - Spacebar: Shoot
 * - R: Restart Game (when Game Over)
 */
public class SpaceShooter extends JPanel implements ActionListener, KeyListener {

    // --- Cheat Settings Class ---
    static class CheatSettings {
        int bulletSpeed = 10;
        int playerSpeed = 8;
        int enemySpeed = 3;
        boolean startShield = false;
        boolean startTriple = false;
        boolean startRapid = false;
        boolean startPet = false; 
        boolean infinitePowerups = false;
    }

    // --- Game Settings ---
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int DELAY = 15; // Game loop delay (approx 60 FPS)
    
    // --- Player Settings ---
    private Rectangle player;
    private final int PLAYER_WIDTH = 50;
    private final int PLAYER_HEIGHT = 30;
    private int playerSpeed = 8; 
    private boolean moveLeft = false;
    private boolean moveRight = false;
    private boolean isShooting = false; 

    // --- Pet Settings ---
    private boolean petActive = false;
    private Rectangle pet;
    private int petShootTimer = 0;
    private final int PET_FIRE_RATE = 10; // VERY FAST (approx 6 shots/sec)

    // --- Game Objects ---
    private ArrayList<Rectangle> bullets;
    private ArrayList<Rectangle> enemies;
    private final int BULLET_WIDTH = 5;
    private final int BULLET_HEIGHT = 10;
    private int bulletSpeed = 10; 
    
    private int shootTimer = 0; 
    private int currentShootDelay = 8; 
    private final int NORMAL_SHOOT_DELAY = 8;
    private final int RAPID_SHOOT_DELAY = 3;
    
    private final int ENEMY_WIDTH = 40;
    private final int ENEMY_HEIGHT = 40;
    private int baseEnemySpeed = 3; 
    
    // --- Boss Settings ---
    private Rectangle boss;
    private boolean bossActive = false;
    private int bossHealth = 0;
    private final int BOSS_MAX_HEALTH = 50;
    private final int BOSS_WIDTH = 100;
    private final int BOSS_HEIGHT = 60;
    private int bossSpeed = 4;
    private int bossDirection = 1; 
    private ArrayList<Rectangle> bossBullets;
    private int nextBossScore = 2000; 
    
    // --- Power-Up Settings ---
    private ArrayList<PowerUp> powerUps;
    private CheatSettings settings; 
    
    private int shieldTimer = 0;
    private int rapidFireTimer = 0;
    private int tripleShotTimer = 0;
    private int freezeTimer = 0;
    private final int POWERUP_DURATION = 300; 
    
    class PowerUp extends Rectangle {
        int type; 
        Color color;
        String symbol;

        public PowerUp(int x, int y, int type) {
            super(x, y, 25, 25);
            this.type = type;
            switch(type) {
                case 1: color = Color.BLUE; symbol = "R"; break; // Rapid
                case 2: color = Color.WHITE; symbol = "S"; break; // Shield
                case 3: color = Color.GREEN; symbol = "T"; break; // Triple
                case 4: color = Color.CYAN; symbol = "Z"; break; // Freeze
                case 5: color = Color.ORANGE; symbol = "N"; break; // Nuke
                case 6: color = Color.MAGENTA; symbol = "P"; break; // Pet
            }
        }
    }

    // New Class for Pet's Aimed Bullets
    class AimedBullet extends Rectangle {
        double accurateX, accurateY;
        double dx, dy;

        public AimedBullet(int x, int y, int w, int h, double dx, double dy) {
            super(x, y, w, h);
            this.accurateX = x;
            this.accurateY = y;
            this.dx = dx;
            this.dy = dy;
        }

        public void move() {
            accurateX += dx;
            accurateY += dy;
            this.x = (int) accurateX;
            this.y = (int) accurateY;
        }
    }

    // --- Game State ---
    private Timer timer;
    private int score = 0;
    private boolean gameOver = false;
    private Random random;
    private int spawnCounter = 0; 

    public SpaceShooter(CheatSettings settings) {
        this.settings = settings;
        
        // Apply Speed Settings
        this.playerSpeed = settings.playerSpeed;
        this.bulletSpeed = settings.bulletSpeed;
        this.baseEnemySpeed = settings.enemySpeed;

        // Initialize window settings
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        // Initialize game objects
        player = new Rectangle(WIDTH / 2 - PLAYER_WIDTH / 2, HEIGHT - 100, PLAYER_WIDTH, PLAYER_HEIGHT);
        pet = new Rectangle(0, 0, 20, 20); // Init pet placeholder
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        bossBullets = new ArrayList<>();
        powerUps = new ArrayList<>();
        random = new Random();

        // Apply Start Powerups
        applyCheatPowerups();

        // Start game loop
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void applyCheatPowerups() {
        int duration = settings.infinitePowerups ? 999999 : POWERUP_DURATION;
        
        if (settings.startShield) shieldTimer = duration;
        if (settings.startRapid) rapidFireTimer = duration;
        if (settings.startTriple) tripleShotTimer = duration;
        if (settings.startPet) petActive = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (gameOver) {
            drawGameOver(g2d);
        } else {
            // Draw Player
            g2d.setColor(Color.CYAN);
            int[] xPoints = {player.x, player.x + player.width / 2, player.x + player.width};
            int[] yPoints = {player.y + player.height, player.y, player.y + player.height};
            g2d.fillPolygon(xPoints, yPoints, 3);
            
            // Draw Shield Visual
            if (shieldTimer > 0) {
                g2d.setColor(new Color(255, 255, 255, 100)); 
                g2d.drawOval(player.x - 10, player.y - 10, player.width + 20, player.height + 20);
                g2d.setColor(new Color(255, 255, 255, 50)); 
                g2d.fillOval(player.x - 10, player.y - 10, player.width + 20, player.height + 20);
            }
            
            // Draw Pet Visual
            if (petActive) {
                g2d.setColor(Color.MAGENTA);
                g2d.fillRect(pet.x, pet.y, pet.width, pet.height);
                // Draw little eye on pet
                g2d.setColor(Color.WHITE);
                g2d.fillRect(pet.x + 5, pet.y + 5, 10, 5);
            }

            // Draw engine flame
            g2d.setColor(Color.ORANGE);
            g2d.fillRect(player.x + 15, player.y + player.height, 20, 10);

            // Draw Bullets
            for (Rectangle bullet : bullets) {
                if (bullet instanceof AimedBullet) {
                    g2d.setColor(Color.MAGENTA); // Pet bullets
                } else {
                    g2d.setColor(Color.YELLOW); // Player bullets
                }
                g2d.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
            }

            // Draw PowerUps
            for (PowerUp p : powerUps) {
                g2d.setColor(p.color);
                g2d.fillRect(p.x, p.y, p.width, p.height);
                g2d.setColor(Color.WHITE);
                g2d.drawRect(p.x, p.y, p.width, p.height);
                g2d.setFont(new Font("Arial", Font.BOLD, 12));
                g2d.drawString(p.symbol, p.x + 8, p.y + 17);
            }

            // Draw Boss (if active)
            if (bossActive) {
                g2d.setColor(Color.MAGENTA);
                g2d.fillRect(boss.x, boss.y, boss.width, boss.height);
                g2d.setColor(Color.DARK_GRAY);
                g2d.fillRect(boss.x + 10, boss.y + 10, boss.width - 20, boss.height - 20); 
                
                g2d.setColor(Color.RED);
                g2d.fillRect(boss.x, boss.y - 15, boss.width, 5);
                g2d.setColor(Color.GREEN);
                int hpWidth = (int)((double)bossHealth / BOSS_MAX_HEALTH * boss.width);
                g2d.fillRect(boss.x, boss.y - 15, hpWidth, 5);
                
                g2d.setColor(Color.RED);
                for (Rectangle b : bossBullets) {
                    g2d.fillRect(b.x, b.y, b.width, b.height);
                }
            } else {
                g2d.setColor(freezeTimer > 0 ? Color.CYAN : Color.RED); 
                for (Rectangle enemy : enemies) {
                    g2d.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(enemy.x + 10, enemy.y + 10, 5, 5);
                    g2d.fillRect(enemy.x + 25, enemy.y + 10, 5, 5);
                    g2d.setColor(freezeTimer > 0 ? Color.CYAN : Color.RED); 
                }
            }

            // Draw Score and UI
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 18));
            g2d.drawString("Score: " + score, 10, 20);
            if (bossActive) {
                g2d.setColor(Color.RED);
                g2d.drawString("BOSS FIGHT!", WIDTH / 2 - 50, 30);
            } else {
                g2d.drawString("Next Boss: " + nextBossScore, 10, 40);
            }

            // Draw Active Powerups UI
            int uiY = 20;
            g2d.setColor(Color.WHITE);
            String suffix = settings.infinitePowerups ? " (INF)" : "";
            if (shieldTimer > 0) { g2d.drawString("SHIELD: " + (settings.infinitePowerups ? "ON" : shieldTimer/20) + suffix, WIDTH - 200, uiY); uiY += 20; }
            if (rapidFireTimer > 0) { g2d.drawString("RAPID: " + (settings.infinitePowerups ? "ON" : rapidFireTimer/20) + suffix, WIDTH - 200, uiY); uiY += 20; }
            if (tripleShotTimer > 0) { g2d.drawString("TRIPLE: " + (settings.infinitePowerups ? "ON" : tripleShotTimer/20) + suffix, WIDTH - 200, uiY); uiY += 20; }
            if (freezeTimer > 0) { g2d.drawString("FREEZE: " + freezeTimer/20, WIDTH - 200, uiY); uiY += 20; }
            if (petActive) { g2d.drawString("GOD PET ACTIVE", WIDTH - 200, uiY); uiY += 20; }
        }
        
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawGameOver(Graphics2D g2d) {
        String msg = "Game Over";
        String scoreMsg = "Final Score: " + score;
        String restartMsg = "Press 'R' to Restart";
        
        Font font = new Font("Helvetica", Font.BOLD, 50);
        Font smallFont = new Font("Helvetica", Font.BOLD, 20);
        FontMetrics fm = getFontMetrics(font);
        
        g2d.setColor(Color.RED);
        g2d.setFont(font);
        g2d.drawString(msg, (WIDTH - fm.stringWidth(msg)) / 2, HEIGHT / 2 - 50);
        
        g2d.setColor(Color.WHITE);
        g2d.setFont(smallFont);
        fm = getFontMetrics(smallFont);
        g2d.drawString(scoreMsg, (WIDTH - fm.stringWidth(scoreMsg)) / 2, HEIGHT / 2 + 10);
        g2d.drawString(restartMsg, (WIDTH - fm.stringWidth(restartMsg)) / 2, HEIGHT / 2 + 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            updatePlayer();
            if (petActive) updatePet(); // Pet update
            updatePowerUpTimers();
            updateShooting(); 
            updateBullets();
            updatePowerUps();
            
            if (bossActive) {
                updateBoss();
            } else {
                updateEnemies();
                if (score >= nextBossScore) {
                    spawnBoss();
                }
            }
            
            checkCollisions();
        }
        
        repaint();
    }

    private void updatePlayer() {
        if (moveLeft && player.x > 0) {
            player.x -= playerSpeed;
        }
        if (moveRight && player.x < WIDTH - player.width) {
            player.x += playerSpeed;
        }
    }

    private void updatePet() {
        // Pet follows player loosely
        pet.x = player.x - 30;
        pet.y = player.y + 5;

        // Pet shooting logic
        petShootTimer++;
        if (petShootTimer >= PET_FIRE_RATE) {
            // Find closest target (Aimbot Logic)
            Rectangle target = null;
            
            if (bossActive) {
                target = boss;
            } else if (!enemies.isEmpty()) {
                // Find closest enemy
                double minDist = Double.MAX_VALUE;
                for (Rectangle e : enemies) {
                    double dist = Math.hypot(e.x - pet.x, e.y - pet.y);
                    if (dist < minDist) {
                        minDist = dist;
                        target = e;
                    }
                }
            }

            // Shoot at target if found
            if (target != null) {
                double angle = Math.atan2((target.y + target.height/2.0) - (pet.y + pet.height/2.0), 
                                          (target.x + target.width/2.0) - (pet.x + pet.width/2.0));
                double speed = 15; // Fast projectile
                double dx = Math.cos(angle) * speed;
                double dy = Math.sin(angle) * speed;
                
                bullets.add(new AimedBullet(pet.x + pet.width/2, pet.y, 8, 8, dx, dy));
                petShootTimer = 0;
            }
        }
    }

    private void updatePowerUpTimers() {
        if (settings.infinitePowerups) {
             currentShootDelay = (rapidFireTimer > 0) ? RAPID_SHOOT_DELAY : NORMAL_SHOOT_DELAY;
             return;
        }

        if (shieldTimer > 0) shieldTimer--;
        if (rapidFireTimer > 0) {
            rapidFireTimer--;
            currentShootDelay = RAPID_SHOOT_DELAY;
        } else {
            currentShootDelay = NORMAL_SHOOT_DELAY;
        }
        if (tripleShotTimer > 0) tripleShotTimer--;
        if (freezeTimer > 0) freezeTimer--;
    }

    private void updatePowerUps() {
        ArrayList<PowerUp> removeList = new ArrayList<>();
        for (PowerUp p : powerUps) {
            p.y += 3; 
            if (p.y > HEIGHT) removeList.add(p);
        }
        powerUps.removeAll(removeList);
    }

    private void updateShooting() {
        if (shootTimer > 0) {
            shootTimer--;
        }
        if (isShooting && shootTimer <= 0) {
            bullets.add(new Rectangle(player.x + player.width / 2 - BULLET_WIDTH / 2, player.y, BULLET_WIDTH, BULLET_HEIGHT));
            
            if (tripleShotTimer > 0) {
                bullets.add(new Rectangle(player.x, player.y + 10, BULLET_WIDTH, BULLET_HEIGHT)); 
                bullets.add(new Rectangle(player.x + player.width - BULLET_WIDTH, player.y + 10, BULLET_WIDTH, BULLET_HEIGHT)); 
            }
            
            shootTimer = currentShootDelay; 
        }
    }

    private void updateBullets() {
        ArrayList<Rectangle> bulletsToRemove = new ArrayList<>();
        for (Rectangle bullet : bullets) {
            if (bullet instanceof AimedBullet) {
                // Move smart bullet
                ((AimedBullet) bullet).move();
                // Remove if off screen (checking all borders)
                if (bullet.y < 0 || bullet.y > HEIGHT || bullet.x < 0 || bullet.x > WIDTH) {
                    bulletsToRemove.add(bullet);
                }
            } else {
                // Standard player bullet move
                bullet.y -= bulletSpeed;
                if (bullet.y < 0) {
                    bulletsToRemove.add(bullet);
                }
            }
        }
        bullets.removeAll(bulletsToRemove);
    }

    private void spawnBoss() {
        bossActive = true;
        bossHealth = BOSS_MAX_HEALTH;
        boss = new Rectangle(WIDTH / 2 - BOSS_WIDTH / 2, 50, BOSS_WIDTH, BOSS_HEIGHT);
        enemies.clear(); 
        bossBullets.clear();
        powerUps.clear(); 
    }

    private void updateBoss() {
        boss.x += bossSpeed * bossDirection;
        if (boss.x <= 0 || boss.x + boss.width >= WIDTH) {
            bossDirection *= -1; 
        }

        if (random.nextInt(30) == 0) { 
            bossBullets.add(new Rectangle(boss.x + boss.width / 2 - 5, boss.y + boss.height, 10, 20));
        }

        ArrayList<Rectangle> bulletsToRemove = new ArrayList<>();
        for (Rectangle b : bossBullets) {
            b.y += 7; 
            if (b.y > HEIGHT) {
                bulletsToRemove.add(b);
            }
        }
        bossBullets.removeAll(bulletsToRemove);
    }

    private void updateEnemies() {
        // 1. Spawn Logic
        spawnCounter++;
        int spawnRate = 40 - (score / 200); 
        if (spawnRate < 10) spawnRate = 10; 

        if (spawnCounter > spawnRate) {
            int x = random.nextInt(WIDTH - ENEMY_WIDTH);
            enemies.add(new Rectangle(x, 0, ENEMY_WIDTH, ENEMY_HEIGHT));
            spawnCounter = 0;
        }

        // 2. Freeze Check (Skip movement)
        if (freezeTimer > 0) return;

        // 3. Movement Logic (Only if not frozen)
        Iterator<Rectangle> it = enemies.iterator();
        while (it.hasNext()) {
            Rectangle enemy = it.next();
            enemy.y += baseEnemySpeed + (score / 1000); 
            
            if (enemy.y > HEIGHT) {
                gameOver = true; 
            }
        }
    }

    private void checkCollisions() {
        Iterator<PowerUp> powerIt = powerUps.iterator();
        while (powerIt.hasNext()) {
            PowerUp p = powerIt.next();
            if (p.intersects(player)) {
                activatePowerUp(p.type);
                powerIt.remove();
            }
        }

        if (bossActive) {
            Iterator<Rectangle> bulletIt = bullets.iterator();
            while (bulletIt.hasNext()) {
                Rectangle bullet = bulletIt.next();
                if (boss.intersects(bullet)) {
                    bossHealth--;
                    bulletIt.remove();
                    if (bossHealth <= 0) {
                        bossActive = false;
                        score += 1000; 
                        nextBossScore += 2000; 
                        bossBullets.clear();
                        powerUps.add(new PowerUp(boss.x + boss.width/2, boss.y, random.nextInt(6) + 1)); 
                    }
                    break;
                }
            }

            for (Rectangle b : bossBullets) {
                if (b.intersects(player)) {
                    if (shieldTimer <= 0) {
                        gameOver = true;
                    }
                }
            }

            if (boss.intersects(player)) {
                if (shieldTimer <= 0) {
                    gameOver = true;
                }
            }

        } else {
            Iterator<Rectangle> enemyIt = enemies.iterator();
            while (enemyIt.hasNext()) {
                Rectangle enemy = enemyIt.next();
                
                if (enemy.intersects(player)) {
                    if (shieldTimer <= 0) {
                        gameOver = true;
                    } else {
                        enemyIt.remove();
                        score += 100;
                        continue;
                    }
                }

                Iterator<Rectangle> bulletIt = bullets.iterator();
                while (bulletIt.hasNext()) {
                    Rectangle bullet = bulletIt.next();
                    if (enemy.intersects(bullet)) {
                        score += 100;
                        
                        // Chance to spawn PowerUp (10%)
                        if (random.nextInt(100) < 10) {
                            int type = random.nextInt(5) + 1; 
                            if (random.nextInt(5) == 0) type = 6;
                            powerUps.add(new PowerUp(enemy.x, enemy.y, type));
                        }

                        bulletIt.remove();
                        enemyIt.remove();
                        break; 
                    }
                }
            }
        }
    }

    private void activatePowerUp(int type) {
        int duration = settings.infinitePowerups ? 999999 : POWERUP_DURATION;
        switch(type) {
            case 1: rapidFireTimer = duration; break;
            case 2: shieldTimer = duration; break;
            case 3: tripleShotTimer = duration; break;
            case 4: freezeTimer = 240; break; 
            case 5: enemies.clear(); score += 500; break; 
            case 6: petActive = true; break; 
        }
    }

    private void restartGame() {
        player.x = WIDTH / 2 - PLAYER_WIDTH / 2;
        player.y = HEIGHT - 100;
        enemies.clear();
        bullets.clear();
        bossBullets.clear();
        powerUps.clear();
        score = 0;
        gameOver = false;
        moveLeft = false;
        moveRight = false;
        isShooting = false;
        shootTimer = 0;
        
        // Reset Powerups but Apply Cheats Again
        shieldTimer = 0;
        rapidFireTimer = 0;
        tripleShotTimer = 0;
        freezeTimer = 0;
        petActive = false;
        applyCheatPowerups();
        
        bossActive = false;
        nextBossScore = 2000;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) moveLeft = true;
        if (key == KeyEvent.VK_RIGHT) moveRight = true;
        if (key == KeyEvent.VK_SPACE && !gameOver) isShooting = true;
        if (key == KeyEvent.VK_R && gameOver) restartGame();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) moveLeft = false;
        if (key == KeyEvent.VK_RIGHT) moveRight = false;
        if (key == KeyEvent.VK_SPACE) isShooting = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    // --- Main Method with Cheat Menu ---
    public static void main(String[] args) {
        CheatSettings settings = new CheatSettings();
        
        // Create Cheat UI
        JDialog cheatDialog = new JDialog((Frame)null, "Cheat Menu & Settings", true);
        cheatDialog.setLayout(new GridLayout(0, 2, 10, 10));
        
        // Sliders
        JSlider bulletSlider = new JSlider(5, 50, 10);
        bulletSlider.setMajorTickSpacing(10);
        bulletSlider.setPaintTicks(true);
        cheatDialog.add(new JLabel("Bullet Speed (Default 10):"));
        cheatDialog.add(bulletSlider);

        JSlider playerSlider = new JSlider(5, 30, 8);
        playerSlider.setMajorTickSpacing(5);
        playerSlider.setPaintTicks(true);
        cheatDialog.add(new JLabel("Player Speed (Default 8):"));
        cheatDialog.add(playerSlider);

        JSlider enemySlider = new JSlider(1, 10, 3);
        enemySlider.setMajorTickSpacing(1);
        enemySlider.setPaintTicks(true);
        cheatDialog.add(new JLabel("Enemy Speed (Default 3):"));
        cheatDialog.add(enemySlider);

        // Checkboxes
        JCheckBox shieldCheck = new JCheckBox("Start with Shield");
        cheatDialog.add(shieldCheck);
        cheatDialog.add(new JLabel("")); 

        JCheckBox rapidCheck = new JCheckBox("Start with Rapid Fire");
        cheatDialog.add(rapidCheck);
        cheatDialog.add(new JLabel(""));

        JCheckBox tripleCheck = new JCheckBox("Start with Triple Shot");
        cheatDialog.add(tripleCheck);
        cheatDialog.add(new JLabel(""));

        JCheckBox petCheck = new JCheckBox("Start with Pet Helper");
        cheatDialog.add(petCheck);
        cheatDialog.add(new JLabel(""));

        JCheckBox infiniteCheck = new JCheckBox("Infinite Power-up Duration (God Mode)");
        cheatDialog.add(infiniteCheck);
        cheatDialog.add(new JLabel(""));

        // Start Button
        JButton startButton = new JButton("START GAME");
        startButton.setBackground(Color.GREEN);
        startButton.setFont(new Font("Arial", Font.BOLD, 20));
        cheatDialog.add(startButton);
        
        startButton.addActionListener(e -> {
            settings.bulletSpeed = bulletSlider.getValue();
            settings.playerSpeed = playerSlider.getValue();
            settings.enemySpeed = enemySlider.getValue();
            settings.startShield = shieldCheck.isSelected();
            settings.startRapid = rapidCheck.isSelected();
            settings.startTriple = tripleCheck.isSelected();
            settings.startPet = petCheck.isSelected();
            settings.infinitePowerups = infiniteCheck.isSelected();
            cheatDialog.dispose();
        });

        cheatDialog.pack();
        cheatDialog.setLocationRelativeTo(null);
        cheatDialog.setVisible(true);

        // Launch Game
        JFrame frame = new JFrame("Java Space Shooter - Ultimate Edition");
        SpaceShooter game = new SpaceShooter(settings);
        
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}