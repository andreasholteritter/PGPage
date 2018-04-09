package no.woact.ritand16.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import no.woact.ritand16.entity.MatchStats;
import no.woact.ritand16.service.MatchStatsService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserInfoController {

    @Autowired
    private MatchStatsService matchStatsService;

    public String getUserName(){
        return ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    public MatchStats getStats(){
        return matchStatsService.getMatchStats(getUserName());
    }
}
