package com.graphtest.graphreduction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;

public class ReadInputFileUtil {
    private static final int NODE_INPUT_LENGTH = 3;
    private static final String INPUT_FILE_PATH = "src/inputfiles/input1.txt";

    public static void main(String[] args) throws Exception
    {
        File file = new File(INPUT_FILE_PATH);
        BufferedReader br = new BufferedReader(new FileReader(file));

        RedGreenNode graph = new RedGreenNode("graph", RedGreenNode.NodeType.GRAPH, null);

        String currentLine;
        int count = 0;
        int nodeContentLength = 0;
        int edgeContentLength = 0;

        // the first line should be our content length
        currentLine = br.readLine();

        // initialize the node array to the specified length
        nodeContentLength = Character.getNumericValue(currentLine.toCharArray()[0]);
        graph.setChildrenNodes(new RedGreenNode[nodeContentLength]);
        HashMap<String,Integer> nameIndices = new HashMap<>();
        boolean onEdgeData = false;

        // process the node data
        while ((currentLine = br.readLine()) != null) {
            System.out.println(currentLine);
            // first portion of data is for colors, second is for edge data

            if (count < nodeContentLength) {
                if(!onEdgeData) {
                    // create our objects
                    RedGreenNode currentNode = createNodeFromString(currentLine);
                    graph.getChildrenNodes()[count] = currentNode;
                    nameIndices.put(currentNode.getName(), count);
                    count++;
                } else {
                    edgeContentLength = Character.getNumericValue(currentLine.toCharArray()[0]);
                    break;
                }
            } else {
                onEdgeData = true;
                count = 0;
            }
        }

        // TODO: process the edge data


        System.out.println(" resulting set of nodes " + Arrays.deepToString(graph.getChildrenNodes()));
    }

    // the first letter is the name of the node, R denotes red, G denotes green
    private static RedGreenNode createNodeFromString(String nodeDescription) {
        if(nodeDescription.length() == NODE_INPUT_LENGTH) {
            RedGreenNode node = new RedGreenNode();
            char[] characters = nodeDescription.toCharArray();
            // first index is our node name
            node.setName(Character.toString(characters[0]));
            // second index is our NodeType color
            switch (characters[2]) {
                case 'R':
                case 'r':
                    node.setNodeType(RedGreenNode.NodeType.RED);
                    break;
                case 'G':
                case 'g':
                    node.setNodeType(RedGreenNode.NodeType.GREEN);
                    break;
            }
            char[] values = nodeDescription.toCharArray();
            return node;
        }
        // if the length is not NODE_INPUT_LENGTH then input is invalid and node cannot be created
        return null;
    }
}
