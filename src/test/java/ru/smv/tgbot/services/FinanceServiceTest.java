package ru.smv.tgbot.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.smv.tgbot.repository.IncomeRepository;
import ru.smv.tgbot.repository.SpendRepository;
import ru.smv.tgbot.services.FinanceService;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FinanceServiceTest {

    @InjectMocks
    private FinanceService financeService;

    @Mock
    private SpendRepository spendRepository;

    @Mock
    private IncomeRepository incomeRepository;

    @Test
    public void addFinanceOperationAddIncomeTest() {
        String price = "150.0";
        String message = financeService.addFinanceOperation("/addincome", price, 500L);
        Assertions.assertEquals("Доход в размере " + price + " был успешно добавлен", message);
    }

    @Test
    public void addFinanceOperationElseBranchTest() {
        String price = "200";
        String message = financeService.addFinanceOperation("/nan", price, 250L);
        Assertions.assertEquals("Расход в размере " + price + " был успешно добавлен", message);
    }

}
