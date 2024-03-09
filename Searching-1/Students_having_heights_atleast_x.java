import java.util.*;
class Students_having_heights_atleast_x {

    public static int binarySearch(int[] arr,int target,int low,int high) {
        if (low>=high) return low;
        int mid = low + (high - low)/2;
        if (arr[mid]>=target)
        return binarySearch(arr,target,low,mid);
        else
        return binarySearch(arr,target,mid+1,high);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int Q = in.nextInt();
        int a[] = new int[n];
        int ans[] = new int[Q];
        for(int i=0;i<n;i++)
        a[i] = in.nextInt();
        Arrays.sort(a);
        for(int i=0;i<Q;i++) {
            int temp = in.nextInt();
            int indx = binarySearch(a,temp,0,n-1);
            ans[i] = (n-indx);
            if(a[indx] != temp && indx == n-1) ans[i] = ans[i] - 1;
        }
        for(int i : ans)
        System.out.println(i);
    }
}
