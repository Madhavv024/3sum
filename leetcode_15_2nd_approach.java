
package leetcode;

import java.util.*;

public class leetcode_15_2nd_approach {
    public static void main(String[] args) {
        int a[] = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        cal3sum(a);
    }
    //3 pointer approach
    static void cal3sum(int a[])
    {
        //step 1 sorting out array
        
        Arrays.sort(a); 
        System.out.println(Arrays.toString(a));
        
        
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        for(int i = 0; i<a.length;i++)
        {
            
            int sum = Integer.MAX_VALUE;
            if(i>0 && a[i]==a[i-1]) //to remove duplicates
            {  //if equal skip those
                continue;
            }
            int j=i+1;
            int k = a.length-1;
            while(k>j)
            {
                sum = a[i]+a[j]+a[k];
                
                
                if(sum==0) //when sum is 0 make list of those elements and add in mainlist
                {
                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(a[i]);
                    al.add(a[j]);
                    al.add(a[k]);
                    mainList.add(al);
                    k--;
                    while(k>j && a[k]==a[k+1])
                    {
                        k--;
                    }
                }
                else if(sum>0) // when sum > 0 
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
            
        }
        
        System.out.println(mainList);
    }
}
