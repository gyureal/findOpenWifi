package com.example.findopenwifi.util;

import jdk.internal.org.xml.sax.InputSource;
import jdk.internal.org.xml.sax.SAXException;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.*;

class XmlParserUtilTest {

    XmlParserUtil xmlParserUtil = XmlParserUtil.getInstance();

    @Test
    void xmlParsingTest() throws Exception{
        Document xml = null;
        try {
            // URL 설정
            StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088/");
            urlBuilder.append("5245626172696f7034395975634f72");  // key
            urlBuilder.append("/xml");
            urlBuilder.append("/TbPublicWifiInfo");
            urlBuilder.append("/" + 1);
            urlBuilder.append("/" + 5);
            String urlString = urlBuilder.toString();


            URL url = new URL(urlString);
            URLConnection urlConnect = url.openConnection();
            urlConnect.connect();

            InputSource inputSource = new InputSource(urlConnect.getInputStream());

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            xml = documentBuilderFactory.newDocumentBuilder().parse(inputSource.getByteStream());

            // root element 취득
            Element element = xml.getDocumentElement();

            // child node 취득
            NodeList list = element.getChildNodes();

            // child node 가 1개 이상인 경우
            if(list.getLength() > 0) {
                for(int i=0; i<list.getLength(); i++) {

                    NodeList childList = list.item(i).getChildNodes();

                    if(childList.getLength() > 0) {
                        // System.out.println("\t xml tag name : " + childList.item(i).getNodeName() + ", xml값 : "+ childList.item(i).getTextContent()); childList.item(i).getNodeName();
                        // 갯수 태그는 언제?

                        for (int j = 0; j < childList.getLength(); j++) {
                            // 데이터가 있는 애들만 출려되게 한다.
                            if(childList.item(j).getNodeName().equals("#text")==false) {
                                String tagName = childList.item(j).getNodeName();
                                String value = childList.item(j).getTextContent();

                                System.out.println("\t xml tag name : " + tagName + ", xml값 : "+ value);
                            }
                        }
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}