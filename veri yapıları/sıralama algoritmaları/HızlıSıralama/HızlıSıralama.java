
import java.util.Arrays;
public class HızlıSıralama {
int[] arr = { 2, 17, -4, 42, 9, 26, 11, 3, 5, 28 };
void quickSort(int[] a, int altindis, int üstindis) {
// altindis o adımda sıralanan altdizinin ek küçük indisidir
// üstindis o adımda sıralanan altdizinin ek büyük indisidir
int i = altindis, j = üstindis, h;
// x terimi, mukayesenin yapılacağı mihenk'dir (pivot)
int x = a[(altindis + üstindis) / 2];
// Takas eylemiyle diziyi ayrıştırma
do {
while (a[i] < x)
i++;
while (a[j] > x)
j--;
if (i <= j) {
h = a[i];
a[i] = a[j];
a[j] = h;
i++;
j--;
}
} while (i <= j);
// yinelge (recursion)
if (altindis < j)
quickSort(a, altindis, j);
if (i < üstindis)
quickSort(a, i, üstindis);
}
public static void main(String[] args) {
HızlıSıralama qs = new HızlıSıralama();
System.out.println("Sıralamadan önce: ");
System.out.println(Arrays.toString(qs.arr));
qs.quickSort(qs.arr, 0, 9);
System.out.println("Sıralamadan sonra:");
System.out.println(Arrays.toString(qs.arr));
}
}
