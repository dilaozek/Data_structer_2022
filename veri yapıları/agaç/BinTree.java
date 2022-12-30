class BinTree
{
    public static void main(String args[])
    {
        Tree theTree= new Tree();
        System.out.println("Sayılar: ");
        for(int i=0;i<10;i++){
            int sayi=(int)(Math.random()*100);
            System.out.println(sayi+"");
            theTree.insert(sayi);
        };
        System.out.print("\n Ağacin inOrder Dolaşmasi : ");
        theTree.inOrder(theTree.getRoot());
        System.out.print("\n Ağacin preOrder Dolaşmasi : ");
        theTree.preOrder(theTree.getRoot());
        System.out.print("\n Ağacin postOrder Dolaşmasi : ");
        theTree.postOrder(theTree.getRoot());

    }

}