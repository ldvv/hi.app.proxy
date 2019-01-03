package tools.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.service.ToolsService;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ToolsMain {

    private static final Logger logger = LoggerFactory.getLogger(ToolsMain.class);

    //修改之后JSP 文件和property文件保存路径
    private static final String RESULT_PATH = "F:\\mytools\\allFiles";
    //历史property文件
    private static final String PROPERTY_FILE = "F:\\mytools\\allFiles\\key.properties";
    //JSP文件或文件夹
    private static final String JSP_PATH = "E:\\myproject\\tterp_crm_web\\src\\main\\webapp\\WEB-INF\\views\\modules";

    private static ToolsService toolsService = new ToolsService();

    //查询文件中所有的中文
    public static void main(String[] args) throws Exception{
        logger.debug("aaaaaaaaaaa");
        logger.info("aaaaaaaaaaa");
        logger.error("aaaaaaaaaaa");
    }

    private static String flip(String group) {
        if(group == null || "".equals(group)){
            return "";
        }
        StringBuffer result = new StringBuffer();
        char[] charArray = group.toCharArray();

        for (int i=charArray.length-1; i>=0; i--){
            result.append(charArray[i]);
        }

        return result.toString();
    }


    /**
     * 递归遍历文件路径下的所有文件
     *
     * @param path 文件或文件夹路径
     *
     * */
    public static void traverseFolder(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                logger.error("D9999: There are no files!!!");
                return;
            } else {
                for (File f : files) {
                    if (f.isDirectory()) {
                        logger.info("D9999: ==============>Folder :" + f.getAbsolutePath());
                        traverseFolder(f.getAbsolutePath());
                    } else {
                        logger.info("D9999: Operate file ~~~~~~~~~~~~ :" + f.getAbsolutePath());
                        toolsService.internationalization(f.getAbsolutePath(), RESULT_PATH, PROPERTY_FILE);
                    }
                }
            }
        } else {
            logger.info("D9999: File is not Exist");
        }
    }

    /**
     * 递归遍历文件路径下的所有文件,并修改文件内容
     *
     * @param path 文件或文件夹路径
     *
     * */
    public static void replaceKey(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                logger.error("D9999: There are no files!!!");
                return;
            } else {
                for (File f : files) {
                    String dicPath = RESULT_PATH + f.getPath().substring(f.getPath().indexOf("\\modules"), f.getPath().length());
                    if (f.isDirectory()) {
                        logger.info("D9999: ==============>Folder :" + f.getAbsolutePath());
                        //traverseFolder(f.getAbsolutePath());
                        //新建文件夹到目标目录
                        File newFile = new File(dicPath);
                        if(!newFile.exists()){
                            newFile.mkdirs();
                        }
                        replaceKey(f.getAbsolutePath());
                    } else {
                        logger.info("D9999: Operate file ~~~~~~~~~~~~ :" + f.getAbsolutePath());
                        //修改并创建文件
                        boolean result = toolsService.editAndCreate(f.getAbsolutePath(), dicPath, RESULT_PATH, PROPERTY_FILE);

                        if(!result){
                            return;
                        }
                    }
                }
            }
        } else {
            logger.info("D9999: File is not Exist");
        }
    }
}
