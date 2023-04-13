package com.example.findopenwifi.domain.service.history;

import com.example.findopenwifi.domain.dto.SearchHistoryDTO;
import com.example.findopenwifi.domain.model.SearchHistory;

import java.util.List;

public interface HistoryService {

    void saveHistory(SearchHistory searchHistory);

    List<SearchHistoryDTO> searchAllHistory();
    void deleteHistory(int id);
}
