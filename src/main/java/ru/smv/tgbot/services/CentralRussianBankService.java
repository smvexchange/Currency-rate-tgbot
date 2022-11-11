package ru.smv.tgbot.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.WebServiceTemplate;
import ru.smv.tgbot.dto.GetCursOnDateXML;
import ru.smv.tgbot.dto.GetCursOnDateXmlResponse;
import ru.smv.tgbot.dto.ValuteCursOnDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CentralRussianBankService extends WebServiceTemplate {
    @Value("${cbr.api.url}")
    private String cbrApiUrl;

    public List<ValuteCursOnDate> getCurrenciesFromCbr() throws DatatypeConfigurationException {
        final GetCursOnDateXML getCursOnDateXml = new GetCursOnDateXML();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());

        XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        getCursOnDateXml.setOnDate(xmlGregCal);

        GetCursOnDateXmlResponse response = (GetCursOnDateXmlResponse) marshalSendAndReceive(cbrApiUrl, getCursOnDateXml);

        if (response == null) {
            throw new IllegalStateException("Could not get response from CRB Service");
        }

        final List<ValuteCursOnDate> courses = response.getGetCursOnDateXmlResult().getValuteData();
        courses.forEach(course -> course.setName(course.getName().trim()));
        return courses;
    }
}
