package davidul.problems.leetcode.solved;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 *
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 */
public class GoatLatin824 {

    public static void main(String[] args) {
        final GoatLatin824 goatLatin824 = new GoatLatin824();
        final String i_speak_goat_latin = goatLatin824.toGoatLatin("I speak Goat Latin");
        System.out.println(i_speak_goat_latin);

        final String s = goatLatin824.toGoatLatin("The quick brown fox jumped over the lazy dog");
        System.out.println(s);
    }

    //private char [] vowels = '';

    public String toGoatLatin(String S) {
        Set<String> vowels = new HashSet<>();
        vowels.addAll(List.of("a","e", "i", "o", "u", "A", "E", "I", "O", "U"));
        final String[] s = S.split(" ");
        StringBuffer as = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length; i++){
            final String firstLetter = s[i].substring(0, 1);
            as = as.append("a");
            if(vowels.contains(firstLetter)){
                sb = sb.append(s[i] + "ma").append(as.toString());
            }else{
                sb = sb.append(s[i].substring(1, s[i].length()) + firstLetter + "ma").append(as.toString());
            }
            sb = sb.append(" ");
        }
        return sb.toString().trim();
    }
}
