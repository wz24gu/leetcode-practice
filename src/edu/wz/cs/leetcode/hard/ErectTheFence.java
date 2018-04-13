package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.wz.cs.leetcode.model.Point;

/**
 * 587. Erect the Fence<br/>
 * https://leetcode.com/problems/erect-the-fence<br/><br/>
 * 
 * There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to 
 * fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all 
 * the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence 
 * perimeter.<br/><br/>
 * 
 * Note:<br/>
 * 1. All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more 
 * than one group.<br/>
 * 2. All input integers will range from 0 to 100.<br/>
 * 3. The garden has at least one tree.<br/>
 * 4. All coordinates are distinct.<br/>
 * 5. Input points have NO order. No order required for output.
 */
public class ErectTheFence {
    
    // Gift wrapping aka Jarvis March
    public static List<Point> solution(Point[] points) {
        Set<Point> result = new HashSet<>();
        
        // find the leftmost point
        Point first = points[0];
        int firstIndex = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < first.x) {
                first = points[i];
                firstIndex = i;
            }
        }
        result.add(first);
        
        // get 3 points: current, next, points[i]
        Point current = first;
        int currentIndex = firstIndex;
        do {
            Point next = points[0];
            int nextIndex = 0;
            for (int i = 1; i < points.length; i++) {
                if (i == currentIndex) {
                    continue;
                }
                int cross = crossProduct(current, points[i], next);
                if (cross > 0
                        || (cross == 0 && distance(points[i], current) > distance(next, current))
                        || nextIndex == currentIndex) {
                    next = points[i];
                    nextIndex = i;
                }
            }
            
            // handle collinear points
            for (int i = 0; i < points.length; i++) {
                if (i == currentIndex) {
                    continue;
                }
                int cross = crossProduct(current, points[i], next);
                if (cross == 0) {
                    result.add(points[i]);  // this will add next too
                }
            }
            
            current = next;
            currentIndex = nextIndex;    
        } while (currentIndex != firstIndex);
        
        return new ArrayList<Point>(result);
    }
    
    private static int crossProduct(Point A, Point B, Point C) {
        int BAx = A.x - B.x;
        int BAy = A.y - B.y;
        int BCx = C.x - B.x;
        int BCy = C.y - B.y;
        return (BAx * BCy - BAy * BCx);
    }
    
    private static int distance(Point A, Point B) {
        return (A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y * B.y);
    }
    
    public static void main(String[] args) {
        Point[] points = new Point[] {
            new Point(1, 1),
            new Point(2, 2),
            new Point(2, 0),
            new Point(2, 4),
            new Point(3, 3),
            new Point(4, 2)
        };
        System.out.println(ErectTheFence.solution(points));
        
        Point[] points2 = new Point[] {
            new Point(1, 2),
            new Point(2, 2),
            new Point(4, 2)
        };
        System.out.println(ErectTheFence.solution(points2));
    }

}
