package davidul.problems.leetcode.solved;

/*
There is a special keyboard with all keys in a single row.

Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25).
Initially, your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.

You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
 */
public class SingleRowKeyboard1165 {
    public static void main(String[] args) {
        String keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba";
        final SingleRowKeyboard1165 singleRowKeyboard1165 = new SingleRowKeyboard1165();
        System.out.println(singleRowKeyboard1165.calculateTime(keyboard, word));

        keyboard = "pqrstuvwxyzabcdefghijklmno";
        word = "leetcode";
        System.out.println(singleRowKeyboard1165.calculateTime(keyboard, word));
    }

    public int calculateTime(String keyboard, String word) {
        final char[] keyboardArray = keyboard.toCharArray();
        final char[] wordArray = word.toCharArray();
        int start = 0;
        int move = 0;
        for(int i = 0; i < wordArray.length; i++){
            char w = wordArray[i];
            for(int k = 0; k < keyboardArray.length; k++){
                if(keyboardArray[k] == w){
                    move = move + Math.abs(start - k);
                    start = k;
                }
            }
        }


        return move;
    }

}
