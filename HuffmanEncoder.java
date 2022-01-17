
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
class Node {
    Node left;
    Node right;
    int value;
}

public class HuffmanEncoder {
    
    public HuffmanEncoder(int[] data) {

    }

    public HashMap frequency(int[] zigzag) {
        PriorityQueue<Node> dataQueue = new PriorityQueue<Node>();

        int[]matrix = zigzag;
        HashMap<Integer, Integer> quantizeFreq = new HashMap<Integer, Integer>();



        for(int key : matrix) {
            if(quantizeFreq.containsKey(key)) {
                int occurrence = quantizeFreq.get(key);
                occurrence++;
                quantizeFreq.put(key, occurrence);
            } else {
                quantizeFreq.put(key, 1);
            }
        }
   
        for(Integer key : quantizeFreq.keySet()) {
            int occurrence = quantizeFreq.get(key);
            System.out.println(key + " occur " + occurrence + " time(s).");
        }
        // char[] charArray = { 'A', 'B', 'C', 'D' };
        // int[] charfreq = { 5, 1, 6, 3 };
     return quantizeFreq;
    }
}


