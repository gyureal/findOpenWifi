package com.example.findopenwifi.util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XmlParserUtil {        // Effective 자바 Item03 싱글톤 참조
    private static final XmlParserUtil INSTANCE = new XmlParserUtil();
    private XmlParserUtil() {};

    public static XmlParserUtil getInstance() {
        return INSTANCE;
    }

    public void parse(String xmlFile, String tagName) throws Exception{
        // 1. 빌더 팩토리 생성.
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        // 2. 빌더 팩토리로부터 빌더 생성
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        // 3. 빌더를 통해 XML 문서를 파싱해서 Document 객체로 가져온다.
        Document document = builder.parse(xmlFile);

        // 문서 구조 안정화 ?
        document.getDocumentElement().normalize();

        // XML 데이터 중 태그의 내용을 가져온다.
        NodeList tagList = document.getElementsByTagName(tagName);
        System.out.println("parsing");

        // <person> 태그 리스트를 하나씩 돌면서 값들을 가져온다.
//        for (int i = 0; i < tagList.getLength(); ++i) {
//            // 속성 값 가져오기.
//            String name = tagList.item(i).getAttributes().getNamedItem("sex").getNodeValue();
//
//            // 태그의 하위 노드들을 가져온다. ( 여기서 노드는 태그를 의미한다. )
//            NodeList childNodes = tagList.item(i).getChildNodes();
//            for (int j = 0; j < childNodes.getLength(); ++j) {
//
//                if ("name".equals(childNodes.item(j).getNodeName()) {
//                    // do somthing...
//                }
//
//                if ("age".equals(childNodes.item(j).getNodeName()) {
//                    // do somthing...
//                }
//            }
//        }
    }
}
