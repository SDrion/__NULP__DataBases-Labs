package com.polotskyi.model.dao;

import com.polotskyi.HibernateUtil;
import com.polotskyi.model.entity.Fine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FineDao implements IGenDao<Fine> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Fine> findAll() {
        List<Fine> fines = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            fines = session.createQuery("from Fine").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fines;
    }


    @Override
    public Fine find(Integer id) {
        Fine fine = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            fine = session.get(Fine.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fine;
    }

    @Override
    public void create(Fine fine) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(fine);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Fine fine) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(fine);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Fine fine = session.get(Fine.class, id);
            if (fine != null) {
                session.delete(fine);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
