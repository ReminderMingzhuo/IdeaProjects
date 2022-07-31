package intern.tesla.serviceEngineer;

public class seInterview1 {
    public static void main(String[] args) {
        Solution s1 = new Solution(1);
        Solution s0 = new Solution();
        int result = s1.addTwo(s1.val,s0.val);
        System.out.println("result: "+result);
    }
}


class Solution{
    int val;
    public Solution(){
        val = 0;
    }
    public Solution(int value){
        val = value;
    }
    public int addTwo(int i,int j){
        return i+j;
    }
}
