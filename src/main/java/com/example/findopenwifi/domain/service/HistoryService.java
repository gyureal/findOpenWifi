package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.SearchHistory;

import java.util.List;

public interface HistoryService {

    void saveHistory(SearchHistory searchHistory);

    List<SearchHistory> searchAllHistory();
    void deleteHistory(int id);
}
