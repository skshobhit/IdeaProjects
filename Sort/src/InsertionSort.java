public class InsertionSort {
        void sort(int arr[])
        {
            int n = arr.length;
            for (int i = 1; i < n; ++i) {
                int key = arr[i];
                int j = i - 1;


                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        }

        static void printArray(int arr[])
        {
            int n = arr.length;
            for (int i = 0; i < n; ++i)
                System.out.print(arr[i] + " ");

            System.out.println();
        }

        public static void main(String args[])
        {
            int arr[] = { 12, 11, 13, 5, 6, 21,15,62,23,10,44, 66, 14,77,22,34,7,8,21,88,32,33, 43,15 };

            InsertionSort ob = new InsertionSort();
            ob.sort(arr);

            printArray(arr);
            System.out.println(System.nanoTime());
            //System.out.println(arr.length);
        }
}

