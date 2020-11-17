package com.pazyniuk.passive.model.DAO;

import com.pazyniuk.passive.model.HibernateUtil;
import com.pazyniuk.passive.model.RecordLabel;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public final class RecordLabelDAO {

    public final void saveRecordLabel(final RecordLabel recordLabel) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(recordLabel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final void updateRecordLabel(final RecordLabel recordLabel) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(recordLabel);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final void deleteRecordLabel(final int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            RecordLabel recordLabel = session.get(RecordLabel.class, id);
            if (recordLabel != null) {
                session.delete(recordLabel);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public final RecordLabel getRecordLabel(final int id) {
        Transaction transaction = null;
        RecordLabel recordLabel = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            recordLabel = session.get(RecordLabel.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return recordLabel;
    }

    @SuppressWarnings("unchecked")
    public final List <RecordLabel> getAllRecordLabels() {
        Transaction transaction = null;
        List <RecordLabel> listOfRecordLabels = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfRecordLabels = session.createQuery("from RecordLabel").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfRecordLabels;
    }
}
