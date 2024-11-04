import java.util.Date;

public class Question1 {
    public static long timeAlgorithmA(int testValue){
        Date timeStart = new Date();
        int sum = 0;
        for(int i = 1; i < testValue; i++){
            sum += i;
        }
        Date timeStop = new Date();
        return timeStop.getTime() - timeStart.getTime();
    }

    public static long timeAlgorithmB(int testValue){
        Date timeStart = new Date();
        int sum = 0;
        for (int i = 1; i < testValue; i++){
            for (int j = 1; j < i; j++){
                sum += 1;
            }
        }
        Date timeStop = new Date();
        return timeStop.getTime() - timeStart.getTime();
    }

    public static long timeAlgorithmC(int testValue){
        Date timeStart = new Date();
        int sum = testValue * (testValue + 1) / 2;
        Date timeStop = new Date();
        return timeStop.getTime() - timeStart.getTime();
    }

    public static void main(String[] args) {
        int[] testValues = {1, 10, 100, 1000, 10000, 100000};
        System.out.printf("|%-17s | %-17s | %-17s | %-17s |\n", "Test Values", "Time Algorithm A", "Time Algorithm B", "Time Algorithm C");
        for (int n : testValues){
            long timeA = timeAlgorithmA(n);
            long timeB = timeAlgorithmB(n);
            long timeC = timeAlgorithmC(n);
            System.out.printf("|%-17s | %-17s | %-17s | %-17s |\n", n, timeA, timeB, timeC);
        }
    }
}
