public class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int capacity){
        heap = new int[capacity];
    }
    
    public void insert(int value){
        if(isFull()){
            return;
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    private void heapifyUp(int index){
        if(index == 0) return;
        int parent = getParent(index);

        if(heap[parent] > heap[index]){
            int temp = heap[parent];
            heap[parent] = heap[index];
            heap[index] = temp;
            heapifyUp(parent);
        }
    }

    public void delete(int index){
        if(isEmpty()) return;
        heap[index] = heap[size -1];
        heapifyDown(index);
        size--;
    }  

    private void heapifyDown(int index){
        int left = getLeftChild(index);
        int right = getRightChild(index);
        int min; 
        if(right >= size){
            if(left >= size) return;
            min = left;
        }else{
            if(heap[right] > heap[left]){
                min = left;
            }else{
                min = right;
            }
        }

        if(heap[index]>heap[min]){
            int temp = heap[index];
            heap[index] = heap[min];
            heap[min] = temp;
            heapifyDown(min);
        }
    }

    public void printHeap(){
        for(int i=0; i<size; i++){
            System.out.println(heap[i]);
        }
    }   


    private int getParent(int index){
        return (index-1) / 2;
    }

    private int getLeftChild(int index){
        return index*2 + 1;
    }

    private int getRightChild(int index){
        return index*2 + 2;
    }

    private boolean isFull(){
        return heap.length == size;
    }

    private boolean isEmpty(){
        return size == 0;
    }   

    private int peek(){
        return heap[0];
    }

    public int[] heapSort(){
        int arr[] = new int[size];
        int size2 = 0;
        int heapSize = size;


        while(size2 < heapSize){
            arr[size2] = peek();
            delete(0);
            size2++;
        }
        return arr;
    }

}
