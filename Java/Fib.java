import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fib {
    static int MAX = 4000000;
    public static void main(String[] args) {
        Utility.FastReader fr = new Utility.FastReader();
        int f = 1;
        int s = 1;
        int t;
        long sum = 0;
        int cnt = 0;
        while(f <= MAX){
            t = f + s;
            if(cnt%3 == 0){
                System.out.println(t);
                sum += t;
            }
            cnt++;
            f = s;
            s = t;
        }
        System.out.println(sum);
    }

    static class Utility {
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

        public static void main(String[] args) {
            FastReader s = new FastReader();
            int n = s.nextInt();
            int k = s.nextInt();
            int count = 0;
            while (n-- > 0) {
                int x = s.nextInt();
                if (x % k == 0)
                    count++;
            }
            System.out.println(count);
        }
    }
}
