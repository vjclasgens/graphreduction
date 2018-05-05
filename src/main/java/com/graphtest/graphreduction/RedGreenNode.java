package com.graphtest.graphreduction;

public class RedGreenNode {
    public enum NodeType {RED, GREEN, GRAPH}

    private String name;
    private NodeType nodeType;
    private RedGreenNode[] childrenNodes;

    public RedGreenNode(String name, NodeType nodeType, RedGreenNode[] childrenNodes) {
        this.name = name;
        this.nodeType = nodeType;
        this.childrenNodes = childrenNodes;
    }

    // this is the method where we'll solve the problem
    public RedGreenNode[] reduceGraph(RedGreenNode[] graph) {
        return graph;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeType getColor() {
        return nodeType;
    }

    public void setColor(NodeType color) {
        this.nodeType = color;
    }

    public RedGreenNode[] getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(RedGreenNode[] childrenNodes) {
        this.childrenNodes = childrenNodes;
    }

    public String getChildrenString() {
        // use stringbuilder to reduce space b/c strings are immutable
        StringBuilder sb = new StringBuilder();
        for(RedGreenNode rgn : childrenNodes) {
            sb.append(rgn.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return name;
    }


}
