import java.util.*;

public class RunningMedian {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(n, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return i1-i2;
            }
        });
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(n, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return (i1-i2)*(-1);
            }
        });
        
        if(n > 0){
            int min=0, max=0;
            for(int i=0; i < n; i++){
                int num = in.nextInt();
                if(null == minHeap.peek() || num > minHeap.peek()) {
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
                
                max = maxHeap.size(); 
                min = minHeap.size();
                if(min - max > 1) {
                    maxHeap.add(minHeap.poll());
                } else if(max - min > 1) {
                    minHeap.add(maxHeap.poll());
                }
                
                max = maxHeap.size(); 
                min = minHeap.size();
                double median = 0d;
                if(max == min) {
                    median = ((double)maxHeap.peek() + minHeap.peek())/2;
                } else if(max > min) {
                    median = (double)maxHeap.peek();
                } else {
                    median = (double)minHeap.peek();
                }
                System.out.println(String.format("%.1f", median));
            }
        } else {
            System.out.println("0.0");
        }
        
        
        in.close();
    }
}
