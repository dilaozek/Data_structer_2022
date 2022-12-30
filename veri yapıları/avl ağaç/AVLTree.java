import java.util.Scanner;  
  
// AVL Ağaç Düğümünün yapısını tasarlamak için Node sınıfı oluşturun
class Node  
{      
    int element;  
    int h;  //boy için  
    Node leftChild;  
    Node rightChild;  
      
    //boş düğüm oluşturmak için varsayılan kurucu 
    public Node()  
    {  
        leftChild = null;  
        rightChild = null;  
        element = 0;  
        h = 0;  
    }  
    // parametreli yapıcı 
    public Node(int element)  
    {  
        leftChild = null;  
        rightChild = null;  
        this.element = element;  
        h = 0;  
    }       
}  
  
// AVL Ağacı oluşturmak için ConstructAVLTree sınıfı yarat 
class ConstructAVLTree  
{  
    private Node rootNode;       
  
    //kurucu, rootNode'a boş değer ayarlamak için 
    public ConstructAVLTree()  
    {  
        rootNode = null;  
    }  
      
    //AVL Ağacını boş yapmak için removeAll() yöntemini oluştur 
    public void removeAll()  
    {  
        rootNode = null;  
    }  
      
    // AVL Ağacının boş olup olmadığını kontrol etmek için checkEmpty() yöntemini oluşturun  
    public boolean checkEmpty()  
    {  
        if(rootNode == null)  
            return true;  
        else   
            return false;  
    }  
      
    // AVL Ağacına öğe eklemek için insertElement() öğesini oluşturun 
    public void insertElement(int element)  
    {  
        rootNode = insertElement(element, rootNode);  
    }  
      
    //AVL Ağacının yüksekliğini elde etmek için getHeight() yöntemini oluşturun  
    private int getHeight(Node node )  
    {  
        return node == null ? -1 : node.h;  
    }  
      
    //sol ve sağ düğümden maksimum yüksekliği elde etmek için maxNode() yöntemini oluşturun  
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight)  
    {  
    return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;  
    }  
      
      
    //AVL Ağacına yinelemeli olarak veri eklemek için insertElement() yöntemini oluşturun   
    private Node insertElement(int element, Node node)  
    {  
        //düğümün boş olup olmadığını kontrol et  
        if (node == null)  
            node = new Node(element);  
        //verilen elemanın kök düğümün elemanından küçük olması durumunda bir düğüm ekle 
        else if (element < node.element)  
        {  
            node.leftChild = insertElement( element, node.leftChild );  
            if( getHeight( node.leftChild ) - getHeight( node.rightChild ) == 2 )  
                if( element < node.leftChild.element )  
                    node = rotateWithLeftChild( node );  
                else  
                    node = doubleWithLeftChild( node );  
        }  
        else if( element > node.element )  
        {  
            node.rightChild = insertElement( element, node.rightChild );  
            if( getHeight( node.rightChild ) - getHeight( node.leftChild ) == 2 )  
                if( element > node.rightChild.element)  
                    node = rotateWithRightChild( node );  
                else  
                    node = doubleWithRightChild( node );  
        }  
        else  
            ;  // eleman ağaçta zaten mevcutsa hiçbir şey yapmayacağız  
        node.h = getMaxHeight( getHeight( node.leftChild ), getHeight( node.rightChild ) ) + 1;  
          
        return node;  
          
    }  
      
    // sol çocuk ile ikili ağaç düğümünün dönüşünü gerçekleştirmek için rotateWithLeftChild() yöntemi oluşturuluyor       
    private Node rotateWithLeftChild(Node node2)  
    {  
        Node node1 = node2.leftChild;  
        node2.leftChild = node1.rightChild;  
        node1.rightChild = node2;  
        node2.h = getMaxHeight( getHeight( node2.leftChild ), getHeight( node2.rightChild ) ) + 1;  
        node1.h = getMaxHeight( getHeight( node1.leftChild ), node2.h ) + 1;  
        return node1;  
    }  
  
    // sağ alt öğe ile ikili ağaç düğümünün dönüşünü gerçekleştirmek için rotateWithRightChild() yöntemi oluşturuluyor       
    private Node rotateWithRightChild(Node node1)  
    {  
        Node node2 = node1.rightChild;  
        node1.rightChild = node2.leftChild;  
        node2.leftChild = node1;  
        node1.h = getMaxHeight( getHeight( node1.leftChild ), getHeight( node1.rightChild ) ) + 1;  
        node2.h = getMaxHeight( getHeight( node2.rightChild ), node1.h ) + 1;  
        return node2;  
    }  
  
   // ikili ağaç düğümünün çift dönüşünü gerçekleştirmek için doubleWithLeftChild() yöntemini oluşturun. Bu yöntem önce sol çocuğu sağ çocuğuyla, ardından düğüm3'ü yeni sol çocuğuyla döndürür.
    private Node doubleWithLeftChild(Node node3)  
    {  
        node3.leftChild = rotateWithRightChild( node3.leftChild );  
        return rotateWithLeftChild( node3 );  
    }  
  
   // ikili ağaç düğümünün çift dönüşünü gerçekleştirmek için doubleWithRightChild() yöntemini oluşturun. Bu yöntem önce sağ çocuğu sol çocuğuyla ve ardından düğüm1'i yeni sağ çocuğuyla döndürür.
    private Node doubleWithRightChild(Node node1)  
    {  
        node1.rightChild = rotateWithLeftChild( node1.rightChild );  
        return rotateWithRightChild( node1 );  
    }      
  
    //AVL Ağacındaki toplam düğüm sayısını almak için getTotalNumberOfNodes() yöntemini oluşturun 
    public int getTotalNumberOfNodes()  
    {  
        return getTotalNumberOfNodes(rootNode);  
    }  
    private int getTotalNumberOfNodes(Node head)  
    {  
        if (head == null)  
            return 0;  
        else  
        {  
            int length = 1;  
            length = length + getTotalNumberOfNodes(head.leftChild);  
            length = length + getTotalNumberOfNodes(head.rightChild);  
            return length;  
        }  
    }  
  
   //AVL Ağacında bir öğe bulmak için searchElement() yöntemi oluşturun 
    public boolean searchElement(int element)  
    {  
        return searchElement(rootNode, element);  
    }  
  
    private boolean searchElement(Node head, int element)  
    {  
        boolean check = false;  
        while ((head != null) && !check)  
        {  
            int headElement = head.element;  
            if (element < headElement)  
                head = head.leftChild;  
            else if (element > headElement)  
                head = head.rightChild;  
            else  
            {  
                check = true;  
                break;  
            }  
            check = searchElement(head, element);  
        }  
        return check;  
    }  
    // AVL Ağacını sıralı biçimde dolaşmak için inorderTraversal() yöntemini oluştur 
    public void inorderTraversal()  
    {  
        inorderTraversal(rootNode);  
    }  
    private void inorderTraversal(Node head)  
    {  
        if (head != null)  
        {  
            inorderTraversal(head.leftChild);  
            System.out.print(head.element+" ");  
            inorderTraversal(head.rightChild);  
        }  
    }  
  
    // AVL Ağacını ön sipariş formunda dolaşmak için preorderTraversal() yöntemini oluşturun 
    public void preorderTraversal()  
    {  
        preorderTraversal(rootNode);  
    }  
    private void preorderTraversal(Node head)  
    {  
        if (head != null)  
        {  
            System.out.print(head.element+" ");  
            preorderTraversal(head.leftChild);               
            preorderTraversal(head.rightChild);  
        }  
    }  
      
    // AVL Ağacını sipariş sonrası formda dolaşmak için postorderTraversal() yöntemini oluştur  
    public void postorderTraversal()  
    {  
        postorderTraversal(rootNode);  
    }  
      
    private void postorderTraversal(Node head)  
    {  
        if (head != null)  
        {  
            postorderTraversal(head.leftChild);               
            postorderTraversal(head.rightChild);  
            System.out.print(head.element+" ");  
        }  
    }       
}  
  
// AVL Ağacı oluşturmak için AVLTree sınıfı oluşturun 
public class AVLTree  
{  
    //main() yöntemi başlar 
    public static void main(String[] args)  
    {              
        try (//kullanıcıdan girdi almak için Tarayıcı sınıfı nesnesi oluşturuluyor 
        Scanner sc = new Scanner(System.in)) {
            // AVL Ağacını yapılandırmak için ConstructAVLTree sınıf nesnesinin nesnesini yarat 
            ConstructAVLTree obj = new ConstructAVLTree();   
  
            char choice;    // seçim için bir karakter tipi değişkeni başlat   
              
            // anahtarı kullanarak AVL Ağacının işlemini gerçekleştirin  
            do      
            {  
                System.out.println("\n bir islem seciniz:\n");  
                System.out.println("1. Bir düğüm ekleyin");  
                System.out.println("2. Bir düğüm arayin");  
                System.out.println("3. AVL Ağacindaki toplam düğüm sayisini alin");  
                System.out.println("4. AVL Ağaci boş mu?");  
                System.out.println("5. AVL Ağacindan tüm düğümleri kaldirin");  
                System.out.println("6. AVL Ağacini Gönderi Sirasinda Görüntüle");  
                System.out.println("7. AVL Ağacini Ön Sirada Görüntüle");  
                System.out.println("8. AVL Ağacini Sirayla Görüntüle");  
  
                // kullanıcıdan seçim al  
                int ch = sc.nextInt();              
                switch (ch)  
                {  
                    case 1 :   
                        System.out.println("Lütfen AVL Ağacina eklemek için bir öğe girin");  
                        obj.insertElement( sc.nextInt() );                       
                        break;                            
                    case 2 :   
                        System.out.println("Aranacak tamsayi öğesini girin");  
                        System.out.println(obj.searchElement( sc.nextInt() ));  
                        break;                                            
                    case 3 :   
                        System.out.println(obj.getTotalNumberOfNodes());  
                        break;       
                    case 4 :   
                        System.out.println(obj.checkEmpty());  
                        break;       
                    case 5 :   
                        obj.removeAll();  
                        System.out.println("\nAğaç başarıyla Temizlendi");  
                        break;  
                    case 6 :   
                        System.out.println("\nAVL Ağacını Gönderi Sırasında Görüntüle");  
                        obj.postorderTraversal();  
                        break;  
                    case 7 :   
                        System.out.println("\nAVL Ağacını Ön Sırada Görüntüle");  
                        obj.preorderTraversal();  
                        break;  
                    case 8 :   
                        System.out.println("\nAVL Ağacını Sırayla Görüntüle");  
                        obj.inorderTraversal();  
                        break;  
                    default :   
                        System.out.println("\n ");  
                        break;      
                }  
                System.out.println("\nDevam etmek için 'y' veya 'Y'ye basın \n");  
                choice = sc.next().charAt(0);                          
            } while (choice == 'Y'|| choice == 'y');
        }         
    }  
} 