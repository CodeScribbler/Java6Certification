package _04_06;

public class FlowControl {

    public static void main(String[] args) {

        try {

            int[][] ia = { {1,2,3} , {2,4,6}, {1,3,0,5}, {10,20} };

            firstFor: for(int i = 0; i < ia.length; i++) {
                secoundFor: for (int j = 0; j < ia[i].length; j++) {

                    if(ia[i][j] % 2 == 0) continue;
                    if(ia[i][j] == 0) break;
                    if(ia[i][j] >= 10) return;
                    System.out.print(ia[i][j] + " ");

                }
                System.out.println();
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
