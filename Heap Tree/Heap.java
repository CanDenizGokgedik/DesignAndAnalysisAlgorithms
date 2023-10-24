public class Heap {
    // MAX HEAP

    private int[] heap;
    private int size;
    
    public Heap(int capacity){
        heap = new int[capacity];
    }

    public void insert(int value){
        if(isFull()){
            throw new IndexOutOfBoundsException("Heap is full");
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public void delete(int index){
        if(isEmpty()) return;
        heap[index] = heap[size-1];
        heapifyDown(index);
        size--;
    }
 
    private void heapifyUp(int index){

        if(index == 0) return;

        int parent = getParent(index);
        if(heap[index]>heap[parent]){
            int temp = heap[parent];
            heap[parent] = heap[index];
            heap[index] = temp;
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index){

        int left = getLeftChild(index);
        int right = getRightChild(index);
        int max; 

        if(right >= size){
            if(left >= size) return;
            max = left;
        }else{
            if(heap[left] > heap[right]){
                max = left;
            }else{
                max = right;
            }
        }

        if(heap[index]>heap[max]){
            return;
        }else{
            int temp = heap[index];
            heap[index] = heap[max];
            heap[max] = temp;
            heapifyDown(max);
        }


    }



    public boolean isFull(){
        return size == heap.length;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }

    public int getParent(int index){
        return (index-1) / 2; //integer dividing is complete with rounded down.
    }

    public int getLeftChild(int index){
        return (index*2)+1;
    }

    public int getRightChild(int index){
        return (index*2)+2;
    }

    public void printHeap(){
        for(int i = 0; i<size;i++){
            System.out.println(heap[i]);
        }
    }
    


    
}
