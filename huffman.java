
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.ArrayList;

class Node {
    Node left;
    Node right;
    int value;
}

public class HuffmanEncoder {
    
    public Node encodeData(int[] data) {

    }

    public static void main(String args[]) {
        PriorityQueue<Node> dataQueue = new PriorityQueue<Node>();

        HashMap<Double, Integer> quantizeFreq = new HashMap<Double, Integer>();

        double[][] quantizeTable = {
			{16, 11, 10, 16, 24, 40, 51, 61},
			{12, 12, 14, 19, 26, 58, 60, 55},
			{14, 13, 16, 24, 40, 57, 69, 56},
			{14, 17, 22, 29, 51, 87, 80, 62},
			{18, 22, 37, 56, 68, 109, 103, 77},
			{24, 35, 55, 64, 81, 104, 113, 92},
			{49, 64, 78, 87, 103, 121, 120, 101},
			{72, 92, 95, 98, 112, 100, 103, 99}
		};

        ArrayList<Integer> zigzag = new ArrayList<Integer>(
            Arrays.asList(11, 12, 14, 12, 10, 16, 14, 13, 14, 18, 17, 16, 
                        19, 24, 40, 26, 24, 22, 22, 24, 49, 35, 37, 29, 40, 58, 51, 61, 
                        60, 57, 51, 56, 55, 64, 72, 92, 78, 64, 68, 87, 69, 55, 56, 80, 
                        109, 81, 87, 95, 98, 103, 104, 103, 62, 77, 113, 121, 112, 100, 
                        120, 92, 101, 103, 99)); 

        for (Integer i : zigzag) {
            if (quantizeFreq.containsKey(i)) {
                quantizeFreq.put(i, quantizeFreq.get(i)++);
            } else {
                quantizeFreq.put(i, 1);
            }
        }


        for (Integer i : quantizeFreq.keySet()) {
            System.out.println(i);
        }


        int length = 8;

        // char[] charArray = { 'A', 'B', 'C', 'D' };
        // int[] charfreq = { 5, 1, 6, 3 };

    }
}


