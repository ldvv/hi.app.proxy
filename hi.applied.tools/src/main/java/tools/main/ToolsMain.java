package tools.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.service.ToolsService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static void main(String[] args) {
        //traverseFolder(JSP_PATH);
        //replaceKey(JSP_PATH);
        /*String str ="45abc,+de==fg";
        String str1 = str;

        Map<String, String> replace = new HashMap<String, String>();
        Pattern patternNotes = Pattern.compile("([a-z]|[A-Z]){2,}");
        Matcher matcherNotes = patternNotes.matcher(str1);
        while(matcherNotes.find()){
            String group = matcherNotes.group();
            str1 = str1.replaceFirst(group, "");
            replace.put(group, flip(group));
            matcherNotes = patternNotes.matcher(str1);
        }

        for (Map.Entry<String, String> entry : replace.entrySet()) {
            str = str.replace(entry.getKey(), entry.getValue());
        }

        System.out.println(str);*/
        double d = 114.145;
        d = (double) Math.round(d * 100) / 100;
        System.out.println(d);

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
