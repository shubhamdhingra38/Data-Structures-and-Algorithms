import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) {
        long timeStart = System.nanoTime();
        Utility.FastReader fr = new Utility.FastReader();
        Solver solver = new Solver(fr);
        int t = 1;
        while (t-- > 0) {
            solver.solve();
        }
        long timeEnd = System.nanoTime();
//        System.out.println("Completed in :" + ((double) (timeEnd - timeStart) / 1000000) + " miliseconds");
    }

    static class Solver {
        Utility.FastReader fr;

        public Solver(Utility.FastReader fr) {
            this.fr = fr;
        }

        void solve() {
            char[][] mat = new char[9][9];
            for(int i=0; i<9; ++i){
                for(int k=0; k<3; ++k) {
                    String x = fr.next();
                    for (int j = 0; j < 3; ++j)
                        mat[i][3*k+j] = x.charAt(j);
                }
            }
//            for(char[] c: mat){
//                System.out.println(Arrays.toString(c));
//            }
            int x, y;
            x=fr.nextInt()-1;
            y=fr.nextInt()-1;
            int r, c;
            r=3*(x%3);
            c=3*(y%3);
            boolean flag = false;
            for(int i=r; i<r+3; ++i){
                for(int j=c; j<c+3; ++j){
                    if(mat[i][j]=='.'){
                        mat[i][j] = '!';
                        flag = true;
                    }
                }
            }
            if(!flag){
                for(int i=0; i<9; ++i){
                    for(int j=0; j<9; ++j)
                        if(mat[i][j]=='.') mat[i][j]='!';
                }
            }
//            System.out.println();
            int ccnt=0;
            for(char[] arr: mat){
                ccnt++;
                int cnt=0;
                for(char ch: arr){
                    cnt++;
                    System.out.print(ch);
                    if(cnt%3==0)
                        System.out.print(" ");
                }
                if(ccnt%3==0)
                    System.out.println();
                System.out.println();
            }
        }
    }

    static class Utility {
        static void shuffleArray(long[] arr) {
            int n = arr.length;
            Random rnd = new Random();
            for (int i = 0; i < n; ++i) {
                long tmp = arr[i];
                int randomPos = i + rnd.nextInt(n - i);
                arr[i] = arr[randomPos];
                arr[randomPos] = tmp;
            }
        }

        static void shuffleArray(int[] arr) {
            int n = arr.length;
            Random rnd = new Random();
            for (int i = 0; i < n; ++i) {
                int tmp = arr[i];
                int randomPos = i + rnd.nextInt(n - i);
                arr[i] = arr[randomPos];
                arr[randomPos] = tmp;
            }
        }

        static int gcd(int a, int b) {
            if (b == 0)
                return a;
            return gcd(b, a % b);
        }

        static long gcd(long a, long b) {
            if (b == 0)
                return a;
            return gcd(b, a % b);
        }

        static class FastReader {
            BufferedReader br;
            StringTokenizer st;

            public FastReader() {
                br = new BufferedReader(new
                        InputStreamReader(System.in));
            }

            String next() {
                while (st == null || !st.hasMoreElements()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt() {
                return Integer.parseInt(next());
            }

            long nextLong() {
                return Long.parseLong(next());
            }

            double nextDouble() {
                return Double.parseDouble(next());
            }

            String nextLine() {
                String str = "";
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }
        }
    }
}
