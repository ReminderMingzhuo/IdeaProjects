package intern.byteDance.backEnd2208;

public class beInterview1 {
    public static void main(String[] args) {

    }

    public Node findLastKNode(Node root, int k){
        Node ptr = root;
        if(ptr == null) return null;
        int loop_times = k;
        while(ptr.next != null && k > 0){
            ptr = ptr.next;
            k--;
        }
        if(k > 0) return null;


        Node res = root;
        while(ptr.next != null){
            ptr = ptr.next;
            res = res.next;
        }

        return res;
    }

    public class Node{
        Node next;
        int val;
    }
}
//计算机基础，