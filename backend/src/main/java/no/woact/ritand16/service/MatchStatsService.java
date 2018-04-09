package no.woact.ritand16.service;

import no.woact.ritand16.entity.MatchStats;
import no.woact.ritand16.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

//Created 09/04/2018 by Ritter
//https://github.com/arcuri82/testing_security_development_enterprise_systems/blob/master/intro/exercises/quiz-game/part-10/src/main/java/org/tsdes/intro/exercises/quizgame/service/MatchStatsService.java

@Service
@Transactional
public class MatchStatsService {

    @Autowired
    private EntityManager em;

    public void reportVictory(String username){

        MatchStats match = getMatchStats(username);

        match.setVictories( 1 + match.getVictories());
    }

    public void reportDefeat(String username){

        MatchStats match = getMatchStats(username);

        match.setDefeats( 1 + match.getDefeats());
    }


    public MatchStats getMatchStats(String username) {

        TypedQuery<MatchStats> query = em.createQuery(
                "select m from MatchStats m where m.user.username=?1", MatchStats.class);
        query.setParameter(1, username);

        List<MatchStats> results = query.getResultList();
        if(!results.isEmpty()){
            return results.get(0);
        }

        User user = em.find(User.class, username);
        if(user == null){
            throw new IllegalArgumentException("No existing user: " + username);
        }

        MatchStats match = new MatchStats();
        match.setUser(user);
        em.persist(match);

        return match;
    }
}
