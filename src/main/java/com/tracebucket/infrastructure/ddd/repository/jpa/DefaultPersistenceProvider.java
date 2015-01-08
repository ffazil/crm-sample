package com.tracebucket.infrastructure.ddd.repository.jpa;

import org.hibernate.jpa.HibernateQuery;
import org.springframework.data.jpa.repository.query.QueryExtractor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;

import static org.springframework.data.jpa.repository.utils.JpaClassUtils.isEntityManagerOfType;

/**
 * Created by ffl on 08-01-2015.
 */
public enum DefaultPersistenceProvider implements QueryExtractor, Serializable{
    /**
     * Hibernate persistence provider.
     */
    HIBERNATE("org.hibernate.ejb.HibernateEntityManager") {

        public String extractQueryString(Query query) {

            return ((HibernateQuery) query).getHibernateQuery()
                    .getQueryString();
        }


        /**
         * Return custom placeholder ({@code *}) as Hibernate does create
         * invalid queries for count queries for objects with compound keys.
         *
         */
        @Override
        protected String getCountQueryPlaceholder() {

            return "*";
        }
    },

    /**
     * EclipseLink persistence provider.
     */
    ECLIPSELINK("org.eclipse.persistence.jpa.JpaEntityManager") {

        public String extractQueryString(Query query) {
//return ((JpaQuery<?>) query).getDatabaseQuery().getJPQLString();
            return null;
        }

    },

    /**
     * OpenJpa persistence provider.
     */
    OPEN_JPA("org.apache.openjpa.persistence.OpenJPAEntityManager") {

        public String extractQueryString(Query query) {
//return ((OpenJPAQuery) query).getQueryString();
            return null;
        }
    },

    /**
     * Unknown special provider. Use standard JPA.
     */
    GENERIC_JPA("javax.persistence.EntityManager") {

        public String extractQueryString(Query query) {

            return null;
        }


        @Override
        public boolean canExtractQuery() {

            return false;
        }
    };

    private String entityManagerClassName;


    /**
     * Creates a new {PersistenceProvider}.
     *
     * @param entityManagerClassName the name of the provider specific
     *            {@link EntityManager} implementation
     */
    private DefaultPersistenceProvider(String entityManagerClassName) {

        this.entityManagerClassName = entityManagerClassName;
    }


    /**
     * Determines the {PersistenceProvider} from the given
     * {@link EntityManager}. If no special one can be determined
     * { GENERIC_JPA} will be returned.
     *
     * @param em
     * @return
     */
    public static DefaultPersistenceProvider fromEntityManager(EntityManager em) {

        for (DefaultPersistenceProvider provider : values()) {
            if (isEntityManagerOfType(em, provider.entityManagerClassName)) {
                return provider;
            }
        }

        return GENERIC_JPA;
    }


    /*
    * (non-Javadoc)
    *
    * @see
    * org.springframework.data.jpa.repository.query.QueryExtractor#canExtractQuery
    * ()
    */
    public boolean canExtractQuery() {

        return true;
    }


    /**
     * Returns the placeholder to be used for simple count queries. Default
     * implementation returns {@code *}.
     *
     * @return
     */
    protected String getCountQueryPlaceholder() {

        return "x";
    }
}
