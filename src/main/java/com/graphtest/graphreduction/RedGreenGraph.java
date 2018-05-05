package com.graphtest.graphreduction;

import java.util.Arrays;

public class RedGreenGraph {
    private RedGreenNode[] redGreenNodes;

    public RedGreenGraph(RedGreenNode[] redGreenNodes) {
        this.redGreenNodes = redGreenNodes;
    }


    public RedGreenNode[] reduceGraph(RedGreenNode[] graph) {
        return graph;
    }

    public RedGreenNode[] getRedGreenNodes() {
        return redGreenNodes;
    }

    public void setRedGreenNodes(RedGreenNode[] redGreenNodes) {
        this.redGreenNodes = redGreenNodes;
    }

    @Override
    public String toString() {
        // use stringbuilder to reduce space b/c strings are immutable
        StringBuilder sb = new StringBuilder();
        for(RedGreenNode rgn : redGreenNodes) {
            sb.append(rgn.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
