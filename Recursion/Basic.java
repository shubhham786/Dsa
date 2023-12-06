package Recursion;

import java.util.ArrayList;

public class Basic{

   public static  void printIncreasing(int a ,int b)
   {
         if(a>b)
           return ;

         System.out.print(a + " " );
         printIncreasing(a+1, b);
   }

   public static void printDecreasing(int a  ,int b)
   {
       if(a>b)
        return ;

        System.out.print(b + " ");
        printDecreasing(a, b-1);
   }
    public static void printIncreasingDecreasing(int a, int b)
    {
        if(a>b)
        return ;

        System.out.print(a + " ");
        printIncreasingDecreasing(a+1, b);
        //System.out.println();
         System.out.print(a + " ");
    }

    public static void printOddEven(int a ,int b)
    {
       if(a>b)
        return ;
      
        if(a%2 != 0){
         System.out.print(a + " ");
        }
        printOddEven(a+1, b);
        //System.out.println();
        if(a%2 == 0){
         System.out.print(a + " ");
        }
    }

    public static int fact(int n)
    {
        return n==0?1:n*fact(n-1);
    }

    public static int pow(int a ,int b)
    {
      if(b==0)
        return 1;

       int smallPow=pow(a,b/2);
       smallPow *=smallPow;
       
       return b%2 != 0?smallPow*a:smallPow;

    }
    public static int maximum(int[] arr, int idx) {
      if (idx == arr.length)
          return (int) -1e9;
      int maxSF = maximum(arr, idx + 1);
      return Math.max(maxSF, arr[idx]);

  }

  public static int minimum(int[] arr, int idx) {
      if (idx == arr.length)
          return (int) 1e9;
      int minSF = minimum(arr, idx + 1);
      return Math.min(minSF, arr[idx]);

  }

  public static boolean find(int[] arr, int idx, int data) {
      if (idx == arr.length)
          return false;
      return arr[idx] == data || find(arr, idx + 1, data);
  }

  public static int firstIndex(int[] arr, int idx, int data) {
      if (idx == arr.length)
          return -1;

      if (arr[idx] == data)
          return idx;
      return firstIndex(arr, idx + 1, data);

      // return arr[idx] == data ? idx : firstIndex(arr,idx +1 ,data);
      //one line me

  }

  public static int lastIndex(int[] arr, int idx, int data) {
       if(idx==arr.length)
         return -1;

         int smallAns=lastIndex(arr, idx+1, data);

         if(smallAns!=-1)
          return smallAns;

        return arr[idx]==data?idx:-1 ; 
  }

  public static int[] allIndex(int[] arr, int idx, int data, int count) {
       if(idx==arr.length)
       {
        int[] base=new int[count];
        return base;

       }

       if(arr[idx]==data)
        count++;
      int[] smallAns=allIndex(arr, idx+1, data, count);

      if(arr[idx]==count){
         smallAns[count-1]=idx;
     
      }

    return smallAns;
        

  }

  public static ArrayList<String> subSeq(String str, int idx)
  {
       if(idx==str.length())
       {
         ArrayList<String>base=new ArrayList<>();
         base.add("");
         return base;

         
       }

       ArrayList<String>recAns=subSeq(str, idx+1);
       ArrayList<String>myAns=new ArrayList<>(recAns);

       for(String s:recAns)
       {
             myAns.add(str.charAt(idx)+s);
       }

      return myAns;
  }

    public static void main(String[] args) {
        //longestShortestPath();
        // printIncreasing(5, 9);
        // System.out.println();
        // printDecreasing(5, 9);
        // System.out.println();
        // printIncreasingDecreasing(5, 9);
        // System.out.println();
        //printOddEven(5, 9);

      //  System.out.println(pow(2,3));
      // int [] arr=new int[]{1,2,35,8};
      // System.out.println(minimum(arr, 0));
  ArrayList<String>arr=subSeq("abc", 0);
     for(String s:arr)
        System.out.println(s);
    }


}