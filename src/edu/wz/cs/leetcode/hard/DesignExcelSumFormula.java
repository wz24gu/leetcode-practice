package edu.wz.cs.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 631. Design Excel Sum Formula<br>
 * https://leetcode.com/problems/design-excel-sum-formula<br><br>
 * 
 * Your task is to design the basic function of Excel and implement the function of sum formula. Specifically, you need 
 * to implement the following functions:<br>
 * 
 * Excel(int H, char W): This is the constructor. The inputs represents the height and width of the Excel form. H is a 
 * positive integer, range from 1 to 26. It represents the height. W is a character range from 'A' to 'Z'. It represents 
 * that the width is the number of characters from 'A' to W. The Excel form content is represented by a height * width 
 * 2D integer array C, it should be initialized to zero. You should assume that the first row of C starts from 1, and 
 * the first column of C starts from 'A'.<br><br>
 * 
 * void Set(int row, char column, int val): Change the value at C(row, column) to be val.<br><br>
 * 
 * int Get(int row, char column): Return the value at C(row, column).<br><br>
 * 
 * int Sum(int row, char column, List of Strings : numbers): This function calculate and set the value at C(row, column), 
 * where the value should be the sum of cells represented by numbers. This function return the sum result at C(row, 
 * column). This sum formula should exist until this cell is overlapped by another value or another sum formula.<br>
 * 
 * numbers is a list of strings that each string represent a cell or a range of cells. If the string represent a single 
 * cell, then it has the following format : ColRow. For example, "F7" represents the cell at (7, F).<br>
 * 
 * If the string represent a range of cells, then it has the following format : ColRow1:ColRow2. The range will always 
 * be a rectangle, and ColRow1 represent the position of the top-left cell, and ColRow2 represents the position of the 
 * bottom-right cell.<br><br>
 * 
 * Note:<br>
 * 1. You could assume that there won't be any circular sum reference. For example, A1 = sum(B1) and B1 = sum(A1).<br>
 * 2. The test cases are using double-quotes to represent a character.<br>
 * 3. Please remember to RESET your class variables declared in class Excel, as static/class variables are persisted 
 * across multiple test cases. Please see here for more details.
 */
public class DesignExcelSumFormula {
    
    private class Cell {
        int val = 0;
        Map<Cell, Integer> formula = new HashMap<>();
        
        public Cell(int val) {
            setValue(val);
        }
        
        public Cell(String[] strFormula) {
            setFormula(strFormula);
        }
        
        public void setValue(int val) {
            formula.clear();  // clean up any relationship with other cells
            this.val = val;
        }
        
        public void setFormula(String[] strFormula) {
            formula.clear();
            for (String str : strFormula) {
                if (!str.contains(":")) {  // A1
                    int[] pos = getPosition(str);
                    addFormulaCell(pos[0], pos[1]);
                }
                else {
                    String[] pos = str.split(":");  // A1:B2
                    int[] start = getPosition(pos[0]);
                    int[] end = getPosition(pos[1]);
                    for (int r = start[0]; r <= end[0]; r++) {
                        for (int c = start[1]; c <= end[1]; c++) {
                            addFormulaCell(r, c);  // add all cells within the range
                        }
                    }
                }
            }
        }
        
        private int[] getPosition(String str) {
            int[] pos = new int[2];
            pos[1] = str.charAt(0) - 'A';
            pos[0] = Integer.parseInt(str.substring(1));
            return pos;
        }
        
        private void addFormulaCell(int r, int c) {
            if (table[r][c] == null) {
                table[r][c] = new Cell(0);
            }
            Cell cell = table[r][c];
            formula.put(cell, formula.getOrDefault(cell, 0) + 1);
        }
        
        public int getValue() {
            if (this.formula.isEmpty()) {
                return this.val;
            }
            int sum = 0;
            for (Cell cell : formula.keySet()) {
                sum += cell.getValue() * formula.get(cell);
            }
            return sum;
        }
    }
    
    private Cell[][] table;
    
    public DesignExcelSumFormula(int H, char W) {
        table = new Cell[H+1][W-'A'+1];  // height + 1, but width does not
    }
    
    public void set(int r, char c, int v) {
        if (table[r][c-'A'] == null) {
            table[r][c-'A'] = new Cell(v);
        }
        else {
            table[r][c-'A'].setValue(v);
        }
    }
    
    public int get(int r, char c) {
        if (table[r][c-'A'] == null) {
            return 0;
        }
        else {
            return table[r][c-'A'].getValue();
        }
    }
    
    public int sum(int r, char c, String[] strs) {
        if (table[r][c-'A'] == null) {
            table[r][c-'A'] = new Cell(strs);
        }
        else {
            table[r][c-'A'].setFormula(strs);
        }
        return table[r][c-'A'].getValue();
    }
    
    public static void main(String[] args) {
        DesignExcelSumFormula excel = new DesignExcelSumFormula(3, 'C');
        excel.set(1, 'A', 2);
        System.out.println(excel.sum(3, 'C', new String[] {"A1", "A1:B2"}));        
        excel.set(2, 'B', 2);
    }

}
