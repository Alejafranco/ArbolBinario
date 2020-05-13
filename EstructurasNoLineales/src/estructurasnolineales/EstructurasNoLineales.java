/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

/**
 *
 * @author samaniw
 */
public class EstructurasNoLineales {
    public static final String ANSI_PURPLE = "\u001B[35m";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MaxHeap maxData = new MaxHeap();
        //31,51,53,28,47,22
//        maxData.insert(31);
//        maxData.insert(51);
//        maxData.insert(53);
//        maxData.insert(28);
//        maxData.insert(47);
//        maxData.insert(22);
//        System.out.println(maxData.getDataHeap());
//        maxData.ExtractMax();
//        System.out.println(maxData.getDataHeap());

        BinarySearchTree pino = new BinarySearchTree(10);
        //10,5,3,8,20,7,18,25,23,30,21,24  
        try {
            pino.Add(5);
            pino.Add(3);
            pino.Add(8);
            pino.Add(20);
            pino.Add(7);
            pino.Add(18);
            pino.Add(25);
            pino.Add(23);
            pino.Add(30);
            pino.Add(21);
            pino.Add(24);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(ANSI_PURPLE + "1. Recorrido Inorden:" + ANSI_PURPLE);
        pino.InOrden();
        System.out.println("");
        System.out.println(ANSI_PURPLE + "2. Recorrido Postorden:" + ANSI_PURPLE);
        pino.Postorden();
        System.out.println("");
        System.out.println(ANSI_PURPLE + "3. Recorrido Preorden:" + ANSI_PURPLE);
        pino.PreOrden();
        System.out.println("");
        System.out.println(ANSI_PURPLE + "4. Cantidad de Nodos:" + ANSI_PURPLE);
        System.out.println(pino.CountNodes());
        System.out.println(ANSI_PURPLE + "5. Cantidad de nodos hojas del árbol:" + ANSI_PURPLE);
        System.out.println(pino.CountLeafs());
        System.out.println(ANSI_PURPLE + "6. Eliminar nodo:" + ANSI_PURPLE);
        try {
            /*
            test.Delete(5);
        test.Delete(3);
        test.Delete(20);
        test.Delete(25);
        test.Delete(30);
        test.Delete(8);
            */
            System.out.println("Nodo borrado: "+pino.Delete(5));
            System.out.println("Nodo borrado: "+pino.Delete(3));
            System.out.println("Nodo borrado: "+pino.Delete(20));
            System.out.println("Nodo borrado: "+pino.Delete(25));
            System.out.println("Nodo borrado: "+pino.Delete(30));
            System.out.println("Nodo borrado: "+pino.Delete(8));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Recorrido inorden: ");
        pino.InOrden();
        System.out.println("");
        System.out.println(ANSI_PURPLE + "7. Último nivel:" + ANSI_PURPLE);
        System.out.println(pino.LastLevel());
        System.out.println(ANSI_PURPLE + "8. Nodos de forma transversal(LevelOrder):" + ANSI_PURPLE);
        pino.LevelOrder();
    }

}
