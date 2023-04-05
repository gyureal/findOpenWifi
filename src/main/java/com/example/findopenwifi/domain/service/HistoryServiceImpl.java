package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.SearchHistory;

import java.util.List;

public enum HistoryServiceImpl implements HistoryService {

    INSTANCE;
    @Override
    public void saveHistory(SearchHistory searchHistory) {

    }

    @Override
    public List<SearchHistory> searchAllHistory() {
        return null;
    }

    @Override
    public void deleteHistory(int id) {

    }
}
