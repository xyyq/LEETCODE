public class Solution977 {
    public int[] sortedSquares(int[] A) {
        int[] res=new int[A.length];
        int n=A.length-1;
        int left=0;
        int right=n;
       while (left <=right) {
            int leftValue=Math.abs(A[left]);
            int rightValue=Math.abs(A[right]);
            if (leftValue<rightValue){
                res[n--]=rightValue*rightValue;
                right--;
            }else{
                res[n--]=leftValue*leftValue;
                left++;
            }
        }
       return res;
    }
}
