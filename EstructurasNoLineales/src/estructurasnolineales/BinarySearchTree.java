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
public class BinarySearchTree {

    private BinaryNode root;
    private BinaryNode father;
    private boolean position;
    int contNodos=0, contLeaves=0, sizeTree=0;
    String[] niveles;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int data) {
        root = new BinaryNode(data);
        contNodos++;
    }

    //Punto 1
    public void InOrden() {
        InOrden(root);
    }

    private void InOrden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            InOrden(currentRoot.getLeft());
            System.out.print(currentRoot.getData() + " ");
            InOrden(currentRoot.getRight());
        }
    }

    //Punto 2
    public void Postorden() {
        Postorden(root);
    }
    
    public void Postorden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            Postorden(currentRoot.getLeft());
            Postorden(currentRoot.getRight());
            System.out.print(currentRoot.getData() + " ");
        }
    }

    //Punto 3
     public void PreOrden() {
        PreOrden(root);
    }
    public void PreOrden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            System.out.print(currentRoot.getData() + " ");
            PreOrden(currentRoot.getLeft());
            PreOrden(currentRoot.getRight());
        }
    }

    //Punto 4
    public int CountNodes() {
        //...
        return contNodos;
    }

    //Punto 5
    public int CountLeafs() {
       CountLeafs(root);
       return contLeaves;

    }
     public void CountLeafs(BinaryNode currentRoot) {
        if(currentRoot != null){
            if(currentRoot.getLeft() == null && currentRoot.getRight() == null){
                contLeaves++;
            }
            CountLeafs(currentRoot.getLeft());
            CountLeafs(currentRoot.getRight());
        }
    }

    public void Add(int data) {
        if (root == null) {
            root = new BinaryNode(data);
        } else //validar si el dato ya existe
        {
            if (Search(data) != null) {
                System.out.println("Dato repetido, no se puede insertar");
            } else {
                Add(data, root);
                contNodos++;
            }
        }
    }

    private void Add(int data, BinaryNode currentRoot) {
        if (data < currentRoot.getData()) {
            if (currentRoot.getLeft() == null) {
                currentRoot.setLeft(new BinaryNode(data));
            } else {
                Add(data, currentRoot.getLeft());
            }

        } else if (currentRoot.getRight() == null) {
            currentRoot.setRight(new BinaryNode(data));
        } else {
            Add(data, currentRoot.getRight());
        }
    }

    public BinaryNode Search(int data) {
        return Search(data, root);
    }

    private BinaryNode Search(int data, BinaryNode currentRoot) {
        if (currentRoot == null) {
            return null;
        }
        if (data == currentRoot.getData()) {
            return currentRoot;
        }

        father = currentRoot;

        if (data < currentRoot.getData()) {
            position = false;
            return Search(data, currentRoot.getLeft());
        } else {
            position = true;
            return Search(data, currentRoot.getRight());
        }
    }

    //Punto 6
    public int Delete(int data) {
        if (root == null) {
            System.out.print("Árbol vacío");
        } else {
            Delete(data, root);
        }
        return data;
    }

    private void Delete(int data, BinaryNode currentRoot) {

        BinaryNode v = Search(data);
        if(v == this.root && v.getRight() == null && v.getLeft() == null){
            this.root = null;
            return;
        }
        if (v.isLeaf()) {
            if (position) {
                father.setRight(null);
            } else {
                father.setLeft(null);
            }
        } else if (v.hasOneChild()) {
            if (v.isChildPosition()) {
                if(root == v){
                    BinaryNode minimum = getMinor(v.getRight());
                    Delete(minimum.getData());
                    v.setData(minimum.getData());
                }else if(position){
                        father.setRight(v.getRight());
                }else{
                    father.setRight(v.getRight());
                }   
            } else {
                if(root == v){
                    root = v.getLeft();
                    v.setLeft(null);
                }else if(position){
                        father.setRight(v.getLeft());
                }else{
                    father.setLeft(v.getLeft());
                }              
            }
        } else {
            BinaryNode minimum = getMinor(v.getRight());
            Delete(minimum.getData());
            v.setData(minimum.getData());
        }
    }

    //Punto 7
    public int LastLevel() {
        LastLevel(root, 0);
        return sizeTree;
    }
    public void LastLevel(BinaryNode currentRoot, int contLevel) {
        if(currentRoot != null){
            LastLevel(currentRoot.getLeft(), contLevel+1);
            if(contLevel > sizeTree){
                sizeTree = contLevel;
            }
            LastLevel(currentRoot.getRight(), contLevel + 1);
        }
    }
    

    //Punto 8
    public void LevelOrder() {
        niveles = new String[sizeTree+1];
        LevelOrder(root, 0);
        for (int i = 0; i < niveles.length; i++) {
            System.out.println(niveles[i]);
        }
    }
    public void LevelOrder(BinaryNode currentRoot, int next) {
        if(currentRoot!=null){
            niveles[next] = currentRoot.getData()+" "+(niveles[next]!=null?niveles[next]:"");
            LevelOrder(currentRoot.getRight(), next+1);
            LevelOrder(currentRoot.getLeft(), next+1);
        }
    }

    public BinaryNode getMinor(BinaryNode currentRoot) {
        if (currentRoot.getLeft() == null) {
            return currentRoot;
        } else {
            return getMinor(currentRoot.getLeft());
        }
    }
}