package myapp.com.techno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryDAO {

private static final String URL = "jdbc:mysql://localhost:3306/order";
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "root";
     
    public static List<Category> list(int id) throws SQLException {
        List<Category> listCategory = new ArrayList<Category>();
         
        try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      Connection  connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "SELECT * FROM category where subid="+id;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                int cid = result.getInt("id");
                String name = result.getString("name");
               int subid= result.getInt("subid");
                Category category = new Category(cid, name,subid);
                     
                listCategory.add(category);
              
            }          
         
        return listCategory;
    }
}
