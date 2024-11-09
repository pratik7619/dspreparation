package datastructures.dsaproblems;

import java.util.*;

public class SnakeGame {
    private final int width;
    private final int height;
    private final int[][] grid;
    private final List<int[]> snake;
    private int[] apple;
    private String direction;
    private boolean gameOver;

    public SnakeGame(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new int[height][width];
        this.snake = new LinkedList<>();
        this.direction = "RIGHT";
        this.gameOver = false;

        // Initialize snake at the center
        int[] start = {height / 2, width / 2};
        snake.add(start);
        grid[start[0]][start[1]] = 1;

        // Place the first apple
        placeApple();
    }

    public void changeDirection(String newDirection) {
        if (!gameOver) {
            // Prevent the snake from reversing on itself
            if ((newDirection.equals("UP") && !direction.equals("DOWN")) ||
                    (newDirection.equals("DOWN") && !direction.equals("UP")) ||
                    (newDirection.equals("LEFT") && !direction.equals("RIGHT")) ||
                    (newDirection.equals("RIGHT") && !direction.equals("LEFT"))) {
                direction = newDirection;
            }
        }
    }

    public void move() {
        if (gameOver) return;

        // Get the current head position
        int[] head = snake.get(0);
        int newRow = head[0];
        int newCol = head[1];

        // Determine the new head position based on the current direction
        switch (direction) {
            case "UP": newRow--; break;
            case "DOWN": newRow++; break;
            case "LEFT": newCol--; break;
            case "RIGHT": newCol++; break;
        }

        // Check for collisions with walls
        if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
            gameOver = true;
            return;
        }

        // Check for collisions with itself
        for (int[] segment : snake) {
            if (segment[0] == newRow && segment[1] == newCol) {
                gameOver = true;
                return;
            }
        }

        // Move the snake by adding the new head position
        snake.add(0, new int[] {newRow, newCol});

        // Check if the snake has eaten the apple
        if (newRow == apple[0] && newCol == apple[1]) {
            placeApple(); // Place a new apple
        } else {
            // Remove the tail segment if the apple wasn't eaten
            int[] tail = snake.remove(snake.size() - 1);
            grid[tail[0]][tail[1]] = 0;
        }

        // Update grid with the new head position
        grid[newRow][newCol] = 1;
    }

    private void placeApple() {
        Random random = new Random();
        int row, col;

        // Ensure the apple does not appear on the snake
        do {
            row = random.nextInt(height);
            col = random.nextInt(width);
        } while (grid[row][col] == 1);

        apple = new int[] {row, col};
        grid[row][col] = 2; // 2 represents the apple
    }

    public void printBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    System.out.print("S "); // Snake
                } else if (grid[i][j] == 2) {
                    System.out.print("A "); // Apple
                } else {
                    System.out.print(". "); // Empty space
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(10, 10);
        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()) {
            game.printBoard();
            System.out.print("Enter direction (WASD): ");
            String input = scanner.nextLine().toUpperCase();
            switch (input) {
                case "W": game.changeDirection("UP"); break;
                case "S": game.changeDirection("DOWN"); break;
                case "A": game.changeDirection("LEFT"); break;
                case "D": game.changeDirection("RIGHT"); break;
            }
            game.move();
        }
        System.out.println("Game Over!");
    }
}

/**
 * Here’s a basic implementation of the Snake game using arrays in Java. This version is text-based and can be played in the console. The SnakeGame class below manages the grid, snake movement, and apple placement.
 *
 * Snake Game Using Arrays in Java
 * In this game:
 *
 * A 2D array represents the grid.
 * The snake's body is stored as a list of coordinates.
 * Each turn, the snake can move up, down, left, or right.
 * If the snake collides with the walls or itself, the game is over.
 *
 * Explanation
 * Initialization:
 *
 * The snake starts at the center of the grid.
 * An apple is randomly placed on the board, ensuring it doesn’t overlap with the snake.
 * Direction Change:
 *
 * The changeDirection method prevents the snake from reversing on itself by only allowing direction changes that don’t immediately oppose the current direction.
 * Snake Movement:
 *
 * The move method updates the snake’s position by adding a new head in the specified direction.
 * If the new head position matches the apple’s position, the snake grows, and a new apple is placed.
 * If it doesn’t eat an apple, the tail is removed to simulate movement.
 * Collision Detection:
 *
 * Checks if the snake hits the walls or itself. If it does, the game ends.
 * Display:
 *
 * The printBoard method displays the current board state in the console.
 * Game Loop:
 *
 * The main loop prompts the player for input to change the snake’s direction (W, A, S, D) and updates the snake's position each turn.
 * The game continues until the snake collides with a wall or itself.
 *
 * Enter direction (WASD): D
 * . . . . . . . . . .
 * . . . . . . . . . .
 * . . . . . . . . . .
 * . . . . . . . . . .
 * . . . . . . . . . .
 * . . . . S A . . . .
 * . . . . . . . . . .
 * . . . . . . . . . .
 * . . . . . . . . . .
 * . . . . . . . . . .
 *
 * Game Over!
 *
 * This implementation is a simple text-based version that gives a feel of the classic snake game mechanics. It could be further expanded to include graphical displays and smoother continuous movement.
 * */

