package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 353. Design Snake Game<br>
 * https://leetcode.com/problems/design-snake-game<br><br>
 * 
 * Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not 
 * familiar with the game.<br>
 * 
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.<br>
 * 
 * You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's 
 * score both increase by 1.<br>
 * 
 * Each food appears one by one on the screen. For example, the second food will not appear until the first food was 
 * eaten by the snake.<br>
 * 
 * When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.
 */
public class DesignSnakeGame {    
    
    private int width;
    private int height;
    private int[][] food;
    private int foodIdx;
    private List<int[]> position;
    private Set<int[]> set;
    private int score;
    
    /** Initialize your data structure here.
    @param width - screen width
    @param height - screen height 
    @param food - A list of food positions
    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        foodIdx = 0;        
        position = new ArrayList<int[]>();
        position.add(new int[] {0, 0});
        set = new HashSet<int[]>();
        set.add(position.get(0));
        score = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = new int[] {position.get(0)[0], position.get(0)[1]};
        int[] tail = position.get(position.size() - 1);
        position.remove(position.size() - 1);
        set.remove(tail);
        
        if (direction.equals("U")) {
            head[0]--;
        }
        else if (direction.equals("D")) {
            head[0]++;
        }
        else if (direction.equals("L")) {
            head[1]--;
        }
        else if (direction.equals("R")) {
            head[1]++;
        }
        if (set.contains(head) || head[0] < 0 || head[0] >= height || head[1] < 0 || head[1] >= width) {
            return -1;
        }
        
        position.add(0, head);
        set.add(head);
        
        if (foodIdx < food.length && head[0] == food[foodIdx][0] && head[1] == food[foodIdx][1]) {
            foodIdx++;
            position.add(tail);
            set.add(tail);
            score++;
        }
        return score;
    }
    
    public static void main(String[] args) {
        int[][] food = { {1, 2}, {0, 1} };
        DesignSnakeGame snakeGame = new DesignSnakeGame(3, 2, food);
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("U"));
    }

}
