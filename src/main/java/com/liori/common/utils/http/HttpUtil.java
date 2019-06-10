package com.liori.common.utils.http;

import com.liori.common.exceptions.CustomizeServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>Http 请求工具类</p>
 * <b>created on 2019-01-03 21:21:43</b>
 *
 * @author liori
 * @since springboot-mybatis-0.0.1-SNAPSHOT
 */
public class HttpUtil {

    private final static Logger LOG = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url    请求的链接
     * @param params 请求参数应该是 name1=value1&name2=value2 的形式
     * @return 请求结果
     */
    public static String doGet(String url, String params) {
        String urlWithParams = url + "?" + params;
        URLConnection connection = getUrlConnection(urlWithParams);
        try {
            // 建立实际的连接
            connection.connect();
            return getRequestResult(connection);
        } catch (IOException e) {
            LOG.error("doGet 请求异常：\n" + e);
            throw new CustomizeServiceException("doGet 请求异常：\n" + e);
        }
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url    请求的链接
     * @param params 请求参数应该是 name1=value1&name2=value2 的形式
     * @return 请求结果
     */
    public static String doPost(String url, String params) {
        URLConnection connection = getUrlConnection(url);
        // 发送POST请求必须设置如下两行
        connection.setDoOutput(true);
        connection.setDoInput(true);
        // 获取URLConnection对象对应的输出流
        try (PrintWriter printWriter = new PrintWriter(connection.getOutputStream());) {
            // 发送请求参数
            printWriter.print(params);
            // flush 输出流的缓冲
            printWriter.flush();
            return getRequestResult(connection);
        } catch (IOException e) {
            LOG.error("doPost 请求异常：\n" + e);
            throw new CustomizeServiceException("doPost 请求异常");
        }
    }

    private static URLConnection getUrlConnection(String urlWithParams) {
        try {
            URL realUrl = new URL(urlWithParams);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            return connection;
        } catch (IOException e) {
            LOG.error("打开URL连接时出现异常：\n" + e);
            throw new CustomizeServiceException("打开URL连接时出现异常");
        }
    }

    private static String getRequestResult(URLConnection connection) {
        // 定义 BufferedReader 输入流来读取URL的响应
        try (InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream(), "UTF-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException e) {
            LOG.error("读取URL的响应时出现异常：\n" + e);
            throw new CustomizeServiceException("读取URL的响应时出现异常：\n" + e);
        }
    }
}
