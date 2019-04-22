import java.sql.*;
 class A
{
public static void main(String ar[]) throws SQLException,ClassNotFoundException
{
try
{
Connection con=null;
Statement stmt=null;
ResultSet rs=null;
//load the driver class
Class.forName("oracle.jdbc.driver.OracleDriver");
//create the connection object
 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","hari");
//create the statment object
System.out.println("connection successfull");
 stmt=con.createStatement();
//execute query
String str="select *from student";
rs=stmt.executeQuery(str);
while(rs.next())
{
System.out.println(rs.getString("name")+" "+rs.getInt("age"));
}
//close the connection
rs.close();
stmt.close();
con.close();
}
catch(ClassNotFoundException ex)
 {
   System.out.println("Error: unable to load driver class!");
   System.exit(1);
   }
}
}