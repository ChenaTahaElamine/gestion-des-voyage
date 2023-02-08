package DAO;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class Class_Connection {
	private final static String nome_dataBase = "MINIPROGECT";

	public static Connection conn_oracle_jdbc() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		ods.setUser("system");
		ods.setPassword("Taha");
		return (Connection) ods.getConnection();
	}

	public static String getNome_dataBase() {
		return nome_dataBase;
	}

	/* 
 SELECT B.NOMBRE_PLACE-(
         SELECT COUNT(E.NUM_CL) AS n_p
         FROM EFFECTUER E,VOYAGE V
         WHERE E.CODE_V=V.CODE_V AND V.CODE_V=1) AS n_p_r
 FROM Bus B,VOYAGE VO
 WHERE VO.N_IMMUTRACULATION=B.N_IMMUTRACULATION AND VO.CODE_V=1;*/
}
