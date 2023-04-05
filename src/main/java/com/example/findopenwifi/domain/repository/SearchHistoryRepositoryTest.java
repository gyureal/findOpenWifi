package com.example.findopenwifi.domain.repository;

import com.example.findopenwifi.domain.model.SearchHistory;
import com.example.findopenwifi.persistence.jdbc.Dao.SearchHistoryDAO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SearchHistoryRepositoryTest {

    SearchHistoryRepository repository = new SearchHistoryDAO();

    @Test
    void add_Test() {
        // given
        double xValue = 3.222;
        double yValue = 4.22;
        SearchHistory history = SearchHistory.of(xValue, yValue);
        int nextId = repository.getNextAutoIncrementId();

        // when
        int affectedRows = repository.save(history);

        // then
        assertThat(affectedRows).isEqualTo(1);
        Optional<SearchHistory> findHistory = repository.findById(nextId);
        assertThat(findHistory.get().getXValue()).isEqualTo(xValue);
        assertThat(findHistory.get().getYValue()).isEqualTo(yValue);
    }

    @Test
    void findAll_Test() {
        List<SearchHistory> allHistory = repository.findAll();

        System.out.println(allHistory.size());
    }

    @Test
    void delete_Test() {
        // given
        int addId = repository.save(SearchHistory.of(3.222, 4.22));

        // when
        int affectedRows = repository.delete(addId);

        // then
        assertThat(affectedRows).isEqualTo(1);
        Optional<SearchHistory> findHistory = repository.findById(addId);
        assertThat(findHistory.orElse(null)).isNull();
    }

}