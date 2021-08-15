package com.task.multithreading.query;


import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;


public class QueryBuildHelper {

    private static final String REGEX_SYMBOL = "%";

    private final CriteriaBuilder builder;

    public QueryBuildHelper(CriteriaBuilder criteriaBuilder) {
        this.builder = criteriaBuilder;
    }

    @SuppressWarnings("unchecked")
    public <T> Optional<T> getOptionalQueryResult(Query query) {
        try {
            T entity = (T) query.getSingleResult();
            return Optional.of(entity);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public Predicate buildAndPredicates(List<Predicate> predicates) {
        if (predicates == null || predicates.isEmpty()) {
            return null;
        }
        Predicate resultPredicate = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            resultPredicate = builder.and(resultPredicate, predicates.get(i));
        }
        return resultPredicate;
    }

    public <T> Predicate buildOrEqualPredicates(Path<T> root, String columnName, List<?> values) {
        int counter = 0;
        Predicate predicate = null;
        for (Object value : values) {
            Predicate currentPredicate = builder.equal(root.get(columnName), value);
            if (counter++ == 0) {
                predicate = currentPredicate;
            } else {
                predicate = builder.or(predicate, currentPredicate);
            }
        }

        return predicate;
    }

    public String convertToRegex(String value) {
        return REGEX_SYMBOL + value + REGEX_SYMBOL;
    }

}
