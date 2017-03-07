/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;
import java.util.Scanner;

/**
 *
 * @author ruw12gbu
 */
public class Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
//        int n = 0;
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the size of the matrix: ");
//        n = scan.nextInt();
        
        Matrix matrix = new Matrix(10);
        
        System.out.println(matrix.toString());
        
        matrix.rowOrder();
        
        System.out.println(matrix.toString());
        
        matrix.columnOrder();
        
        System.out.println(matrix.toString());
    }
    
}
