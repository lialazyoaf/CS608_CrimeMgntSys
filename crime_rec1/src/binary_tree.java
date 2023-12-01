public class binary_tree {
        public static void binarySearch(int arr[], int first_val, int last_val, int key){
            int mid_val = (first_val + last_val)/2;
            while( first_val <= last_val ){
                if ( arr[mid_val] < key ){
                    first_val = mid_val + 1;
                }else if ( arr[mid_val] == key ){
                    System.out.println("Element is found at index: " + mid_val);
                    break;
                }else{
                    last_val = mid_val - 1;
                }
                mid_val = (first_val + last_val)/2;
            }
            if ( first_val > last_val ){
                System.out.println("Element is not found!");
            }
        }
        public static void main(String args[]) {
            int arr[] = {10, 20, 30, 40, 50};
            int key = 30;
            int last_val = arr.length - 1;
            binarySearch(arr, 0, last_val, key);
        }

}
