import java.util.Scanner;
//Task1
public class Sort {

    static boolean checkSort(int a[],int n)
    {

            for (int i =0;i <n-1;i++){
                if(a[i] > a[i+1]){
                    return false;
                }
            }

        return true;
    }

    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int n = scanner.nextInt();

        int[] a = new int[n];

        System.out.println("Enter " + n + " integers, separated by spaces:");

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(checkSort(a,n));





    }
}
