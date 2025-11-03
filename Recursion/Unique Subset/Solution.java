import java.util.*;

class Codechef {
    
    
    public static void getAllUniqueSubsets(List<List<Integer>> result, List<Integer> r, int[] multiset, int index)
    {
        if(index == multiset.length)
        {
            result.add(new ArrayList<>(r));
            return;
        }
        
        r.add(multiset[index]);
        getAllUniqueSubsets(result, r, multiset, index + 1);
        r.remove(r.size() - 1);
        int idx = index + 1;
        while(idx < multiset.length && multiset[idx] == multiset[index])
        {
            idx++;
        }
        getAllUniqueSubsets(result, r, multiset, idx);
    }
    public static List<List<Integer>> uniqueSubsets(int[] multiset) {
        // Write your code here
        Arrays.sort(multiset);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        getAllUniqueSubsets(result, r, multiset, 0);
        return result;
    }

    public static void printSubsets(List<List<Integer>> subsets) {
        for (List<Integer> subset : subsets) {
            System.out.print("[");
            for (int i = 0; i < subset.size(); ++i) {
                System.out.print(subset.get(i));
                if (i < subset.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] multiset = new int[n];
        for (int i = 0; i < n; ++i) {
            multiset[i] = scanner.nextInt();
        }
        List<List<Integer>> result = uniqueSubsets(multiset);
        printSubsets(result);
    }
}