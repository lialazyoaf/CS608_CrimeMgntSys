public class hash_table {
        public static void main(String[] args) {
            // Initialize a string
            String s = "geeksforgeeks";

            // Using an array to store the count of each alphabet
            // by mapping the character to an index value

            int[] arr = new int[26];

            // Storing the count
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
            }

            // Search the count of the character
            char ch = 'e';

            // Get count
            System.out.println("The count of " + ch + " is " + arr[ch - 'a']);
        }
    }


