package Recursion;

public class Nqueen {
    
// tnb : total no of boxes, totalNumberQueen : total no queens
public static int queenCombination(int totalNumberBox, int totalNumberQueen, int currentBoxNumber, int currentQueenNumber, String ans)
{
   if(totalNumberQueen==0)
   {
    System.out.println(ans);
    return 1;
   }
    int count=0;
     
      for(int i=currentBoxNumber;i<totalNumberBox;i++)
      {
        count+=queenCombination(totalNumberBox, totalNumberQueen-1, currentBoxNumber+1, currentQueenNumber+1, ans+currentBoxNumber+i+"q"+currentQueenNumber+" ");
      }
    return count;
}

public static int queenPermutation(boolean[] boxes, int totalNumberQueen, int currentBoxNumber, int currentQueenNumber, String ans)
{
         if(totalNumberQueen==0)
         {
            System.out.println(ans);
            return 1;
         }

    int count=0;

    for(int i=currentBoxNumber;i<boxes.length;i++)
    {
        if(boxes[i]==false)
        {

           boxes[i]=true;
        count+=queenPermutation(boxes, totalNumberQueen-1,0, currentQueenNumber+1, ans+currentBoxNumber+i+"q"+currentQueenNumber+" ");
        boxes[i]=false;
        }
    }

    return count;
}

int queenCombination2D(boolean [][] board, int totalNumberQueen, int currentBoxNumber, String ans)
{
    int count=0;


     int n=board.length;
     int m=board[0].length;

     for(int i=currentBoxNumber;i<n*m;i++)
     {

        int r=i/m;
        int c=i%m;

        count+=queenCombination2D(board, totalNumberQueen-1,i+1, ans+"("+r+","+c+")"+" ");
     }

    return count;
}

public static int queenPermutation2D(boolean [][] board, int totalNumberQueen, int currentBoxNumber, String ans)
{
    if (totalNumberQueen == 0)
    {
        System.out.println(ans);
        return 1;
    }

    int count = 0, n = board.length, m = board[0].length;
    for (int i = currentBoxNumber; i < n * m; i++)
    {
        int r = i / m;
        int c = i % m;
        if (!board[r][c])
        {
            board[r][c] = true;
            count += queenPermutation2D(board, totalNumberQueen - 1, 0, ans + "(" +r + "," + c + ") ");
            board[r][c] = false;
        }
    }

    return count;
}
    public static void main(String[] args) {
        
    }
}
