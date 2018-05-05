package com.graphtest.graphreduction;

public class RedGreenNode {
    private String name;
    private String color;
    private RedGreenNode[] childrenNodes;

    public RedGreenNode(String name, String color, RedGreenNode[] childrenNodes) {
        this.name = name;
        this.color = color;
        this.childrenNodes = childrenNodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public RedGreenNode[] getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(RedGreenNode[] childrenNodes) {
        this.childrenNodes = childrenNodes;
    }

    @Override
    public String toString() {
        return name;
    }
}
