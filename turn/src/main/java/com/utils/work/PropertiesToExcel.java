package com.utils.work;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author 杨鹏
 */
public class PropertiesToExcel {

    private static int num = 0;

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("begin time at " + new Date());
        File file = new File("E:\\temp\\turn\\src\\main\\resources\\com.utils.temp\\origin.properties");
        transformProperitesToExcel(file);
        System.out.println("end time at " + new Date());
        export("E:\\temp\\shop.xls");
    }





    public static void readPropertiesToExecl(File file, String path) throws IOException {
        // TODO Auto-generated method stub
        Properties properties = new Properties();
        InputStream inStream;
        inStream = new FileInputStream(file);
        /**
         * @author 杨鹏
         * 解决乱码
         */
        InputStreamReader inputStreamReader = new InputStreamReader(inStream,"gbk");
        properties.load(inputStreamReader);
        Enumeration enumeration = properties.propertyNames();
        System.out.println(" 开始导出Excel文件 ");
        XLSExport xlsExport = new XLSExport(path);

        int i = 0;
        while (enumeration.hasMoreElements()) {
            String ele = (String) enumeration.nextElement();
            xlsExport.createRow(i);
            xlsExport.setCell(0, ele);
            xlsExport.setCell(1, properties.getProperty(ele));
            i++;
        }
        try {
            xlsExport.exportXLS(path);    //导出成excel文件
            System.out.println(" 导出Excel文件[成功] ");
        } catch (Exception e1) {
            System.out.println(" 导出Excel文件[失败] ");
            e1.printStackTrace();
        }finally {
            inputStreamReader.close();
        }

    }





    /**
     * 读取file目录下所有文件
     */

    public static void transformProperitesToExcel(File file) throws IOException {

        if (file.isDirectory()) {
            File[] subFile = file.listFiles();
            if (subFile.length == 0) {
                file.delete();
            }
            for (int i = 0; i < subFile.length; i++) {
                transformProperitesToExcel(subFile[i]);
            }
        } else {
            if ((!file.getName().endsWith(".PROPERTIES") && !file.getName().endsWith(".properties"))) {
               return;
            } else {
                String path = file.getAbsolutePath().substring(0,
                        file.getAbsolutePath().lastIndexOf('\\'));
                System.out.println(num + " 、转换文件：" + file.getAbsolutePath());
                num++;
                //转换后相应的xls文件目录
                path = path + "\\packageExcel.xls";
                readPropertiesToExecl(file, path);
            }
        }
    }



    public static void export(String file) {
        System.out.println(" 开始导出Excel文件 ");
        XLSExport e = new XLSExport(file);
        try {
            e.createRow(0);
            e.setCell(0, " 编号 ");
            e.setCell(1, " 名称 ");
            e.exportXLS(file);
            System.out.println(" 导出Excel文件[成功] ");
        } catch (Exception e1) {
            System.out.println(" 导出Excel文件[失败] ");
            e1.printStackTrace();
        }
    }

}
