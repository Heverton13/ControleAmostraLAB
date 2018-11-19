/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;

/**
 *
 * @author Heverton13
 */
public interface DAO <T> {
    
    boolean add(T o);
    boolean update(T o);
    boolean remove(int i);
    ArrayList<T> list();
    
}
