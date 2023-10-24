import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top;

    public ArrayStack(int capacity){
        stack = new Employee[capacity];
    }

    public void push(Employee employee){
        if(top == stack.length-1){
            Employee[] temp = stack;
            stack = new Employee[temp.length+1];
            for(int i=0; i<temp.length;i++){
                stack[i] = temp[i];
            }
        }
        stack[top++] = employee;
    }


    public Employee pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }



    public boolean isEmpty(){
        return top == 0;
    }
}
