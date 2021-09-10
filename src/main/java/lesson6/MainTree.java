package lesson6;

import java.util.ArrayList;
import java.util.List;

public class MainTree {
    public static void main (String[] args) {
        treesTest(createTrees(20, 4));

    }

    public static int randomNumber (int min, int max) {
        int[] sign = new int[]{-1, 1};
        Double signValue = Math.random();
        if (signValue > 0.5d) {
            return (int) (Math.random() * min) * sign[0];
        } else {
            return (int) (Math.random() * max) * sign[1];
        }
    }

    public static List<TreeImpl> createTrees (int count, int level) {
        List<TreeImpl> trees = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>();
            Integer size = 0;
            do {
                Integer s = randomNumber(0, 50);
                if (tree.add(s) == true) {
                    size++;
                }
            } while (size < calcElementTree(level));
            trees.add(tree);
        }
        return trees;
    }

    public static void treesTest (List<TreeImpl> trees) {
        Integer countBalanced = 0;
        Integer countNotBalanced = 0;
        for (int i = 0; i < trees.size(); i++) {
            if (trees.get(i).testTreeIsBalance() == 1) {
                countBalanced++;
            }
            countNotBalanced++;
        }
        System.out.println("Trees is balanced " + countBalanced / trees.size()*100 + "%");
        System.out.println("Trees is not  balanced " + countNotBalanced / trees.size()*100 + "%");
    }


    private static int calcElementTree (int level) {
        return (int) Math.pow(2, level) - 1;
    }
}
