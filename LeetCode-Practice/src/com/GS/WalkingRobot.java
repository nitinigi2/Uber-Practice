package src.com.GS;

public class WalkingRobot {

    private static int[] walk(String s) {
        int x=0, y=0;
        for(char c : s.toCharArray()) { // x=-1, y=1
            switch (c){
                case 'U' :
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                default:
                    break;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        String s = "ULDR";
        int[] pos = walk(s);
        System.out.println(pos[0] + " " + pos[1]);
    }
}
