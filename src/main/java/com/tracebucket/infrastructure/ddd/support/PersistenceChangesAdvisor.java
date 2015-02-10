package com.tracebucket.infrastructure.ddd.support;

import com.tracebucket.infrastructure.ddd.annotation.PersistChanges;
import com.tracebucket.infrastructure.ddd.repository.jpa.BaseAggregateRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.core.annotation.AnnotationUtils;

import java.beans.Introspector;
import java.lang.reflect.Method;

/**
 * Created by ffl on 09-02-2015.
 */
@Aspect
@Configurable
public class PersistenceChangesAdvisor {
    private static Logger log = LoggerFactory.getLogger(PersistenceChangesAdvisor.class);

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    /*@AfterReturning(value = "@annotation(com.tracebucket.infrastructure.ddd.annotation.PersistChanges)", returning = "result")
    public void interceptPersistence(JoinPoint joinPoint, Object result) throws NoSuchMethodException {

        StringBuffer buffer = new StringBuffer();
        buffer.append(Introspector.decapitalize(result.getClass().getSimpleName()));
        buffer.append("Repository");
        String repositoryBeanName = buffer.toString();

        BaseAggregateRepository aggregateRepository = null;
        if(beanFactory.containsBean(repositoryBeanName)){
            aggregateRepository = (BaseAggregateRepository)beanFactory.getBean(repositoryBeanName);
            result = aggregateRepository.save(result);
        }






        log.info(result.toString());
    }*/


    @AfterReturning(value = "@annotation(com.tracebucket.infrastructure.ddd.annotation.PersistChanges)", returning = "result")
    public void invoke(JoinPoint joinPoint, Object result){

        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method m = ms.getMethod();
        PersistChanges annotation = AnnotationUtils.getAnnotation(m, PersistChanges.class);

        BaseAggregateRepository aggregateRepository = null;
        String repositoryBeanName = null;
        if(annotation.repository().equals("")){
            //Make a wild guess
            StringBuffer buffer = new StringBuffer();
            buffer.append(Introspector.decapitalize(result.getClass().getSimpleName()));
            buffer.append("Repository");
            repositoryBeanName = buffer.toString();

            if(beanFactory.containsBean(repositoryBeanName)){
                log.warn("Repository name for " + Introspector.decapitalize(result.getClass().getSimpleName()) + " was guessed. This is not a fool proof way. Specify the corresponding repository in @PersistChanges(repository=\"someRepository\")");
                aggregateRepository = (BaseAggregateRepository)beanFactory.getBean(repositoryBeanName);
            }
        }
        else{
            if(beanFactory.containsBean(annotation.repository())){
                repositoryBeanName = annotation.repository();
                log.info("Found a matching repository: " + annotation.repository());
                aggregateRepository = (BaseAggregateRepository)beanFactory.getBean(repositoryBeanName);
            }
        }
        if(aggregateRepository != null){
            result = aggregateRepository.save(result);
            log.info("Attempting to persist " + Introspector.decapitalize(result.getClass().getSimpleName() + " using ") + repositoryBeanName);
        }
        else{
            log.info("Unable to find a matching repository");
        }



    }

}
