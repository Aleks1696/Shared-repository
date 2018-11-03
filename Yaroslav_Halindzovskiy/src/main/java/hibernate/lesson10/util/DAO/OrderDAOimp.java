package hibernate.lesson10.util.DAO;

import hibernate.lesson10.entity.Order;
import hibernate.lesson9.util.HibernateUtil;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class OrderDAOimp implements OrderDAO {


    private SessionFactory factory ;
    public OrderDAOimp (){
        factory = HibernateUtil.getFactory();


    }


    @Override
    public Long create(Order order) {
        Session  session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(order);
            session.getTransaction().commit();
            return id;
        }catch (HibernateError error){
            session.getTransaction().rollback();
            System.err.println(error.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public Order read(Long id) {

        return factory.openSession().get(Order.class,id);
    }

    @Override
    public boolean update(Order order) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e ){
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean delete(Order order) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e ){
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public List<Order> findAll() {
        return factory.openSession().createCriteria(Order.class).list();
    }
}
