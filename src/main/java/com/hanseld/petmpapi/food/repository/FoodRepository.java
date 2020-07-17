package com.hanseld.petmpapi.food.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hanseld.petmpapi.food.model.Food;

@RepositoryRestResource(collectionResourceRel = "foods", path = "foods")
public interface FoodRepository extends PagingAndSortingRepository<Food, Long> {
	
}
