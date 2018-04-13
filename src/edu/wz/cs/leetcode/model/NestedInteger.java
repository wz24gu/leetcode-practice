package edu.wz.cs.leetcode.model;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    
    private int value;
    private boolean isInteger;
    private List<NestedInteger> list;
    
    // Constructor initializes an empty nested list.
    public NestedInteger() {
        super();
    }
    
    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        isInteger = true;
        this.value = value;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return isInteger;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        if (isInteger) {
            return value;
        }
        return null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
        list = null;
        isInteger = true;
        this.value = value;
    }
    
    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        isInteger = false;
        value = 0;
        if (list == null) {
            list = new ArrayList<NestedInteger>();
        }
        list.add(ni);
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        if (!isInteger) {
            return list;
        }
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isInteger) {
            sb.append(getInteger() + " ");
        }
        else {
            if (getList() != null) {
                for (NestedInteger ni : getList()) {
                    sb.append(ni.toString());
                }
            }
        }
        return sb.toString();
    }

}
