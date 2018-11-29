package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {
    
    @PersistenceContext
    private EntityManager em;

    public Goal save(Goal goal) {
        em.persist(goal);
        em.flush();
        return goal;
    }

    @SuppressWarnings("unchecked")
    public List<Goal> loadAll() {
        
        Query query = em.createQuery("select g from Goal g");
        
        @SuppressWarnings("rawtypes")
        List queriedGoals = query.getResultList();
        
        return queriedGoals;
    }
    
    /**
     * {@inheritDoc}
     * @see com.pluralsight.repository.GoalRepository#findAllGoalReports()
     */
    public List<GoalReport> findAllGoalReports() {
        //PROJECTION query
        Query query = em.createQuery("select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity)"
                + " from Goal g, Exercise e where g.id = e.goal.id");
        
        @SuppressWarnings("unchecked")
        List<GoalReport> resultList = query.getResultList();
        
        return resultList;
    }

}
