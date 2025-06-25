package D;

public class DataBase_Client {

	public static void main(String[] args) {
		DataBase d1 = new SQL_DataBase();
		DBA dsql = new DBA(d1);
		DataBase d2 = new NoSql_Database();
		DBA dnosql = new DBA(d2);
	}

}
