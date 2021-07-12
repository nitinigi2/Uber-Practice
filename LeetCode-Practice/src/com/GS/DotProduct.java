package src.com.GS;

public class DotProduct {
    public static long dotProduct( int[] array1, int array2[] ) {
        return (array1[0]*array2[0]) + (array1[1]*array2[1]);
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2};
        int[] array2 = {2, 3};

        long ans = dotProduct(array1, array2);
        System.out.println(ans);
    }
}
