package pl.szydlowski.springbootcrudapi.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorPageTest {

    private int ZERO_INDEX = 0;
    @Test
    void validatePage() {
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("1"));
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("0"));
    }
    @Test
    void validatePageWhetherArgumentIsNotNumber(){
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("1f1f1f1f1"));
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("88888888888888fd"));
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("ddddddddd"));
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("1dddddd1"));
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("d1111111111111d"));
    }

    @Test
    void validatePageReturnIndexReducedByOne(){
        assertEquals(7,ValidatorPage.validatePage("8"));
        assertEquals(21,ValidatorPage.validatePage("22"));
        assertEquals(2,ValidatorPage.validatePage("3"));
        assertEquals(1,ValidatorPage.validatePage("2"));
    }
    @Test
    void validatePageWhetherNumberIsAnInteger(){
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("200000,2"));
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("20000f"));
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("2l"));
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("2i"));
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("2b"));
    }

    @Test
    void validatePageWhetherArgumentIsEmpty(){
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage(""));
    }

    @Test
    void validatePageWhetherNumberIsNegative(){
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("-1"));
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("-1.1"));
        assertEquals(ZERO_INDEX,ValidatorPage.validatePage("-2222.1"));
    }

}