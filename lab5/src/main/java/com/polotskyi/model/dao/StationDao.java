package com.polotskyi.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.polotskyi.model.entity.Station;
import com.polotskyi.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StationDao implements IGenDao<Station> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Station> findAll() {
        List<Station> stations = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            stations = session.createQuery("from Station").getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }


    @Override
    public Station find(Integer id) {
        Station station = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            station = session.get(Station.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return station;
    }

    @Override
    public void create(Station station) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(station);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Station station) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(station);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Station station = session.get(Station.class, id);
            if (station != null) {
                session.delete(station);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
