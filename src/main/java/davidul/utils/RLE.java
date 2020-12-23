package davidul.utils;

public class RLE {

    // 1 1 2 2
    public static int[] rle(int [] t){
        //worst case, all unique
        final int[] encodedArray = new int[t.length * 2];
        int totalCounter = 0;
        for(int i = 0; i < t.length; i++){
            final int count = count(t, i);
            encodedArray[totalCounter] = count;
            encodedArray[totalCounter+1] = t[i];
            if(count > 1) i = i + (count - 1);
            totalCounter +=2;
        }
        int [] kk = new int[totalCounter];
        System.arraycopy(encodedArray, 0, kk, 0, totalCounter);
        return kk;
    }

    public static int count(int[] t, int startIndex){
        int counter = 1;
        if(startIndex == t.length - 1)
            return 1;
        for(int i = startIndex; i < t.length; i++){
            if(i == t.length - 1)
                break;
            if(t[i] == t[i+1]){
                counter++;
            }else {
                break;
            }
        }
        return counter;
    }

}
