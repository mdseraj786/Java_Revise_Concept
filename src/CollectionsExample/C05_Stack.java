package CollectionsExample;

import java.util.LinkedList;
import java.util.Stack;

public class C05_Stack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);

        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }


        // we can also use vector methode bcoz stack extends vector class

        // we can also implement stack using linked list push-addLast(), peek-getLast() pop-removeLast()
        System.out.println("\n ---  using linked list --- \n");
        LinkedList<Integer> lst = new LinkedList<>();
        lst.addLast(1);
        lst.addLast(2);
        lst.addLast(3);
        lst.addLast(4);

        int size = lst.size();
        for(int i=0; i<size; i++){
            System.out.println(lst.getLast());
            lst.removeLast();
        }
    }


}
