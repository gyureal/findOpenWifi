package com.example.findopenwifi.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchHistoryTest {

    @Test
    void create_SearchHistory_model_Test() {
        double x_value = 3.222;
        double y_value = 4.222;

        SearchHistory searchHistory = SearchHistory.of(x_value, y_value);

        assertNotNull(searchHistory);
        assertEquals(x_value, searchHistory.getXValue());
        assertEquals(y_value, searchHistory.getYValue());
    }

}