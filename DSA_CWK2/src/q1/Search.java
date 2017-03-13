/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

/**
 *
 * @author Christopher Irvine
 */
public interface Search 
{
    public int getFoundR();
    
    public int getFoundC();
    
    public boolean findElement(Matrix A, int n, int p);
}
