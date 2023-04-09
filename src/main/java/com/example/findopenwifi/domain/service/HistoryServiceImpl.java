package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.dto.SearchHistoryDTO;
import com.example.findopenwifi.domain.model.SearchHistory;
import com.example.findopenwifi.domain.repository.SearchHistoryRepository;
import com.example.findopenwifi.persistence.jdbc.Dao.SearchHistoryDAO;
import com.example.findopenwifi.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public enum HistoryServiceImpl implements HistoryService {

    INSTANCE;

    private final SearchHistoryRepository searchHistoryRepository;
    private final ModelMapper modelMapper = MapperUtil.INSTANCE.get();

    HistoryServiceImpl() {
        searchHistoryRepository = new SearchHistoryDAO();
    }
    @Override
    public void saveHistory(SearchHistory searchHistory) {
        searchHistoryRepository.save(searchHistory);
    }

    @Override
    public List<SearchHistoryDTO> searchAllHistory() {
        List<SearchHistory> histories = searchHistoryRepository.findAll();

        return histories.stream()
                .map(vo -> modelMapper.map(vo, SearchHistoryDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteHistory(int id) {
        searchHistoryRepository.delete(id);
    }
}
