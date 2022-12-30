class Stack {

  // yığının öğelerini sakla
  private int arr[];
  // yığının üstünü temsil eder
  private int top;
  // yığının toplam kapasitesi
  private int capacity;

  // Yığın oluşturma
  Stack(int size) {
    // diziyi başlat
    // yığın değişkenlerini başlat
    arr = new int[size];
    capacity = size;
    top = -1;
  }

 // elemanları yığının en üstüne it
  public void push(int x) {
    if (isFull()) {
      System.out.println("Stack OverFlow");

      // programı sonlandırır
      System.exit(1);
    }

    // elemanı yığının üstüne ekle
    System.out.println("ekle " + x);
    arr[++top] = x;
  }

 // elemanları yığının tepesinden çıkar
  public int pop() {

// yığın boşsa
    // açılacak öğe yok
    if (isEmpty()) {
      System.out.println("STACK EMPTY");
      // programı sonlandırır
      System.exit(1);
    }

   // yığının tepesinden eleman çıkar
    return arr[top--];
  }

  // yığının boyutunu döndürür
  public int getSize() {
    return top + 1;
  }

 // yığının boş olup olmadığını kontrol et
  public Boolean isEmpty() {
    return top == -1;
  }

  // yığının dolu olup olmadığını kontrol et
  public Boolean isFull() {
    return top == capacity - 1;
  }

 // yığının öğelerini göster
  public void printStack() {
    for (int i = 0; i <= top; i++) {
      System.out.print(arr[i] + ", ");
    }
  }

  public static void main(String[] args) {
    Stack yigin = new Stack(5);

    yigin.push(1);
    yigin.push(2);
    yigin.push(3);

    System.out.print("Stack: ");
    yigin.printStack();

   
  // elemanı yığından kaldır
    yigin.pop();
    System.out.println("\n en son hali ");
    yigin.printStack();

  }
}