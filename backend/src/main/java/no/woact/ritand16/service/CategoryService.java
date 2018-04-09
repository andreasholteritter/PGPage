package no.woact.ritand16.service;

import no.woact.ritand16.entity.Category;
import no.woact.ritand16.entity.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

//Created 09/04/2018 by Ritter
//https://github.com/arcuri82/testing_security_development_enterprise_systems/blob/master/intro/exercises/quiz-game/part-08/src/main/java/org/tsdes/intro/exercises/quizgame/service/CategoryService.java

@Service
@Transactional
public class CategoryService {

    @Autowired
    private EntityManager em;

    public Long createCategory(String name){

        Category category = new Category();
        category.setName(name);

        em.persist(category);

        return category.getId();
    }


    public Long createSubCategory(long parentId, String name){

        Category category = em.find(Category.class, parentId);
        if(category == null){
            throw new IllegalArgumentException("Category with id "+parentId+" does not exist");
        }

        SubCategory subCategory = new SubCategory();
        subCategory.setName(name);
        subCategory.setParent(category);
        em.persist(subCategory);

        category.getSubCategories().add(subCategory);

        return subCategory.getId();
    }


    public List<Category> getAllCategories(boolean withSub){

        TypedQuery<Category> query = em.createQuery("select c from Category c", Category.class);
        List<Category> categories = query.getResultList();

        if(withSub){
            //force loading
            categories.forEach(c -> c.getSubCategories().size());
        }

        return categories;
    }


    public Category getCategory(long id, boolean withSub){

        Category category = em.find(Category.class, id);
        if(withSub && category != null){
            category.getSubCategories().size();
        }

        return category;
    }


    public SubCategory getSubCategory(long id){

        return em.find(SubCategory.class, id);
    }
}
