package com.liyang.orchard.utils.verify;
import com.liyang.orchard.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class VerifyCharCodeGenImpl implements VerifyCodeGen {

    private static final Logger logger = LoggerFactory.getLogger(VerifyCharCodeGenImpl.class);
    private static final String[] FONT_TYPES = { "u5b8bu4f53", "u65b0u5b8bu4f53", "u9ed1u4f53", "u6977u4f53", "u96b6u4e66" };
    private static final int VALICATE_CODE_LENGTH = 4;
    /**
     * 设置背景颜色及大小，干扰线
     *
     * @param graphics 绘图
     * @param width 宽
     * @param height 高
     */
    private static void fillBackground(Graphics graphics, int width, int height) {
        // 填充背景
        graphics.setColor(Color.WHITE);
        //设置矩形坐标x y 为0
        graphics.fillRect(0, 0, width, height);
        // 加入干扰线条
        for (int i = 0; i < 8; i++) {
            //设置随机颜色算法参数
            graphics.setColor(RandomUtils.randomColor(40, 150));
            Random random = new Random();
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            graphics.drawLine(x, y, x1, y1);
        }
    }
    /**
     * 验证码生成
     *
     * @param width 宽
     * @param height 高
     * @return verifyCode
     */
    @Override
    public VerifyCode generate(int width, int height) {
        VerifyCode verifyCode = null;
        try (
                //将流的初始化放到这里就不需要手动关闭流
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ) {
            String code = generate(width, height, baos);
            verifyCode = new VerifyCode();
            verifyCode.setCode(code);
            verifyCode.setImgBytes(baos.toByteArray());
        }
        catch (IOException e) {
            logger.error(e.getMessage(), e);
            verifyCode = null;
        }
        return verifyCode;
    }
    /**
     * 生成随机字符
     *
     * @param width 宽
     * @param height 高
     * @param os 流
     * @return randomStr
     * @throws IOException IOE
     */
    @Override
    public String generate(int width, int height, OutputStream os) throws IOException {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        // 生成随机颜色画板
        fillBackground(graphics, width, height);
        // 生成随机字符串
        String randomStr = RandomUtils.randomString(VALICATE_CODE_LENGTH);
        createCharacter(graphics, randomStr);
        // 释放绘板 (此时图片流已保存在image中)
        graphics.dispose();
        //设置JPEG格式
        ImageIO.write(image, "JPEG", os);
        return randomStr;
    }
    /**
     * 设置字符颜色大小
     *
     * @param g 绘图
     * @param randomStr 随机字符
     */
    private void createCharacter(Graphics g, String randomStr) {
        Random random = new Random();
        char[] charArray = randomStr.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            //设置RGB颜色算法参数
            g.setColor(new Color(50 + random.nextInt(100),
                    + random.nextInt(100), 50 + random.nextInt(100)));
            //设置字体大小，类型
            g.setFont(new Font(FONT_TYPES[random.nextInt(FONT_TYPES.length)], Font.BOLD, 26));
            //设置x y 坐标  (并未旋转)
            g.drawString(String.valueOf(charArray[i]), 15 * i + 5, 19 + random.nextInt(8));
        }
    }
}


