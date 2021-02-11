package StringManipulation;

public class Main {
    public static void main(String[] args) {
        String countVowels = "therE ARe 8voWels here!";
        System.out.println(StringUtils.countVowels(countVowels));
        String reverse = "esrever-reverse";
        System.out.println(StringUtils.reverse(reverse));
        String reverseWords = " sentence of Words Reverse ";
        System.out.println(StringUtils.reverseWords(reverseWords));
        System.out.println(StringUtils.reverseWords2(reverseWords));
        System.out.println(StringUtils.rotation("rotation", "ationrot"));
        System.out.println(StringUtils.removeDuplicates(reverseWords));
        String findMostRepeatedCharacter = "the Most Repeated Character is: e";
        System.out.println(StringUtils.findMostRepeatedCharacter(findMostRepeatedCharacter));
        System.out.println(StringUtils.findMostRepeatedCharacterUsingArray(findMostRepeatedCharacter));
        String capitalizeFirstLetter = "capiTalize THE first LetteR of        each word";
        System.out.println(StringUtils.capitalizeFirstLetter(capitalizeFirstLetter));
        System.out.println(StringUtils.areAnagrams("abBcd", "badcb"));
        System.out.println(StringUtils.areAnagramsUsingSorting("aBbcd", "badcb"));
        System.out.println(StringUtils.isPalindrome("AbC dd CBa"));
    }
}
