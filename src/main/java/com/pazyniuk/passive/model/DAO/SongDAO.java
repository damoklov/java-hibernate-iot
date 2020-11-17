package com.pazyniuk.passive.model.DAO;

import com.pazyniuk.passive.model.HibernateUtil;
import com.pazyniuk.passive.model.Song;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public final class SongDAO {

    public final void saveSong(final Song song) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(song);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final void updateSong(final Song song) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(song);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final void deleteSong(final int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Song song = session.get(Song.class, id);
            if (song != null) {
                session.delete(song);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final Song getSong(final int id) {
        Transaction transaction = null;
        Song song = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            song = session.get(Song.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return song;
    }

    @SuppressWarnings("unchecked")
    public final List <Song> getAllSongs() {
        Transaction transaction = null;
        List <Song> listOfSongs = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfSongs = session.createQuery("from Song").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfSongs;
    }
}
