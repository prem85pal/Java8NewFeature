package InterviewQOnArray;


import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String args[]) {

        int[] test = new int[]{1, 1, 2, 2, 2, 3, 4, 5};

        System.out.println(Arrays.toString(removeDuplicates(test)));
    }

    public static int[] removeDuplicates(int[] numbersWithDuplicates) {

        // Sorting array to bring duplicates together
        Arrays.sort(numbersWithDuplicates);

        int[] result = new int[numbersWithDuplicates.length];
        int previous = numbersWithDuplicates[0];
        result[0] = previous;

        for (int i = 1; i < numbersWithDuplicates.length; i++) {
            int ch = numbersWithDuplicates[i];

            if (previous != ch) {
                result[i] = ch;
            }
            previous = ch;
        }
        return result;
    }
}
