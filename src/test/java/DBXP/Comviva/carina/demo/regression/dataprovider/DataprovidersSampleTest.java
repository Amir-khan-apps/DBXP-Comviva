package DBXP.Comviva.carina.demo.regression.dataprovider;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;

/**
 * This sample shows how to use data-providers.
 *
 * @author qpsdemo
 */
public class DataprovidersSampleTest implements IAbstractTest {
    /**
     * Parametrization using external XLS/XLSX: every row in spreadsheet provides tests arguments set for 1 test.
     * <p>
     * 1. Specify data-provider type:
     * - @Test(dataProvider = "XLSDataProvider") allows parallel execution
     * - @Test(dataProvider = "SingleDataProvider") allows single-thread execution
     * 2. In @XlsDataSourceParameters should contain:
     * - path - xls/xlsx file path located in src/test/resources
     * - sheet - xls spreadsheet name
     * - dsUid - data-source unique identifier, use TUID or set of parameters
     * - dsArgs - column names from spreadsheet
     *
     * @param a String
     *
     * @param b String
     *
     * @param c String
     */
    @Test(dataProvider = "DataProvider")
    @MethodOwner(owner = "qpsdemo")
    @TestRailCases(testCasesId = "1")
    @XlsDataSourceParameters(path = "xls/demo.xlsx", sheet = "Calculator", dsUid = "TUID", dsArgs = "a,b,c", testRailColumn = "a")
    public void testSumOperation(String a, String b, String c) {
        int actual = Integer.valueOf(a) + Integer.valueOf(b);
        int expected = Integer.valueOf(c);
        Assert.assertEquals(actual, expected, "Invalid sum result!");
    }

}