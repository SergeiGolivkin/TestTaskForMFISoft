package com.task.multithreading.query;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.task.multithreading.constant.ColumnNames.*;

public class SortingParametersValidator {
    private static final List<String> availableColumns = new ArrayList<>(
            Arrays.asList(ID_COLUMN_LABEL, TITLE_COLUMN_LABEL, NEWS_SITE_COLUMN_LABEL, PUBLISHED_DATE_COLUMN_LABEL,
                    ARTICLE_COLUMN_LABEL));
    private final static List<String> availableOrderTypes = new ArrayList<>(Arrays.asList("ASC", "DESC"));

    public static void validateParams(SortingParameters sortingParameters) {
        if (sortingParameters.getSortColumns() != null) {
            for (String columnName : sortingParameters.getSortColumns()) {
                if (!availableColumns.contains(columnName)) {
                    throw new ValidationException("validation.not.available.column");
                }
            }
        }
        if (sortingParameters.getOrderTypes() != null) {
            for (String orderType : sortingParameters.getOrderTypes()) {
                if (!availableOrderTypes.contains(orderType)) {
                    throw new ValidationException("validation.not.available.order");
                }
            }
        }
    }
}
