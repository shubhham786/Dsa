package Recursion;

public class question {
    

    public static int equalSet(int[] arr, int idx, int sum1, int sum2, String set1, String set2)
    {
        if(idx==arr.length)
        {
            if(sum1==sum2){
            System.out.println(set1 + "=" + set2);
            return 1;
            }

            return 0;
        }

        int count=0;

        count+=equalSet(arr,idx+1,sum1+arr[idx],sum2,set1+arr[idx]+" ",set2);
        count+=equalSet(arr, idx, sum1, sum2+arr[idx], set1, set2+arr[idx]+" ");


        return count;

    }


    public static void equalSet() {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };

        //ye mirror image de dega 
        /*
         System.out.println(equalSet(arr, 0,0, 0," ", ""));
           */
       //  tu usko bacahne ke liye kisse ek ko ek set me fix kar do

        System.out.println(equalSet(arr, 1, arr[0], 0, arr[0] + " ", ""));
    }

    public static int permuation(String s,String ans)
    {
  

         if(s.length()==0)
         {
            System.out.println(ans);
            return 1;
         }

        int count=0;

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            String restOfString=s.substring(0, i) +s.substring(i+1);
            
            count+=permuation(restOfString, ans+ch);

        }

        return count;

    }

  public static  int permutationUnique(String str, String ans)
  {
    if (str.length() == 0)
    {
        System.out.println(ans);
        
        return 1;
    }

      boolean[]vis=new boolean[26];
   
    int count = 0;
    for (int i = 0; i < str.length(); i++)
    {
        char ch = str.charAt(i);
        if (!vis[ch - 'a'])
        {
            vis[ch - 'a'] = true;
            String restOfString = str.substring(0, i) + str.substring(i + 1);
            count += permutationUnique(restOfString, ans + ch);
        }
    }

    return count;
}


// call bhut baccha liye isme (lekin sorted string pass kargoe tab)
public static int permutationUnique2(String str, String ans)
{
    if (str.length() == 0)
    {
        System.out.println(ans);
       
        return 1;
    }

    char prev = '$';
    int count = 0;
    for (int i = 0; i < str.length(); i++)
    {
        char ch = str.charAt(i);
        if (prev != ch)
        {
             String restOfString = str.substring(0, i) + str.substring(i + 1);
            count += permutationUnique2(restOfString, ans + ch);
        }
        prev = ch;
    }

    return count;
}
    public static void main(String[] args) {
     
        System.out.println(permutationUnique("aba", ""));
    }
}
