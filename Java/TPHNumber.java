import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Random;

public class TPHNumber {
    public static void main(String[] args) {
        long timeStart = System.nanoTime();
        Utility.FastReader fr = new Utility.FastReader();
        Solver solver = new Solver(fr);
        int t = 1;
        while (t-- > 0) {
            solver.solve();
        }
        long timeEnd = System.nanoTime();
        System.out.println("Completed in :" + ((double) (timeEnd - timeStart) / 1000000) + " miliseconds");
    }

    static class Solver {
        Utility.FastReader fr;

        public Solver(Utility.FastReader fr) {
            this.fr = fr;
        }

        static boolean pentagonalExists(long num){
            for(long i=2; i*i <= num; ++i){
                if(num%i == 0){
                    if((i*(3*i-1))/2 == num || ((num/i)*(3*(num/i)-1))/2 == num){
                        return true;
                    }
                }
            }
            return false;
        }

        static boolean hexagonalExists(long num){
            for(long i=2; i*i <= num; ++i){
                if(num%i == 0){
                    if(i*(2*i-1) == num || (num/i)*(2*(num/i)-1) == num){
                        return true;
                    }
                }
            }
            return false;
        }
        void solve() {
            int cnt = 0;
            long i = 1;
            while(true){
                long t = (i*(i+1))/2;
                if(pentagonalExists(t) && hexagonalExists(t)){
                    cnt++;
                    System.out.println(t);
                }
                if(cnt == 2){
                    break;
                }
                i++;
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
