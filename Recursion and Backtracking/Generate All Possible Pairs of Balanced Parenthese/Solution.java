import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Codechef {
    
    
    public static void getAllParenthesis(List<String> result, StringBuilder r, int n, int openCount, int closedCount)
    {
        
        if(r.length() == 2*n)
        {
            result.add(r.toString());
            return;
        }
        
        
        if(openCount< n)
        {
            r.append('(');
            getAllParenthesis(result, r, n ,openCount + 1, closedCount);
            r.deleteCharAt(r.length()-1);
            
        }
        
        if(openCount > closedCount)
        {
            r.append(')');
            getAllParenthesis(result, r, n ,openCount, closedCount + 1);
            r.deleteCharAt(r.length() - 1);
        }
        
        
        
        
        
        
    }
   
    public static List<String> generateParenthesis(int n) {
       // Complete the method
       List<String> result = new ArrayList<>();
       StringBuilder r = new StringBuilder();
       getAllParenthesis(result, r, n , n);
       return result;
       
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> result = generateParenthesis(n);
        Collections.sort(result); // Sorting the result list
        for(String s : result) {
            System.out.println(s);
        }
    }
}