package quickstart.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.*;

public class ImageUtil {

    private static final Logger log = LoggerFactory.getLogger(ImageUtil.class);

    public static String ImgaeConverterBASE64(String path){

        String ImgaeBASE64=null;
        File file = new File(path);
        long size = file.length();
        byte[] imageByte = new byte[(int)size];
        FileInputStream fis=null;
        BufferedInputStream bis=null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            bis.read(imageByte);
            BASE64Encoder base64Encoder = new BASE64Encoder();
            ImgaeBASE64 = base64Encoder.encode(imageByte);
        } catch (FileNotFoundException e) {
            log.error("文件"+file.getName()+"不能被找到："+e.getMessage());
        } catch (IOException e) {
            log.error("byte转换BASE64出错："+e.getMessage());
        } finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    log.error("关闭输入流出错："+e.getMessage());
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    log.error("关闭输入流出错："+e.getMessage());
                }
            }
        }
        return ImgaeBASE64;
    }

    public static void main(String[] arigs) throws Exception{
        String imgaeBASE64 = ImgaeConverterBASE64("C:\\Users\\Administrator\\Desktop\\pad图片\\田蕾.jpg");

        File file = new File("C:\\Users\\Administrator\\Desktop\\pad图片\\test.txt");
        FileOutputStream out = new FileOutputStream(file);
        out.write(imgaeBASE64.getBytes());

    }
}
