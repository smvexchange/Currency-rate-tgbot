package ru.smv.tgbot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smv.tgbot.dto.ValuteCursOnDate;
import ru.smv.tgbot.services.CentralRussianBankService;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService cbrService;

    @PostMapping ("/getCurrencies")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws DatatypeConfigurationException {
        return cbrService.getCurrenciesFromCbr();
    }
}
