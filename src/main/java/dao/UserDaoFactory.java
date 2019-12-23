package dao;


import util.PropertyReader;

public class UserDaoFactory {
   private UserDao userDao = null;

    public UserDaoFactory() throws Exception {
        newUserDAO();
    }

    private  void newUserDAO() throws Exception {
       switch (PropertyReader.getProperty("type_DAO")) {
       case ("Hibernate"):
           userDao = new UserHibernateDAO();
           break;
       case  ("JDBC"):
               userDao = new UserJdbcDAO();
           break;
       default:
           throw new Exception("Error! DAO.");
       }
   }

    public UserDao getUserDao() {
        return userDao;
    }
}
