package davidul.utils.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort.sort(new int[]{3,2,1,2});
        BubbleSort.sort1(new int[]{3,2,1,0});
    }

    public static void sort(int [] a){
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    swap = true;
                }
            }
        }
        System.out.println("");;
    }

    public static void sort1(int [] a){
        int count = 0;
        for(int i = 0; i < a.length - 1; i++){
            for(int j = 0; j < a.length - 1; j++){
                count++;
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }

        System.out.println(count);
    }
}
