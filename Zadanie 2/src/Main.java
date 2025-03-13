import java.util.*;

 class ArrayOperations {

    // Zadanie 1
    public static int[] filterEvenIndexOddValue(int[] array) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i += 2) {
            if (array[i] % 2 != 0) {
                result.add(array[i]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    // Zadanie 2

    public static int findDominant(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = array.length;
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > n / 2) {
                return num;
            }
        }
        return -1;
    }

    // Zadanie 3
    public static int[] rotateArray(int[] array, int positions) {
        int n = array.length;
        if (n == 0) return array;
        positions = positions % n; // Zapewnia, że nie wykonujemy niepotrzebnych rotacji
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + positions) % n] = array[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        // Testowanie zadania 1
        System.out.println(Arrays.toString(filterEvenIndexOddValue(new int[]{1, 2, 3, 4, 5, 6}))); // [1, 5]
        System.out.println(Arrays.toString(filterEvenIndexOddValue(new int[]{2, 3, 4, 5, 6, 7}))); // []
        System.out.println(Arrays.toString(filterEvenIndexOddValue(new int[]{7, 8, 9, 10, 11}))); // [7, 9, 11]

        // Testowanie zadania 2
        System.out.println(findDominant(new int[]{3, 3, 3, 2, 2})); // 3
        System.out.println(findDominant(new int[]{1, 2, 3, 4})); // -1
        System.out.println(findDominant(new int[]{5, 5, 5, 5, 1})); // 5

        // Testowanie zadania 3
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5}, 2))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3}, 3))); // [1, 2, 3]
    }
}
