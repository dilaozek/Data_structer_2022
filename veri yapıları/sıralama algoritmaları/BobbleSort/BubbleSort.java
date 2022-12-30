public class BubbleSort {
int sayıDizisi[] = { 12, 93, 6, 27, 0, -42, 567, -2300, -1, 34 };
static void diziYaz(int[] arr) {
for (int i = 0; i < arr.length; i++) {
System.out.print(arr[i] + " ");
}
}
public void bbSort(int[] arr) {
boolean takas = true;
int j = 0;
int yedek;
while (takas) {
takas = false;
j++;
for (int i = 0; i < arr.length - j; i++) {
if (arr[i] > arr[i + 1]) {
yedek = arr[i];
arr[i] = arr[i + 1];
arr[i + 1] = yedek;
takas = true;
}
}
}
}
public static void main(String[] args) {
BubbleSort bbs = new BubbleSort();
System.out.println("\nSıralamadan önceki durum: ");
BubbleSort.diziYaz(bbs.sayıDizisi);
bbs.bbSort(bbs.sayıDizisi);
System.out.println("\n\nSıralamadan sonraki durum: ");
bbs.bbSort(bbs.sayıDizisi);
BubbleSort.diziYaz(bbs.sayıDizisi);
}
}