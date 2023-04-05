package com.example.findopenwifi.domain.repository;

import com.example.findopenwifi.domain.model.SearchHistory;

import java.util.List;

public interface SearchHistoryRepository {

    int save(SearchHistory searchHistory);
    List<SearchHistory> findAll();
    void delete(int id);
}
