package com.hanseld.petmpapi.weeklymealplan.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hanseld.petmpapi.weeklymealplan.model.WeeklyMealPlan;

@RepositoryRestResource(collectionResourceRel = "weeklymealplans", path = "weeklymealplans")
public interface WeeklyMealPlanRepository extends PagingAndSortingRepository<WeeklyMealPlan, Long> {
	
}
