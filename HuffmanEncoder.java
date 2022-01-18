
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Node {
    Node left;
    Node right;
    int value;
    int freq;
}

class ImplementComparator implements Comparator<Node> {
    public int compare(Node x, Node y) {
      return x.value - y.value;
    }
  }

public class HuffmanEncoder {
    
    public static void printCode(Node root, String s) {
        if (root.left == null && root.right == null) {
          System.out.println(root.value + "   |  " + s);
          return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
      }

    public static HashMap frequency(int[] zigzag) {
        int[] matrix = zigzag;
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
   
        // for(Integer key : quantizeFreq.keySet()) {
        //     int occurrence = quantizeFreq.get(key);
        //     System.out.println(key + " occur " + occurrence + " time(s).");
        // }
      
        return quantizeFreq;
    }

    public static void encode(int[] data) {
        HashMap<Integer, Integer> freq = frequency(data);

        PriorityQueue<Node> dataQueue = new PriorityQueue<Node>(new ImplementComparator());

        for (Integer i : freq.keySet()) {
            Node n = new Node();

            n.value = i;
            n.freq = freq.get(i);

            n.left = null;
            n.right = null;

            dataQueue.add(n);
        }
        Node root = null;

        while (dataQueue.size() > 1) {
            Node a = dataQueue.peek();
            
            dataQueue.poll();

            Node b = dataQueue.peek();
            dataQueue.poll();

            Node r = new Node();

            r.freq = a.freq + b.freq;
            r.value = -1;
            r.left = a;
            r.right = b;

            root = r;

            dataQueue.add(r);
        }
        printCode(root, "");
    }

    

    public static void main(String[] args) {

        int[] data = {16, 11, 12, 14, 12, 10, 16, 14, 
                      13, 14, 18, 17, 16, 19, 24, 40, 
                      26, 24, 22, 22, 24, 49, 35, 37, 
                      29, 40, 58, 51, 61, 60, 57, 51, 
                      56, 55, 64, 72, 92, 78, 64, 68, 
                      87, 69, 55, 56, 80, 109, 81, 87, 
                      95, 98, 103, 104, 103, 62, 77, 113, 
                      121, 112, 100, 120, 92, 101, 103, 99};

        HuffmanEncoder test = new HuffmanEncoder();
        test.encode(data);
    }

}


