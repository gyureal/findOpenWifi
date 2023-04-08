package com.example.findopenwifi.domain.service;

import com.example.findopenwifi.domain.model.OpenWifiInfo;
import com.example.findopenwifi.domain.repository.OpenWifiInfoRepository;
import com.example.findopenwifi.persistence.jdbc.Dao.OpenWifiInfoDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public enum OpenWifiServiceImpl implements OpenWifiService {

    INSTANCE;   //  enum 객체 수

    private static final int FILTERED_COUNT = 20;
    private OpenWifiInfoRepository openWifiInfoRepository;

    OpenWifiServiceImpl() {  // enum 은 싱글톤, public 생성자 사용 못함 -> new 불가
        openWifiInfoRepository = new OpenWifiInfoDAO();
    }

    OpenWifiServiceImpl setOpenWifiInfoRepositoryForTest(OpenWifiInfoRepository openWifiInfoRepository) {
        this.openWifiInfoRepository = openWifiInfoRepository;
        return this;
    }

    @Override
    public void saveOpenApiRawData(List<OpenWifiInfo> openWifiInfo) {
        openWifiInfo.stream().forEach(openWifiInfoRepository::save);
    }

    @Override
    public List<OpenWifiInfo> getWifiNearBy(double x, double y) {

        List<OpenWifiInfo> allInfos = openWifiInfoRepository.findAll();

        return filterNearData(allInfos, x, y, FILTERED_COUNT);
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
