import java.util.*;
public class dogrusalArama {
public int find(final int[] data, final int key) {
for (int i = 0; i < data.length; ++i) {
if (data[i] > key) {
return -1;
} else if (data[i] == key) {
return i;
}
}
return -1;
}
public static void main(String[] args) {
final int arr[] = new int[8];
System.out.println("8 tamsayı giriniz:");
Scanner input = new Scanner(System.in);
for (int i = 0; i < arr.length; i++) {
arr[i] = input.nextInt();
}
dogrusalArama search = new dogrusalArama();
System.out.print("Aranacak sayıyı giriniz: ");
int num = input.nextInt();
int n = search.find(arr, num);
if ((n >= 0) && (n < arr.length)) {
System.out.println("Aranan sayının indisi: " + n);
} else {
System.out.println("Bulunamadı");
}
}
}
