/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author aldai
 */
public interface DAO <T, I> {
    public void create(T objeto) throws Exception;
    public void update(T objeto) throws Exception;
    public void delete(I id) throws Exception;
    public T readOne(I id) throws Exception;
    public ArrayList<T> readAll() throws Exception;
}
