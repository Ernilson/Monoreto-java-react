package br.com.dev1.dsmeta.ControllerTestes;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.dev1.dsmeta.Controller.SalesController;
import br.com.dev1.dsmeta.Services.SaleService;
import br.com.dev1.dsmeta.Services.SmsService;
import br.com.dev1.dsmeta.entity.Sale;

public class SalesControllerTest {

    private SalesController salesController;
    private SaleService saleService;
    private SmsService smsService;

    @BeforeEach
    public void setUp() {
        saleService = mock(SaleService.class);
        smsService = mock(SmsService.class);
        salesController = new SalesController();
    }

    @Test
    public void testFindSales() {
        // Mock input values
        String minDate = "2023-01-01";
        String maxDate = "2023-12-31";
        Pageable pageable = mock(Pageable.class);

        // Mock the service response
   //     Page<Sale> expectedPage = new PageImpl<>(/* Your expected Sale list */);
     //   doReturn(expectedPage).when(saleService).findSales(eq(minDate), eq(maxDate), any(Pageable.class));

        // Call the controller method
        Page<Sale> result = salesController.findSales(minDate, maxDate, pageable);

        // Verify the service method was called with the correct parameters
        verify(saleService).findSales(eq(minDate), eq(maxDate), eq(pageable));

        // Assert the result
        // Add your assertions here
    }

    @Test
    public void testNotifySms() {
        // Mock the service method to do nothing
        doNothing().when(smsService).sendSms();

        // Call the controller method
        salesController.notifySms();

        // Verify the service method was called
        verify(smsService).sendSms();
    }

    @Test
    public void testNotifySms2() {
        // Mock input value
        Long id = 123L;

        // Mock the service method to do nothing
        doNothing().when(smsService).sendSms2(eq(id));

        // Call the controller method
        salesController.notifySms2(id);

        // Verify the service method was called with the correct parameter
        verify(smsService).sendSms2(eq(id));
    }
}
