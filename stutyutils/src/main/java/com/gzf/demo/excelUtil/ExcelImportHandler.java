package com.gzf.demo.excelUtil;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @program: demoList
 * @description: 解析excel
 * @author: Gaozf
 * @create: 2019-11-24 18:23
 **/
public class ExcelImportHandler {
    private static final Logger logger = LoggerFactory.getLogger(ExcelImportHandler.class);

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Desktop\\demo\\demo.xlsx";
        //excelImportHandler(filePath);
    }

    public static void excelImportHandler(MultipartFile file) {

        ExcelHandler excelHandler = new ExcelHandler();
        List<Map<String, Object>> excelInfo = excelHandler.getExcelInfoByFile(file);
        logger.info("result:{}", excelHandler);
        for (Object p : excelInfo) {
            //处理逻辑
        }
    }

    static class ExcelHandler {

        private int totalRows = 0;

        private int totalCells = 0;

        public ExcelHandler() {
        }

        public int getTotalRow() {
            return totalRows;
        }

        public void setTotalRow(int totalRow) {
            this.totalRows = totalRow;
        }

        public int getTotalCells() {
            return totalCells;
        }

        public void setTotalCells(int totalCells) {
            this.totalCells = totalCells;
        }

        /**
         * 获取excel中的内容
         *
         * @param filePath
         * @return
         */
        public List<Map<String, Object>> getExcelInfo(String filePath) {
            boolean isExcel2003 = true;
            InputStream is = null;
            try {
                if (!validateExcel(filePath)) {
                    return null;
                }
                if (isExcel2007(filePath)) {
                    isExcel2003 = false;
                }
                is = new FileInputStream(filePath);
                return createExcel(is, isExcel2003);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public List<Map<String, Object>> getExcelInfoByFile(MultipartFile file) {
            boolean isExcel2003 = true;
            InputStream is = null;
            String filePath = file.getOriginalFilename();
            try {
                if (!validateExcel(filePath)) {
                    return null;
                }
                if (isExcel2007(filePath)) {
                    isExcel2003 = false;
                }
                is = file.getInputStream();
                return createExcel(is, isExcel2003);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * 判断是否为excel文件
         *
         * @param filePath
         * @return
         */
        public boolean validateExcel(String filePath) {
            if (null == filePath ||
                    !(isExcel2003(filePath) ||
                            isExcel2007(filePath))) {
                logger.info("文件名不是excel格式");
                return false;
            }
            return true;
        }

        /**
         * 是否是2003的excel，返回true是2003
         *
         * @param filePath
         * @return
         */
        public boolean isExcel2003(String filePath) {
            return filePath.matches("^.+\\.(?i)(xls)$");
        }

        /**
         * 是否是2007的excel，返回true是2007
         *
         * @param filePath
         * @return
         */
        public boolean isExcel2007(String filePath) {
            return filePath.matches("^.+\\.(?i)(xlsx)$");
        }

        /**
         * 创建excel对应的执行器去执行对应的版本
         *
         * @param is
         * @param isExcel2003
         * @return
         */
        public List<Map<String, Object>> createExcel(InputStream is, boolean isExcel2003) {
            try {
                Workbook wb = null;
                if (isExcel2003) {
                    wb = new HSSFWorkbook(is);
                } else {
                    wb = new XSSFWorkbook(is);
                }
                return readExcelValue(wb);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * 处理行(如果第一行不需要的话，可以从i=1开始，第一行作为冻结行)
         *
         * @param wb
         * @return
         */
        private List<Map<String, Object>> readExcelValue(Workbook wb) {
            Sheet sheet = wb.getSheetAt(0);
            List<Map<String, Object>> list = new ArrayList<>();
            //获取的是物理行数，也就是不包括那些空行（隔行）的情况
            this.totalRows = sheet.getPhysicalNumberOfRows();
            if (totalRows > 1 && sheet.getRow(0) != null) {
                this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            }
            List<String> header = getSheetHead(sheet.getRow(0));

            for (int i = 1; i < totalRows; i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                Map<String, Object> p = excelCellHandler(header, row);
                list.add(p);
            }
            return list;
        }

        /**
         * 处理excel头部
         *
         * @param row
         * @return
         */
        private List<String> getSheetHead(Row row) {
            List<String> header = new LinkedList<>();
            for (int i = 0; i < totalCells; i++) {
                Cell cell = row.getCell(i);
                cell.setCellType(CellType.STRING);
                String value = cell.getStringCellValue();
                header.add(value);
            }
            return header;
        }

        /**
         * 处理excel中的列，需要对每一列的值进行相应的处理
         *
         * @param row
         * @return
         */
        private Map<String, Object> excelCellHandler(List<String> header, Row row) {
            Map<String, Object> p = new HashMap();
            for (int i = 0; i < totalCells; i++) {
                Cell cell = row.getCell(i);
                if (null != cell) {
                    cell.setCellType(CellType.STRING);
                    p.put(header.get(i), cell.getStringCellValue());

                }

            }
            return p;
        }
    }
}
