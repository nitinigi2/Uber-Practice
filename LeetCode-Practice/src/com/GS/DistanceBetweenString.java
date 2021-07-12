package src.com.GS;

public class DistanceBetweenString {

    public static double shortestDistance(String document, String word1, String word2) {
        String[] words = document.split(" ");
        double word1Dis = 0, word2Dis = 0;
        double shortestDis = Integer.MAX_VALUE;
        int index = 0;
        for (String word : words) {
            if (word.equals(word1)) {
                word1Dis = index + word1.length() / 2d;
            }

            if (word.equals(word2)) {
                word2Dis = index + word2.length() / 2d;
            }

            if (word1Dis > 0 && word2Dis > 0) {
                double current = Math.abs(word2Dis - word1Dis);
                shortestDis = Math.min(shortestDis, current);
            }
            index += word.length() + 1;
        }
        return shortestDis;
    }

    public static void main(String[] args) {
        String document = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements";
        System.out.println(shortestDistance(document, "is", "a"));
    }
}
