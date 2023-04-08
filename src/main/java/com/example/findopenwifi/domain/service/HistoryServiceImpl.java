package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.SearchHistory;
import com.example.findopenwifi.domain.repository.SearchHistoryRepository;
import com.example.findopenwifi.persistence.jdbc.Dao.SearchHistoryDAO;
import java.util.List;

public enum HistoryServiceImpl implements HistoryService {

    INSTANCE;

    private final SearchHistoryRepository searchHistoryRepository;

    HistoryServiceImpl() {
        searchHistoryRepository = new SearchHistoryDAO();
    }
    @Override
    public void saveHistory(SearchHistory searchHistory) {
        searchHistoryRepository.save(searchHistory);
    }

    @Override
    public List<SearchHistory> searchAllHistory() {
        return searchHistoryRepository.findAll();
    }

    @Override
    public void deleteHistory(int id) {
        searchHistoryRepository.delete(id);
    }
}
