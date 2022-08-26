package com.main;

import java.sql.SQLException;

public interface ResultDAO {
	public int ResultProgressInsert(int input) throws SQLException;
	public int ResultProgressUpdate(int input) throws SQLException;
	public int ResultProgressDateInput(int input) throws SQLException;
}
