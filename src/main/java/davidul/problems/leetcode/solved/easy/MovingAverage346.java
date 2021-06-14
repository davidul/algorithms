package davidul.problems.leetcode.solved.easy;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Implement the MovingAverage class:
 *
 * MovingAverage(int size) Initializes the object with the size of the window size.
 * double next(int val) Returns the moving average of the last size values of the stream.
 *
 * Input
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output
 * [null, 1.0, 5.5, 4.66667, 6.0]
 *
 * Explanation
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // return 1.0 = 1 / 1
 * movingAverage.next(10); // return 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 */
public class MovingAverage346 {
    public static void main(String[] args) {
        final MovingAverage346 movingAverage346 = new MovingAverage346(3);
        System.out.println(movingAverage346.next(1));
        System.out.println(movingAverage346.next(10));
        System.out.println(movingAverage346.next(3));
        System.out.println(movingAverage346.next(5));

    }

    private double[] queue;
    private int pointer = 0;
    private int itemsCount = 0;

    public MovingAverage346(int size) {
        this.queue = new double[size];
    }

    public double next(int val) {
        if(pointer == queue.length){
            pointer = 0;
        }
        this.queue[pointer] = val;
        pointer++;
        if(itemsCount < queue.length) itemsCount++;
        double sum = 0;
        for(int i = 0; i < itemsCount; i++){
            sum += this.queue[i];
        }
        return (double) sum/ itemsCount;
    }
}
