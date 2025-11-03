import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Codechef {
    static void allPossibleSubsets(List<Integer> arr, int curIndex, List<Integer> curSubset, List<List<Integer>> allSubsets) {
        //Write your code here
        if(curIndex == arr.size())
        {
            allSubsets.add(new ArrayList<>(curSubset));
            return;
        }
        
        // curSubset.add(arr.get(curIndex)); // Including the element
        // allPossibleSubsets(arr, curIndex+1, curSubset, allSubsets);
        // curSubset.remove(curSubset.size() - 1);  // Excluding the element
        // allPossibleSubsets(arr, curIndex + 1, curSubset, allSubsets);
        
    allPossibleSubsets(arr, curIndex + 1, curSubset, allSubsets);
    curSubset.add(arr.get(curIndex));
    allPossibleSubsets(arr, curIndex + 1, curSubset, allSubsets);
    curSubset.remove(curSubset.size() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            arr.add(scanner.nextInt());
        }
        List<Integer> curSubset = new ArrayList<>();
        List<List<Integer>> allSubsets = new ArrayList<>();
        allPossibleSubsets(arr, 0, curSubset, allSubsets);
        Collections.sort(allSubsets, (a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int cmp = Integer.compare(a.get(i), b.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(a.size(), b.size());
        });
        for (List<Integer> subset : allSubsets) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
