import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		int[] num = new int[args.length];
		for(String s : args) {
			num[i++] = Integer.parseInt(s);
		}
		
		for(List<Integer> l : threeSum(num)){
			for(Integer j : l)
				System.out.print(j + " ");
			System.out.println("\n");
		}
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            int p,q;
            p=i+1;
            q=nums.length-1;
            while(p < q && ((i>0 && nums[i]!=nums[i-1]) || i==0)) {
                if((nums[i] + nums[p] + nums[q]) == 0) {
                    res.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    while(p<q && nums[p] == nums[p+1]) {
                        p++;
                    }
                    while(p<q && nums[q] == nums[q-1]) {
                        q--;
                    }
                    p++;q--;
                } else if((nums[q] + nums[p]) < -nums[i]) {
                    p++;
                } else {
                    q--;
                }
            }
        }
        return res;
    }

}
