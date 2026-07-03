package utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtility {

    public static Object[][] getTestData(String fileName, String sheetName) {

        try (
                InputStream input =
                        ExcelUtility.class
                                .getClassLoader()
                                .getResourceAsStream(
                                        "testdata/" + fileName
                                );

                Workbook workbook = WorkbookFactory.create(input)

        ) {

            Sheet sheet = workbook.getSheet(sheetName);

            DataFormatter formatter = new DataFormatter();

            int totalRows = sheet.getLastRowNum();

            int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[totalRows][1];

            for (int i = 1; i <= totalRows; i++) {

                Map<String, String> rowData = new HashMap<>();

                for (int j = 0; j < totalColumns; j++) {

                    String columnName = formatter.formatCellValue(sheet.getRow(0).getCell(j));

                    String value = formatter.formatCellValue(sheet.getRow(i).getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));

                    rowData.put(columnName, value);

                }

                data[i - 1][0] = rowData;

            }

            return data;

        }

        catch (IOException e) {

            throw new RuntimeException("Unable to read Excel file.", e);

        }

    }
}
