import java.util.Scanner;

public class Canvas {
    public static void main(String[] args) {

        char [][] a = {{'.', '*', '.'}, {'*', '*', '*'}, {'*', '.', '*'}};
        char [][] e = {{'*', '*', '*'}, {'*', '*', '.'}, {'*', '*', '*'}};
        char [][] i = {{'*', '*', '*'}, {'.', '*', '.'}, {'*', '*', '*'}};
        char [][] o = {{'*', '*', '*'}, {'*', '.', '*'}, {'*', '*', '*'}};
        char [][] u = {{'*', '.', '*'}, {'*', '.', '*'}, {'*', '*', '*'}};


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        char[][] input = new char[3][n*3];
        for(int arr=0; arr<3; arr++) {
            for (int inp = 0; inp < n; inp++) {
                input[arr][inp] = scanner.next().charAt(0);
            }
        }


        String res = "";

        for (int m = 0; m < n-2; m++) {
            if(input[0][m] == '#')
                res = res.concat("*");

            if(input[0][m] == '.' && input[1][m] == '.' && input[2][m] == '.')
                continue;

            if(input[0][m] == a[0][0] && input[0][m+1] == a[0][1] && input[0][m+2] == a[0][2] &&
                    input[1][m] == a[1][0] && input[1][m+1] == a[1][1] && input[1][m+2] == a[1][2] &&
                    input[2][m] == a[2][0] && input[2][m+1] == a[2][1] && input[2][m+2] == a[2][2]){
                res = res.concat("A");
                m+=2;
            }

            else if(input[0][m] == e[0][0] && input[0][m+1] == e[0][1] && input[0][m+2] == e[0][2] &&
                    input[1][m] == e[1][0] && input[1][m+1] == e[1][1] && input[1][m+2] == e[1][2] &&
                    input[2][m] == e[2][0] && input[2][m+1] == e[2][1] && input[2][m+2] == e[2][2]){
                res = res.concat("E");
                m+=2;
            }

            else if(input[0][m] == i[0][0] && input[0][m+1] == i[0][1] && input[0][m+2] == i[0][2] &&
                    input[1][m] == i[1][0] && input[1][m+1] == i[1][1] && input[1][m+2] == i[1][2] &&
                    input[2][m] == i[2][0] && input[2][m+1] == i[2][1] && input[2][m+2] == i[2][2]){
                res = res.concat("I");
                m+=2;
            }

            else if(input[0][m] == o[0][0] && input[0][m+1] == o[0][1] && input[0][m+2] == o[0][2] &&
                    input[1][m] == o[1][0] && input[1][m+1] == o[1][1] && input[1][m+2] == o[1][2] &&
                    input[2][m] == o[2][0] && input[2][m+1] == o[2][1] && input[2][m+2] == o[2][2]){
                res = res.concat("O");
                m+=2;
            }

            else if(input[0][m] == u[0][0] && input[0][m+1] == u[0][1] && input[0][m+2] == u[0][2] &&
                    input[1][m] == u[1][0] && input[1][m+1] == u[1][1] && input[1][m+2] == u[1][2] &&
                    input[2][m] == u[2][0] && input[2][m+1] == u[2][1] && input[2][m+2] == u[2][2]){
                res = res.concat("U");
                m+=2;

            }
        }

        System.out.print(res);

    }
}
