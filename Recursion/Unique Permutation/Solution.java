import java.util.*;

class Codechef {
    
    public static void getUniquePermutations(List<List<Integer>> result, ArrayList<Integer> r, HashMap<Integer, Integer> frequency, int n)
    {
        if(r.size() == n)
        {
            result.add((new ArrayList<>(r)));
            return;
        }
        
        
        
        
        for(int currentElement : frequency.keySet())
        {
            int frequencyOfCurrentElement = frequency.get(currentElement);
            if(frequencyOfCurrentElement > 0)
            {
                r.add(currentElement);
                frequency.put(currentElement, frequencyOfCurrentElement-1);
                getUniquePermutations(result, r, frequency, n);
                r.remove(r.size()-1);
                frequency.put(currentElement, frequencyOfCurrentElement);
            }
        }
    }

    public static List<List<Integer>> uniquePermutations(List<Integer> multiset) {
        // Write your code here
        
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int x : multiset)
        {
            frequency.put(x, frequency.getOrDefault(x, 0) + 1);
        }
        getUniquePermutations(result, r, frequency, multiset.size());
        
        return result;
        
        
    }

    public static void printPermutations(List<List<Integer>> permutations) {
        for (List<Integer> permutation : permutations) {
            System.out.print("[");
            for (int i = 0; i < permutation.size(); ++i) {
                System.out.print(permutation.get(i));
                if (i < permutation.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> multiset = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            multiset.add(scanner.nextInt());
        }
        List<List<Integer>> result = uniquePermutations(multiset);
        printPermutations(result);
    }
}