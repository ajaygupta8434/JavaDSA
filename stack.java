class Innerstack {
int size;
int top;
int stack[];
Innerstack(int size){
    this.size=size;
    this.top=-1;
    this.stack=new int[size];
}
//push data into stack
public void push(int val){
    if(top==size-1){
        System.out.println("Stack Overflow");
        return;
    }
    top++;
    stack[top]=val;
}
//pop data from stack
public int pop(){
    if(top==-1){
        System.out.println("Stack Underflow");
        return -1;
    }
   // int val=stack[top];
    //top--;
    return stack[top--];
}

public int peep(){
    if(top==-1){
        System.out.println("Stack is empty");
        return -1;
    }
    return stack[top];
}
void display(){
    if(top==-1){
        System.out.println("Stack is empty");
        return;
    }
    for(int i=top;i>=0;i--){
        System.out.println(stack[i]);
    }
}
}
public class stack {
    public static void main(String[] args) {
        Innerstack s=new Innerstack(5);
        s.push(10);
        s.push(15);
        s.push(30);
        System.err.println("Stack elements are:\n");
        s.display();
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}

