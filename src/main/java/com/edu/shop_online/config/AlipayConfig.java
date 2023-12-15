package com.edu.shop_online.config;

import java.io.FileWriter;
import java.io.IOException;
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "9021000129635207";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDYDpuO+ItS/4bcnEZmam6B7d/2Ufi78LGZChA3eA8G3dtrc1qxiS6O8lAjjixUrmOtfPSpdsihK79S/3V2g13KktH60HSgMRH5Ht76AMkbSFdI3J3xTuuKt41gmkoyGoD8TwKu9blVnKRNg8lkn2/uDKSihkjDq3n3c5ZeJEmJjS9gpX6FeXtcj16mqWfhiELJFf5CGg6CB4AzEO/ulVOS+XtIRe1r1ZJjcggR8t67vh0ZYKD9WF3MiPEC4wpQNDWpw+Q/qFktLKRZ54VsFqQECDO1BHLKpXvqwU+BW3Ef+nsVk9isTiJaBMTKGL9LSglelneW/k+rAiMNCrgkWU2/AgMBAAECggEBALOocfIQ+smpcZtA18mR9xJTm0hYIV0maIe5toJpcxVipnJTGbdHO0/iboEiV/qSiJBat5ezDmH23sFFa4eA9RzduX22mUQbibZ91SxOOuxU2z/bM/rUhUh0GTubENdY8qjbin+yFMr71iQe0fi6G3j3Sm9a+ma60FDT7NWblwqos7VpKZpKvNRqh6dAX2q/vj1phIYGBwBcpxdLlX4Oc85me1lAroVtgCltMVf7x4DF021rLjrJstWPI0OXl+czfDE0qEWpzu3kTZNuhUZ+TKZHIqPvJGRkliWkeyChf1/g1/rJhl4kjghu0EKfTmXUD10m55tfUfNkc5hedt/WtgECgYEA/vXatPjUU5f9R/4PDQvWGIIsLpwLvYUOWfezZZHL2F03xwOW4+7deIKQK1HWaiETMEvGdtAv97AF4yRFZ+EroJFdrsShXhYPGMP2wAHCpGUNr7WGg7Mag31Pm74hK0ot5JJr5tfjWPBPal3Oo3ftQBRyr3zV3GlDLkryhnP95DcCgYEA2PAkr2CBRRW14kM/YMug1fWNWnlcRdWSSx4dcV0Rs+WC0sj8kTN62xYIq5IM+YGASem4GXZnK30pC2BeXqTLr4e1nC2GqJobT8vGQ5aBm1WHLQ8xOunNcFZR1IJN0JOn8ofPGS2oXKsdHEH5wZuUwdfKKrQOYbtAgGxTWYhOrrkCgYBhxo0qK+bZbAdBDahd+3UOjxU8hrFl69n2HK0avY/sGMukMbczEE60wXVid47/wlFmixjARdSvazzGwAkx7kNZ34WK2XN87n65o6VEOyiW/P4DrVy5svzvAiZ+dqqnvFnfN1vT+mUAnaAHDZSKUhqVIYJd1ET7sw6FeU6Ky37JfwKBgQDKJRtKAFb0lQJiz97ix1wbgzAwOh3tRNGJBYrR87NnOlnpKDeQ5bN5KtLxbKqCZFWyigJuV5JTR9FTNH07G7xg18g2u4Va3h7NAEjC+h/TKqNHLXzmNK6mGwktSC5SSQSaTkqAX7cegqQhjKi568t1xSoxGI6+Ksoz4LzaFNWcoQKBgDQpH1tuJGej8ynruCgvyqseewfVjcO0aAzEoAs6NeXmzhVhTMwODKXUnYzfpXuQdmeOjJHObSyaRbycVTqKtD4Pj21Gcv9mcuTpWzrLNB4NjUxiVjntVyeCl9rRxPA0AP7akpSTansWxE1fT28hzwqw1VOMVc9ZbgdSr308XuPb";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvU24NSws3kkIywUxT7JKw2S9ARy/2iWhV6SuL0ALnkreoveklWfgGFjfqRaJTft1CKS7xEVRozbAeC28yakFwq8mkZPdolAZO9PxejLtPEg4knRWXbvI2gdki7fxox3vmoYFnhxjlPP0Nsicp2yVNme+ofnn9rFfoqk9WdRVgCJkzprwNAo9q/WgILZLBygictYPa1tKt9vLEBb/Gj4MZiOEoTQRyTW+RFC10kY7fZI6aZ8Rqquek9NAfLl0PBYfG5QotzVDRRvcaKK8/7I0vTohiwFWq9QOd/UJvwRGU4oqJ9zLcVgqecaq5+ZrQmRSUe+y6Lq2yI/2tPVQVrukxwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:5173/";
//    public static String return_url = "http://localhost:5173/order/" + System.currentTimeMillis();

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
