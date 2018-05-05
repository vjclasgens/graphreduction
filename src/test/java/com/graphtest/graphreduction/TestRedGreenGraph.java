package com.graphtest.graphreduction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.graphtest.graphreduction.RedGreenNode.NodeType;

public class TestRedGreenGraph {
    RedGreenNode redGreenGraph;

    @Before
    public void initializeTestData() {
        // create test data input from the provided example (see src/inputfiles/input1.txt)
        redGreenGraph = new RedGreenNode("graph", NodeType.GRAPH, createInitialInputData());
    }

    @Test
    public void testSimpleReduction() {
        String expected = "A\n"+"B\n"+"D\n"+"E\n";

        RedGreenNode result = new RedGreenNode("graph", NodeType.GRAPH,
                redGreenGraph.reduceGraph(redGreenGraph.getChildrenNodes()));

        Assert.assertEquals(expected, result.getChildrenString());
    }

    private RedGreenNode[] createInitialInputData() {
        // TODO: Generate these objects by reading from a txt file
        // create RedGreenNodes based on input
        RedGreenNode nodeA = new RedGreenNode("A", NodeType.GREEN, null);
        RedGreenNode nodeB = new RedGreenNode("B", NodeType.GREEN, null);
        RedGreenNode nodeC = new RedGreenNode("C", NodeType.RED, null);
        RedGreenNode nodeD = new RedGreenNode("D", NodeType.RED, null);
        RedGreenNode nodeE = new RedGreenNode("E", NodeType.GREEN, null);
        RedGreenNode nodeF = new RedGreenNode("F", NodeType.RED, null);
        RedGreenNode nodeG = new RedGreenNode("G", NodeType.RED, null);

        // assign direction to RedGreenNodes based on input
        nodeB.setChildrenNodes(new RedGreenNode[] {nodeA, nodeD});
        nodeC.setChildrenNodes(new RedGreenNode[] {nodeB});
        nodeD.setChildrenNodes(new RedGreenNode[] {nodeE});
        nodeF.setChildrenNodes(new RedGreenNode[] {nodeE});
        nodeG.setChildrenNodes(new RedGreenNode[] {nodeF});

        return new RedGreenNode[] {nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG};
    }
}
