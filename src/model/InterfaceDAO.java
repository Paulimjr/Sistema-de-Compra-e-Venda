package model;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {

	public int insert(T obj) throws SQLException;
	
	public List<T> list() throws SQLException;;
	
	public boolean delete(T obj) throws SQLException;;
	
	public boolean update(T obj) throws SQLException;;
	
	public T find(T obj) throws SQLException;;

}
