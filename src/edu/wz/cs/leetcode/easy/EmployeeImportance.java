package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 690. Employee Importance<br>
 * https://leetcode.com/problems/employee-importance<br><br>
 * 
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value
 * and his direct subordinates' id.<br>
 * 
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance
 * value 15, 10, and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has
 * [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the
 * relationship is not direct.<br>
 * 
 * Now given the employee information of a company, you need to return the total importance value of this employee and
 * all his subordinates<br><br>
 * 
 * Note:<br>
 * 1. One employee has at most one direct leader and may have several subordinates.<br>
 * 2. The maximum number of employees won't exceed 2000.
 */
public class EmployeeImportance {
    
    private static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
        public Employee(int id, int value) {
            this.id = id;
            this.importance = value;
            this.subordinates = new ArrayList<Integer>();
        }
    }

    public static int solution(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        set.add(id);
        while (!queue.isEmpty()) {
            int eId = queue.poll();
            Employee e = map.get(eId);
            sum += e.importance;
            for (int subordinateId : e.subordinates) {
                if (!set.contains(subordinateId)) {
                    queue.offer(subordinateId);
                    set.add(subordinateId);
                }
            }
        }
        
        return sum;
    }
    
    public static int solutionAlt(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return helper(map, id);
    }
    
    private static int helper(Map<Integer, Employee> map, int id) {
        Employee e = map.get(id);
        int importance = e.importance;        
        for (int i : e.subordinates) {
            importance += helper(map, i);
        }        
        return importance;
    }
    
    public static void main(String[] args) {
        Employee e1 = new Employee(1, 5);
        Employee e2 = new Employee(2, 3);
        Employee e3 = new Employee(3, 3);        
        e1.subordinates.add(2);
        e1.subordinates.add(3);
        
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        
        System.out.println(EmployeeImportance.solution(employees, 1));
        System.out.println(EmployeeImportance.solutionAlt(employees, 1));
    }

}
