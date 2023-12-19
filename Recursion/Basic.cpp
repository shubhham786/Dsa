#include <iostream>
#include <vector>
using namespace std;

//TOP TO BOTTOM
//HVD
vector<string> mazePath_HVD(int sr, int sc, int er, int ec)
{
  
   if(sr==er && sc==ec)
   {
       vector<string>ans;
       ans.push_back("");
       return ans;
   }

   vector<string>ans;

     vector<vector<int>>dir={{1,1},{1,0},{0,1}};
     vector<string>dirChar={"D","H","V"};


     for(int i=0;i<dir.size();i++)
     {

         int r=sr+dir[i][0];
         int c=sc+dir[i][1];

         if(r<=er && c<=ec)
         {
            vector<string>recAns=mazePath_HVD(r,c,er,ec);
            
            for(string s:recAns)
            {
                ans.push_back(dirChar[i]+s);
            }

         }  
          
  
     }
     return ans;
}

// bottom to top
int mazePath_HVD(int sr, int sc, int er, int ec, vector<string> &ans, string psf)
{
     if(sr==er && sc==ec)
   {
     
       ans.push_back(psf);
       return 1;
   } 
  int count=0;
     vector<vector<int>>dir={{1,1},{1,0},{0,1}};
     vector<string>dirChar={"D","H","V"};


     for(int i=0;i<dir.size();i++)
     {

         int r=sr+dir[i][0];
         int c=sc+dir[i][1];

         if(r<=er && c<=ec)
         {
            count+=mazePath_HVD(r,c,er,ec,ans,psf+dirChar[i]);
            
          
         }  
          
  
     }

     return count;

}

//accha question hai indepth recursion samjh aa gaye ga

// https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/?ref=rp

void display1D(vector<int> &arr)
{
    for (int ele : arr)
        cout << ele << " ";

    cout << endl;
}

void display2D(vector<vector<int>> &arr)
{
    for (vector<int> &a : arr)
        display1D(a);

    cout << endl;
}
int floodFill(int sr, int sc, vector<vector<int>> &jumpMat, vector<vector<int>> &dir, vector<vector<int>> &ans)
{
    int n = jumpMat.size(), m = jumpMat[0].size();
    if (sr == n - 1 && sc == m - 1)
    {
        ans[sr][sc] = 1;
        display2D(ans);
        ans[sr][sc] = 0;
        return 1;
    }

    int jump = jumpMat[sr][sc];
    jumpMat[sr][sc] = 0; // block
    ans[sr][sc] = 1;     // psf

    int count = 0;
    for (int d = 0; d < dir.size(); d++)
    {
        for (int rad = 1; rad <= jump; rad++)
        {
            int r = sr + rad * dir[d][0];
            int c = sc + rad * dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m)
            {
                if (jumpMat[r][c] != 0)
                    count += floodFill(r, c, jumpMat, dir, ans);
            }
            else
                break;
        }
    }

    jumpMat[sr][sc] = jump; // unblock
    ans[sr][sc] = 0;        // psf
    return count;
}

int main()
{
    
  vector<string>ans=mazePath_HVD(0,0,3,3);
  vector<string>ans1;
  int count=mazePath_HVD(0,0,3,3,ans1,"");

   for(string s:ans)
    cout<<s<<" ";

    cout<<endl;

    cout<<"*****"<<endl;
 for(string s:ans1)
    cout<<s<<" ";

    cout<<endl;

    cout<<ans.size()<<" "<<ans1.size()<<" "<<count;

    return 0;
}
