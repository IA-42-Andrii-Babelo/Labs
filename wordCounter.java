public class wordCounter {
    public static void main(String[] args) {

        String sentence1 = "The user with the nickname koala757677 this month left 3 times more comments than the  user with the nickname croco181dile181920 4 months ago";
        System.out.println(countWords(sentence1));

        String sentence2 = "sds we2 ujl";
        System.out.println(countWords(sentence2));

        String sentence3 = "";
        try {
            System.out.println(countWords(null));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int countWords(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("речення має бути не нульове");
        }
        String lowercased = sentence.toLowerCase();
        String[] words = lowercased.split("\\s+");
        int count = 0;
        for (String word : words) {
        if (word.matches("[a-zA-Zа-яА-Я]+")){
            count++;
            }
        }
        return count;
    }

}
