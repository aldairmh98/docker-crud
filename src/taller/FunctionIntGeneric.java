/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.sql.SQLException;

/**
 *
 * @author aldai
 */
public interface FunctionIntGeneric<T, S> {
    public S returnAData(T objeto) throws SQLException;
}
