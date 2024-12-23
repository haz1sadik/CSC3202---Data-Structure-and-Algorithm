public class Question2 {
    public static void main(String[] args) {
        long startTime, endTime;

        for (int n = 1; n <= 1000000; n++) {
            int sumA = 0;
            int sumB = 0;

            startTime = System.nanoTime();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= 1000; j++) {
                    sumA += j;
                }
            }
            endTime = System.nanoTime();
            long timeA = endTime - startTime;

            startTime = System.nanoTime();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sumB += j;
                }
            }
            endTime = System.nanoTime();
            long timeB = endTime - startTime;

            System.out.println("n = " + n + ": Time A = " + timeA + " ns, Time B = " + timeB + " ns");

            if (timeA <= timeB) {
                System.out.println("Loop A is faster than Loop B at n = " + n);
                break;
            }
        }
    }
}
