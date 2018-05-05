package com.graphtest.graphreduction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRedGreenGraph {

    RedGreenGraph redGreenGraph;

    @Before
    public void initializeTestData() {
        // create test data input from the provided example (see src/inputfiles/input1.txt)
        redGreenGraph = new RedGreenGraph(createInitialInputData());
    }

    @Test
    public void testSimpleReduction() {
        String expected = "A\n"+"B\n"+"C\n"+"D\n";
        RedGreenGraph result = new RedGreenGraph(redGreenGraph.reduceGraph(redGreenGraph.getRedGreenNodes()));
        Assert.assertEquals(expected, result);
    }

    private RedGreenNode[] createInitialInputData() {
        // TODO: Generate these objects by reading from a txt file
        // create RedGreenNodes based on input
        RedGreenNode nodeA = new RedGreenNode("A","green", null);
        RedGreenNode nodeB = new RedGreenNode("B","green", null);
        RedGreenNode nodeC = new RedGreenNode("C","red", null);
        RedGreenNode nodeD = new RedGreenNode("D","red", null);
        RedGreenNode nodeE = new RedGreenNode("E","green", null);
        RedGreenNode nodeF = new RedGreenNode("F","red", null);
        RedGreenNode nodeG = new RedGreenNode("G","red", null);

        // assign direction to RedGreenNodes based on input
        nodeB.setChildrenNodes(new RedGreenNode[] {nodeA, nodeD});
        nodeC.setChildrenNodes(new RedGreenNode[] {nodeB});
        nodeD.setChildrenNodes(new RedGreenNode[] {nodeE});
        nodeF.setChildrenNodes(new RedGreenNode[] {nodeE});
        nodeG.setChildrenNodes(new RedGreenNode[] {nodeF});

        return new RedGreenNode[] {nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG};
    }
}
