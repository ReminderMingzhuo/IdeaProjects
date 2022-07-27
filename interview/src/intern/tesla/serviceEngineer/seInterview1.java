package intern.tesla.serviceEngineer;

public class seInterview1 {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        int result = s1.addTwo(1,2);
        System.out.println("result"+result);
    }
}

class Solution{
    public int addTwo(int i,int j){
        return i+j;
    }
}
