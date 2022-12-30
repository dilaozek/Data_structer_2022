import java.util.*;
class BinarySearch{  
    public static void binarySearch(int arr[], int first, int last, int key){  
      int mid = (first + last)/2;  
      while( first <= last ){  
         if ( arr[mid] < key ){  
           first = mid + 1;     
         }else if ( arr[mid] == key ){  
           System.out.println("Element dizide bulunur. ");  
           break;  
         }else{  
            last = mid - 1;  
         }  
         mid = (first + last)/2;  
      }  
      if ( first > last ){  
         System.out.println("Element dizide bulunmaz!");  
      }  
    }  
    public static void main(String args[]){  
           int arr[] = {10,20,30,40,50};  
           int last=arr.length-1;  
           
           Scanner girdi = new Scanner(System.in);
           System.out.print("sayi giriniz: ");
           int key = girdi.nextInt();  
          binarySearch(arr,0,last,key);  
    }  
   }  
