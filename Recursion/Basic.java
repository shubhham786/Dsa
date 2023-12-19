package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Basic {

  public static void printIncreasing(int a, int b) {
    if (a > b)
      return;

    System.out.print(a + " ");
    printIncreasing(a + 1, b);
  }

  public static void printDecreasing(int a, int b) {
    if (a > b)
      return;

    System.out.print(b + " ");
    printDecreasing(a, b - 1);
  }

  public static void printIncreasingDecreasing(int a, int b) {
    if (a > b)
      return;

    System.out.print(a + " ");
    printIncreasingDecreasing(a + 1, b);
    // System.out.println();
    System.out.print(a + " ");
  }

  public static void printOddEven(int a, int b) {
    if (a > b)
      return;

    if (a % 2 != 0) {
      System.out.print(a + " ");
    }
    printOddEven(a + 1, b);
    // System.out.println();
    if (a % 2 == 0) {
      System.out.print(a + " ");
    }
  }

  public static int fact(int n) {
    return n == 0 ? 1 : n * fact(n - 1);
  }

  public static int pow(int a, int b) {
    if (b == 0)
      return 1;

    int smallPow = pow(a, b / 2);
    smallPow *= smallPow;

    return b % 2 != 0 ? smallPow * a : smallPow;

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
    // one line me

  }

  public static int lastIndex(int[] arr, int idx, int data) {
    if (idx == arr.length)
      return -1;

    int smallAns = lastIndex(arr, idx + 1, data);

    if (smallAns != -1)
      return smallAns;

    return arr[idx] == data ? idx : -1;
  }

  public static int[] allIndex(int[] arr, int idx, int data, int count) {
    if (idx == arr.length) {
      int[] base = new int[count];
      return base;

    }

    if (arr[idx] == data)
      count++;
    int[] smallAns = allIndex(arr, idx + 1, data, count);

    if (arr[idx] == count) {
      smallAns[count - 1] = idx;

    }

    return smallAns;

  }

  public static ArrayList<String> subSeq(String str, int idx) {
    if (idx == str.length()) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;

    }

    ArrayList<String> recAns = subSeq(str, idx + 1);
    ArrayList<String> myAns = new ArrayList<>(recAns);

    for (String s : recAns) {
      myAns.add(str.charAt(idx) + s);
    }

    return myAns;
  }

  public static int subseq(String str, int idx, String ans, ArrayList<String> res) {
    if (idx == str.length()) {
      res.add(ans);
      return 1;
    }

    int count = 0;
    count += subseq(str, idx + 1, ans + str.charAt(idx), res);
    count += subseq(str, idx + 1, ans, res);

    return count;
  }

  // top to bottom
  public static ArrayList<String> mazePath_HVD(int sr, int sc, int er, int ec) {
    if (sr == er && sc == ec) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> myAns = new ArrayList<>();
    int[][] dir = { { 1, 1 }, { 1, 0 }, { 0, 1 } };
    String[] dirChar = { "D", "H", "V" };

    for (int i = 0; i < dir.length; i++) {

      int r = sr + dir[i][0];
      int c = sc + dir[i][1];

      if (r <= er && c <= ec) {
        ArrayList<String> recAns = mazePath_HVD(r, c, er, ec);

        for (String s : recAns) {
          myAns.add(dirChar[i] + s);
        }

      }

    }
    return myAns;

  }

  public static int mazePath_HVD(int sr, int sc, int er, int ec, ArrayList<String> ans, String psf) {
    if (sr == er && sc == ec) {

      ans.add(psf);
      return 1;
    }
    int count = 0;
    int[][] dir = { { 1, 1 }, { 1, 0 }, { 0, 1 } };
    String[] dirChar = { "D", "H", "V" };

    for (int i = 0; i < dir.length; i++) {

      int r = sr + dir[i][0];
      int c = sc + dir[i][1];

      if (r <= er && c <= ec) {
        count += mazePath_HVD(r, c, er, ec, ans, psf + dirChar[i]);

      }

    }

    return count;

  }

  public static ArrayList<String> mazePath_HVD_multi(int sr, int sc, int er, int ec) {

    if (sr == er && sc == ec) {
      ArrayList<String> base = new ArrayList<>();
      base.add("");
      return base;
    }

    ArrayList<String> myAns = new ArrayList<>();
    int[][] dir = { { 1, 1 }, { 1, 0 }, { 0, 1 } };
    String[] dirChar = { "D", "H", "V" };

    for (int i = 0; i < dir.length; i++) {

      for (int rad = 1; rad <= Math.min(er, ec); rad++) {
        int r = sr + rad * dir[i][0];
        int c = sc + rad * dir[i][1];

        if (r <= er && c <= ec) {
          ArrayList<String> recAns = mazePath_HVD_multi(r, c, er, ec);

          for (String s : recAns) {
            myAns.add(dirChar[i] + rad + s);
          }

        }

      }
    }
    return myAns;

  }

  public static int mazePath_HVD_multi(int sr, int sc, int er, int ec, ArrayList<String> ans, String psf) {
    if (sr == er && sc == ec) {

      ans.add(psf);
      return 1;
    }
    int count = 0;
    int[][] dir = { { 1, 1 }, { 1, 0 }, { 0, 1 } };
    String[] dirChar = { "D", "H", "V" };

    for (int i = 0; i < dir.length; i++) {

      for (int rad = 1; rad <= Math.min(er, ec); rad++) {

        int r = sr + rad * dir[i][0];
        int c = sc + rad * dir[i][1];

        if (r <= er && c <= ec) {
          count += mazePath_HVD_multi(r, c, er, ec, ans, psf + dirChar[i] + rad);

        }

      }
    }

    return count;

  }

  public static int floodFill(int sr, int sc, boolean[][] vis, int[][] dir, String[] dirS, ArrayList<String> ans, String psf) {
    int n = vis.length, m = vis[0].length;

    if (sr == n - 1 && sc == m - 1) {
      ans.add(psf);
      return 1;
    }

    int count = 0;
    vis[sr][sc] = true;

    for (int d = 0; d < dir.length; d++) {
      int r = sr + dir[d][0];
      int c = sc + dir[d][1];

      if (r >= 0 && c >= 0 && r < n && c < m && !vis[r][c])
        count += floodFill(r, c, vis, dir, dirS, ans, psf + dirS[d]);

    }

    vis[sr][sc] = false;
    return count;
  }

  public static int floodFill_multi(int sr, int sc, boolean[][] vis, int[][] dir, String[] dirS, ArrayList<String> ans, String psf) {
    int n = vis.length, m = vis[0].length;

    if (sr == n - 1 && sc == m - 1) {
      ans.add(psf);
      return 1;
    }

    int count = 0;
    vis[sr][sc] = true;

    for (int d = 0; d < dir.length; d++)
      for (int rad = 1; rad <= Math.max(n, m); rad++) {
        int r = sr + rad * dir[d][0];
        int c = sc + rad * dir[d][1];

        if (r >= 0 && c >= 0 && r < n && c < m) {
          if (!vis[r][c])
            count += floodFill_multi(r, c, vis, dir, dirS, ans, psf + dirS[d] + rad);
        } else
          break;
      }

    vis[sr][sc] = false;
    return count;
  }


  public static int solve(int s,int e, int [][] dir, String[] dirS, int [][] arr,ArrayList<String>ans,String psf)
  {
      int n=arr.length;
      int m=arr[0].length;
      
      if(s==n-1 && e==m-1)
      {
          //ArrayList<String> =new ArrayList<String>();
          ans.add(psf);
          return 1;
      }
      
        arr[s][e]=-1;
        int count=0;
      for(int i=0;i<dir.length;i++)
      {
          int r=s+dir[i][0];
          int c=e+dir[i][1];
          
          
          if(r>=0 && c>=0 && r<n && c<m && arr[r][c]==1 )//&& arr[r][c]!=-1)
          {
             count+=solve(r,c,dir,dirS,arr,ans,psf+dirS[i]);   
          }
          
      }
      
      arr[s][e]=1;
      
      return count;
  }


  // longest path 

  //shortest path

  public static class pair {
    String psf = "";
    int len = 0;

    pair(String psf, int len) {
        this.len = len;
        this.psf = psf;
    }
}

public static pair longestPath(int sr, int sc, boolean[][] vis, int[][] dir, String[] dirS) {
    int n = vis.length, m = vis[0].length;
    if (sr == n - 1 && sc == m - 1) {
        return new pair("", 0);
    }

    vis[sr][sc] = true; // blocked
    pair myAns = new pair("", -1);// iska notes me dalnge ki -1 kuy rakha hoon
    for (int d = 0; d < dir.length; d++) {
        int r = sr + dir[d][0];
        int c = sc + dir[d][1];

        if (r >= 0 && c >= 0 && r < n && c < m) {
            if (!vis[r][c]) {
                pair recAns = longestPath(r, c, vis, dir, dirS);
                if (recAns.len != -1 && recAns.len + 1 > myAns.len) {
                    myAns.len = recAns.len + 1;
                    myAns.psf = dirS[d] + recAns.psf;
                }
            }
        }
    }

    vis[sr][sc] = false; // unblocked
    return myAns;
}

public static pair shortestPath(int sr, int sc, boolean[][] vis, int[][] dir, String[] dirS) {
    int n = vis.length, m = vis[0].length;
    if (sr == n - 1 && sc == m - 1) {
        return new pair("", 0);
    }

    vis[sr][sc] = true; // blocked
    pair myAns = new pair("", (int)1e9);
    for (int d = 0; d < dir.length; d++) {
        int r = sr + dir[d][0];
        int c = sc + dir[d][1];

        if (r >= 0 && c >= 0 && r < n && c < m) {
            if (!vis[r][c]) {
                pair recAns = shortestPath(r, c, vis, dir, dirS);
                if (recAns.len != (int)1e9 && recAns.len + 1 < myAns.len) {
                    myAns.len = recAns.len + 1;
                    myAns.psf = dirS[d] + recAns.psf;
                }
            }
        }
    }

    vis[sr][sc] = false; // unblocked
    return myAns;
}

public static void longestShortestPath() {
    int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    String[] dirS = { "D", "R", "U", "L" };

    boolean[][] vis = new boolean[3][3];
    // vis[1][1] = vis[1][2] = vis[2][1] = true;

    pair ans = longestPath(0, 0, vis, dir, dirS);
    System.out.println(ans.psf + " @ " + ans.len);
}
  public static ArrayList<String> findPath(int[][] m, int n) {
      // Your code here
      
      if(m[n-1][n-1]==0)
        return new ArrayList<String>();
        
        
      int [][] dir={{0,1},{0,-1},{1,0},{-1,0}};
      String [] dirS={"U","D","L","R"};
       
     // int [][] vis=new int [n][n];
      
        ArrayList<String> ans=new ArrayList<String>();
        solve(0,0,dir,dirS,m,ans,"");
      
      return ans;
  }

   // https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
    // https://practice.geeksforgeeks.org/problems/special-matrix4201/1
    // https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/?ref=rp
  public static void main(String[] args) {
    // longestShortestPath();
    // printIncreasing(5, 9);
    // System.out.println();
    // printDecreasing(5, 9);
    // System.out.println();
    // printIncreasingDecreasing(5, 9);
    // System.out.println();
    // printOddEven(5, 9);

    // System.out.println(pow(2,3));
    // int [] arr=new int[]{1,2,35,8};
    // System.out.println(minimum(arr, 0));
    // ArrayList<String> arr = mazePath_HVD_multi(0, 0, 2, 2);
    // System.out.println(arr.size());
    // ArrayList<String> arr1 = new ArrayList<>();
    // int count = 0;
    // count = mazePath_HVD_multi(0, 0, 2, 2, arr1, "");
    // System.out.println(count);
    // System.out.println(arr1);
    // System.out.println(arr);

   int [][]m={{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
    ArrayList<String>arr=findPath(m, 4);

       Collections.sort(arr);
    System.out.println(arr);

  }

}