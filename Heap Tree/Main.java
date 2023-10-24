public class Main {
    public static void main(String args[]){
       

        

        MinHeap minHeap = new MinHeap(20);

        
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(5);
        minHeap.insert(6);
        minHeap.insert(7);
        minHeap.insert(8);
        minHeap.insert(9);
        minHeap.insert(10);
        minHeap.insert(11);
        minHeap.insert(12);
        minHeap.insert(13);
        minHeap.insert(0);
        
        int[] x = minHeap.heapSort();
        System.out.println(x.length);
        System.out.println("**************");

        

        for(int a: x){
            System.out.println(a);
        }

    }
}
