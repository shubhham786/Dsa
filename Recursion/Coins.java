package Recursion;

/*
 1)It consist of 8 variation of coin change problem

 */

 

public class Coins {
    
    public static int permutationInfiCoins(int[] arr, int tar, String ans) {
      
       if(tar==0)
       {
            System.out.println(ans);
           return 1;
       }

        int count=0;

        for(int ele:arr)
        {
            if(tar-ele>=0)
              count+=permutationInfiCoins(arr, tar-ele, ans+ele+" ");
        }

        return count;
    }

    public static int combinationInfiCoins(int[] arr, int tar, int idx, String ans) {
      

      if(tar==0)
       {
            System.out.println(ans);
           return 1;
       }

        int count=0;
          for(int i=idx;i<arr.length;i++)
          {
             if(tar-arr[i]>=0)
              count+=combinationInfiCoins(arr, tar-arr[i], i, ans+arr[i]+" ");

              //look carefully i have passed i here not idx;
          }

          return count;
    }

    public static int combinationSingleCoins(int[] arr, int tar, int idx, String ans) {
   
      if(tar==0)
       {
            System.out.println(ans);
           return 1;
       }

        int count=0;
          for(int i=idx;i<arr.length;i++)
          {
             if(tar-arr[i]>=0)
              count+=combinationSingleCoins(arr, tar-arr[i], i+1, ans+arr[i]+" ");

             
          }

          return count;
    }

    public static int permutationSingleCoins(int[] arr, int tar, String ans) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (arr[i] > 0 && tar - arr[i] >= 0) {
                arr[i] = -val;
                count += permutationSingleCoins(arr, tar - val, ans + val);
                arr[i] = val;
            }
        }

        return count;
    }

/////////////////////////////////////////////////////////////////////
//Same question with subsequence way

public static int combinationSingleCoins_sub(int[] arr, int tar, int idx, String ans)
{

    if(tar==0 || idx==arr.length)
    {
        if(tar==0)
        {
            System.out.println(ans);
            return 1;
        }

        return 0;
    }


    int count=0;

    if(tar-arr[idx]>=0)
      count+=combinationSingleCoins_sub(arr, tar-arr[idx], idx+1, ans+arr[idx]+" ");

      count+=combinationSingleCoins_sub(arr, tar, idx+1, ans);

      return count;
}

public static int combinationInfiCoins_sub(int[] arr, int tar, int idx, String ans)
{

    if(tar==0 || idx==arr.length)
    {
        if(tar==0)
         {
            System.out.println(ans);
            return 1;
         }

         return 0;
    }

    int count=0;


    if(tar-arr[idx]>=0)
     count+=combinationInfiCoins_sub(arr, tar-arr[idx], idx, ans+arr[idx]+" ");

     count+=combinationInfiCoins_sub(arr, tar, idx+1, ans);

     return count;
}

public static int permutationInfiCoins_sub(int[] arr, int tar, int idx, String ans) 
{
    if(tar==0 || idx==arr.length)
    {
        if(tar==0)
         {
            System.out.println(ans);
            return 1;
         }

         return 0;
    }

    int count=0;

    if(tar-arr[idx]>=0)
       count+=permutationInfiCoins_sub(arr, tar-arr[idx], 0, ans+arr[idx]+" ");

      count+=permutationInfiCoins_sub(arr, tar, idx+1, ans); 

    return count;
}


public static int permutationSingleCoins_sub(int[] arr, int tar, int idx, String ans)
{
    if (tar == 0 || idx == arr.length) {
        if (tar == 0) {
            System.out.println(ans);
            return 1;
        }
        return 0;
    }

    int count = 0;

    if (arr[idx] > 0 && tar - arr[idx] >= 0) {
        int val = arr[idx];
        arr[idx] = -val;
        count += permutationSingleCoins_sub(arr, tar - val, 0, ans + val);
        arr[idx] = val;
    }
    count += permutationSingleCoins_sub(arr, tar, idx + 1, ans); 

    return count;
}

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 7 };
        int tar = 10;
        String ans = "";


        // System.out.println(combinationInfiCoins_sub(arr, tar, 0, ans));
        // System.out.println(combinationInfiCoins(arr, tar, 0, ans));
    }
}
