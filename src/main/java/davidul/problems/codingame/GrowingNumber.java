package davidul.problems.codingame;


/**
 * Find next growing number for given.
 * Growing number for example 123. Next digit is greater then equal to current
 * 1 < 2 < 3
 * Next one: 124.
 */
public class GrowingNumber {
    public static void main(String[] args) {
        String n = "123";
        final char[] chars = n.toCharArray();
        //number as array of digits
        final int[] ints = new int[chars.length];
        for(int i = 0; i < chars.length;i++){
            ints[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        int x [] = growingIndex(ints);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < x.length; i++) {
            sb.append(x[i]);
        }

        System.out.println(sb.toString());
    }

    /**
     * @param n
     * @return
     */
    public static int[] growingIndex(int[] n){
        int x = -1;
        for(int i = 1; i < n.length; i++){
            //find the point where the growingness ends
            if(n[i-1] > n[i]){
                x = i;
                break;
            }
        }

        //the input number itself is growing
        if(x == -1){
            n = add(n, 1, n.length - 1);
            while(!isGrowing(n)) {
                n = add(n, 1, n.length - 1);
            }
        }else {
            //just start at the break, for example 2533. 25 is growing, 53 is not
            for (int i = x; i < n.length; i++) {
                final int delta = n[i - 1] - n[i];
                n = add(n, delta, i);
            }
        }
        return n;
    }

    /**
     * Add amount "val" to the given number on position "pos".
     * @param n array of digits
     * @param val value to add
     * @param pos starting position
     * @return
     */
    public static int[] add(int [] n, int val, int pos){
        final int i = n[pos] + val;
        if(i > 9){
            n[pos] = 0;
            if(pos == 0){
                final int[] ints = new int[n.length + 1];
                System.arraycopy(n,0,ints, 1, n.length);
                ints[0] = 1;
                return ints;
            }

            n = add(n,1,--pos);

        }else{
            n[pos] = i;
            return n;
        }
        return n;
    }

    /**
     * Check if the number is growing.
     * @param n
     * @return
     */
    public static boolean isGrowing(int[] n){
        boolean isGrowing = true;
        for(int i = 1; i < n.length; i++){
            if(n[i-1] > n[i]){
                isGrowing = false;
            }
        }

        return isGrowing;
    }
}
