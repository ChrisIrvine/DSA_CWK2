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
public class SearchFactory 
{
    public Search chooseSearch(String input)
    {
        switch (input) {
            case "D":
                return new SearchD();
            case "D1":
                return new SearchD1();
            case "D2":
                return new SearchD2();
            default:
                System.out.println("Please enter either D, D1 or D2");
        }
        return null;
    }
}
