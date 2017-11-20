package com.mond.model;

import com.mond.entity.Quote;
import com.mond.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by User on 19.11.2017.
 */

@Service
public class QuoteService {

    private Session currentSession;
    private Transaction currentTransaction;

    public QuoteService() {}

    private void openSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    }

    private void closeSession() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Quote getById(int id) {
        openSession();
        Quote quote = (Quote) currentSession.get(Quote.class, id);
        closeSession();
        return quote;
    }

    public Quote getRandomQuote(){
        openSession();

        Criteria crit = currentSession.createCriteria(Quote.class);
        crit.setProjection(Projections.rowCount());
        long rowCount = (Long) crit.uniqueResult();

        Random random = new Random();
        Quote randomQuote = (Quote) currentSession.get(Quote.class, random.nextInt((int) rowCount));
        closeSession();

        return randomQuote;
    }

}
