package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.domain.model.SearchHistory;
import com.example.findopenwifi.domain.repository.OpenWifiInfoRepository;
import com.example.findopenwifi.persistence.jdbc.Dao.OpenWifiInfoDAO;
import com.example.findopenwifi.util.MapperUtil;
import com.example.findopenwifi.domain.dto.OpenWifiInfoDTO;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public enum OpenWifiServiceImpl implements OpenWifiService {

    INSTANCE;   //  enum 객체 수

    private static final int FILTERED_COUNT = 20;
    private OpenWifiInfoRepository openWifiInfoRepository;

    private HistoryService historyService;

    private ModelMapper modelMapper;

    OpenWifiServiceImpl() {  // enum 은 싱글톤, public 생성자 사용 못함 -> new 불가
        openWifiInfoRepository = new OpenWifiInfoDAO();
        historyService = HistoryServiceImpl.INSTANCE;
        modelMapper = MapperUtil.INSTANCE.get();
    }

    OpenWifiServiceImpl dependencyInjectionForTest(OpenWifiInfoRepository openWifiInfoRepository,
                                                   HistoryService historyService) {
        this.openWifiInfoRepository = openWifiInfoRepository;
        this.historyService = historyService;
        return this;
    }

    @Override
    public void saveOpenApiRawData(List<OpenWifiInfo> openWifiInfo) {
        openWifiInfo.stream().forEach(openWifiInfoRepository::save);
    }

    @Override
    public List<OpenWifiInfoDTO> getWifiNearBy(double x, double y) {

        historyService.saveHistory(SearchHistory.of(x, y));

        List<OpenWifiInfo> allInfos = openWifiInfoRepository.findAll();
        List<OpenWifiInfo> filteredInfo = filterNearData(allInfos, x, y, FILTERED_COUNT);

        return filteredInfo.stream()
                .map(vo -> modelMapper.map(vo, OpenWifiInfoDTO.class))
                .collect(Collectors.toList());
    }

    private List<OpenWifiInfo> filterNearData(List<OpenWifiInfo> allInfos,
                                              double x, double y, int filteredCount) {
        return allInfos.stream()
                .peek(info -> info.setDistanceFrom(x, y))
                .sorted((o1, o2) -> Double.compare(o1.getDistance(), o2.getDistance()))
                .limit(filteredCount)
                .collect(Collectors.toList());
    }

}
