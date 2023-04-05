package com.example.findopenwifi.domain.repository;

import com.example.findopenwifi.domain.model.SearchHistory;

import java.util.List;
import java.util.Optional;

public interface SearchHistoryRepository {

    int getNextAutoIncrementId();
    int save(SearchHistory searchHistory);
    List<SearchHistory> findAll();
    Optional<SearchHistory> findById(int id);
    int delete(int id);
}
