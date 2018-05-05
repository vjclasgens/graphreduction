package com.graphtest.graphreduction;

import java.util.Arrays;
import java.util.HashMap;

public class RedGreenNode {
    public enum NodeType {RED, GREEN, GRAPH}

    private String name;
    private NodeType nodeType;
    private RedGreenNode[] childrenNodes;

    public RedGreenNode() {}

    public RedGreenNode(String name, NodeType nodeType, RedGreenNode[] childrenNodes) {
        this.name = name;
        this.nodeType = nodeType;
        this.childrenNodes = childrenNodes;
    }

    // Reduce graph based on 2 criteria
    // 1) Any red node not reachable from a green node is removed
    // 2) Every green node from the input is in the output
    public RedGreenNode[] reduceGraph(RedGreenNode[] graph) {
        HashMap<String, RedGreenNode> visitedReds = new HashMap<>();

        for(int i = 0; i < graph.length; i++) {
            // if the graph is green we traverse the children and mark as visited
            if(graph[i].getNodeType().equals(NodeType.GREEN) && graph[i].getChildrenNodes() != null) {
                for(RedGreenNode node : graph[i].getChildrenNodes()) {
                    if(node.getNodeType().equals(NodeType.RED)) {
                        visitedReds.put(node.name, node);
                    }
                }
            }
        }

        return deleteUnvisitedReds(visitedReds, graph);
    }

    // generate the requested output string in the format
    // A
    // B
    // D
    // E
    public String getChildrenString() {
        StringBuilder sb = new StringBuilder();
        for(RedGreenNode rgn : childrenNodes) {
            if(rgn != null) {
                sb.append(rgn.getName());
                sb.append("\n");
            }
        }
        if(sb.length() == 0){
            return "";
        }
        // remove the trailing \n character and convert to string
        return sb.subSequence(0, sb.length()-1).toString();
    }

    private RedGreenNode[] deleteUnvisitedReds(HashMap<String, RedGreenNode> visitedNodes, RedGreenNode[] graph) {
        for(int i = 0; i < graph.length; i++) {
            // if we haven't visited a red node delete it by nulling it out
            if(graph[i].getNodeType().equals(NodeType.RED) && !visitedNodes.containsKey(graph[i].name)) {
                graph[i] = null;
            }
        }
        return graph;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType color) {
        this.nodeType = color;
    }

    public RedGreenNode[] getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(RedGreenNode[] childrenNodes) {
        this.childrenNodes = childrenNodes;
    }

    @Override
    public String toString() {
        return "RedGreenNode{" +
                "name='" + name + '\'' +
                ", nodeType=" + nodeType +
                ", childrenNodes=" + Arrays.toString(childrenNodes) +
                '}';
    }


}
