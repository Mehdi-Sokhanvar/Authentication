package ir.maktab.authenticationhibernate.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory;

    private JPAUtil() {
    }


    public static EntityManagerFactory getEntityManagerFactory() {
        return (entityManagerFactory == null) ?
                Persistence.createEntityManagerFactory("postgre_config") :
                entityManagerFactory;
    }

}
