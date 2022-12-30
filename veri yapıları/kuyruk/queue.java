import java.util.*;
class Queue { 
  private static int front, rear, capacity; 
  private static int queue[]; 
 
  Queue(int size) { 
      front = rear = 0; 
      capacity = size; 
      queue = new int[capacity]; 
  } 
 
  // Kuyruğa bir element ekler
  static void queueEnqueue(int item)  { 
    // Kuyruk dolumu kontrol eder
    if (capacity == rear) { 
        System.out.printf("\nQueue Dolu\n"); 
        return; 
    } 
 
    // Kuyruğun sonuna eleman ekler
    else { 
        queue[rear] = item; 
        rear++; 
    } 
    return; 
  } 
 
  //Kuyruktan eleman silir
  static void queueDequeue()  { 
    // check if queue is empty 
    if (front == rear) { 
        System.out.printf("\nQueue boş\n"); 
        return; 
    } 
 
    // elemanları arkaya bir yer sağa kaydır
    else { 
        for (int i = 0; i < rear - 1; i++) { 
            queue[i] = queue[i + 1]; 
        } 
 
   
  //queue[rear]  0 yap
        if (rear < capacity) 
            queue[rear] = 0; 
 
        // azalt rear 
        rear--; 
    } 
    return; 
  } 
 
  // Queue elementlerini göster
  static void queueDisplay() 
  { 
    int i; 
    if (front == rear) { 
        System.out.printf("Queue Boş\n"); 
        return; 
    } 
 
    // önden arkaya hareket ettirin ve öğeleri yazdırın
    for (i = front; i < rear; i++) { 
        System.out.printf(" %d = ", queue[i]); 
    } 
    return; 
  } 
 
  // önden queue yazdır
  static void queueFront() 
  { 
      if (front == rear) { 
          System.out.printf("Queue boş\n"); 
          return; 
      } 
      System.out.printf("\n Queue başındaki elementi yazdır: %d", queue[front]); 
      return; 
  } 
} 

 
class Main {
  public static void main(String[] args) {
    
    // Create a queue of capacity 4 
    Queue q = new Queue(4); 
 
    System.out.println("Queue Başlat:");
   // Queue elementlerini yazdır
    q.queueDisplay(); 
 
    // sıraya eleman ekleme
    q.queueEnqueue(10); 
    q.queueEnqueue(30); 
    q.queueEnqueue(50); 
    q.queueEnqueue(70);
   


 
    // Elementleri yazdır
    System.out.println("Queue ekleme yapıldıktan sonra:");
    q.queueDisplay(); 
 
    // queue başındaki elementi yazdır
    q.queueFront(); 
     
    // queue element ekle
    q.queueEnqueue(90); 
 
    // queue elementlerini yazdır
    q.queueDisplay(); 
 
    q.queueDequeue(); 
    q.queueDequeue(); 
    System.out.printf("\nİki kuyruktan çıkarma işleminden sonra sıra:"); 
 
    // Queue elementlerini yazdır
    q.queueDisplay(); 
 
    // queue başındaki elementi yazdır
    q.queueFront(); 
      
  }
}