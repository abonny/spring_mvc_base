package com.pluralsight.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
        
        TypedQuery<Goal> queriedGoals = em.createNamedQuery(Goal.FIND_ALL_GOALS, Goal.class);
        
        return queriedGoals.getResultList();
    }
    
    /**
     * {@inheritDoc}
     * @see com.pluralsight.repository.GoalRepository#findAllGoalReports()
     */
    public List<GoalReport> findAllGoalReports() {
        //PROJECTION query
//        Query query = em.createQuery("select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity)"
//                + " from Goal g, Exercise e where g.id = e.goal.id");
        
        TypedQuery<GoalReport> query = em.createNamedQuery(Goal.FIND_GOAL_REPORTS, GoalReport.class);
        
//        @SuppressWarnings("unchecked")
        List<GoalReport> resultList = query.getResultList();
        
        return resultList;
    }

}
