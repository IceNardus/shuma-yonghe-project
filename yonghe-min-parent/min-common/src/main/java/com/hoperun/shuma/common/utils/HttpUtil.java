package com.hoperun.shuma.common.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
public class HttpUtil {
    private static PoolingHttpClientConnectionManager cm;
    private static String EMPTY_STR = "";
    private static String UTF_8 = "UTF-8";

    public HttpUtil() {
        init(20, 5);
    }

    public HttpUtil(int maxTotal, int maxPerRoute) {
        init(maxTotal, maxPerRoute);
    }

    /**
     * 初始化
     * @param maxTotal      最大连接数
     * @param maxPerRoute   每个路由最大连接数
     */
    private synchronized void init(int maxTotal, int maxPerRoute) {
        if (null == cm) {
            cm = new PoolingHttpClientConnectionManager();
            cm.setMaxTotal(maxTotal);// 整个连接池最大连接数
            cm.setDefaultMaxPerRoute(maxPerRoute);// 每路由最大连接数，默认值是2
        }
    }

    private static CloseableHttpClient getHttpClient() {
        return HttpClients.custom().setConnectionManager(cm).build();
    }

    /**
     * 设置请求头
     * @param http      发送的HTTP请求
     * @param headers   请求头
     * @return          发送的HTTP请求
     */
    public static HttpRequestBase setHeaders(HttpRequestBase http, Map<String, Object> headers) {
        if (null != headers) {
            for (Map.Entry<String, Object> param : headers.entrySet()) {
                http.addHeader(param.getKey(), String.valueOf(param.getValue()));
            }
        }
        return http;
    }

    /**
     * 将参数转为特定格式
     * @param params    参数
     * @return
     */
    public static ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        if (null != params) {
            for (Map.Entry<String, Object> param : params.entrySet()) {
                pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
            }
        }
        return pairs;
    }

    /**
     * 处理Http请求
     *
     * @param request
     * @return
     */
    public static String getResult(HttpRequestBase request) {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                response.close();
                log.info("请求结果为:{}",result);
                return result;
            }
        } catch (ClientProtocolException e) {
            e.getStackTrace();
            log.error(e.getMessage(),e);
        } catch (IOException e) {
            e.getStackTrace();
            log.error(e.getMessage(),e);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.getStackTrace();
                log.error(e.getMessage(),e);
            }
        }

        return EMPTY_STR;
    }

    /**
     * some http bean just return the headers. such as head
     * @param request
     * @return
     */
    private Header[] getHeaders(HttpRequestBase request) {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
            return response.getAllHeaders();
        } catch (ClientProtocolException e) {
            e.getStackTrace();
            log.error(e.getMessage(),e);
        } catch (IOException e) {
            e.getStackTrace();
            log.error(e.getMessage(),e);
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.getStackTrace();
                log.error(e.getMessage(),e);
            }
        }
        return null;
    }

    /**
     *  发送GET请求
     * @param url  请求路径
     * @return      请求结果
     * @throws URISyntaxException
     */
    public static String get(String url) throws URISyntaxException {
        return get(url, null);
    }

    /**
     *  发送GET请求
     * @param url       请求路径
     * @param params    请求参数
     * @return          请求结果
     * @throws URISyntaxException
     */
    public static String get(String url, Map<String, Object> params) throws URISyntaxException {
        return get(url, null, params);
    }

    /**
     *  发送GET请求
     * @param url       请求路径
     * @param headers   请求头
     * @param params    请求参数
     * @return          请求结果
     * @throws URISyntaxException
     */
    public static String get(String url, Map<String, Object> headers, Map<String, Object> params) throws URISyntaxException {
        log.info("请求地址为:{},参数为:{},Heads为:{}",url,params,headers);
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        //设置参数
        ub.setParameters(covertParams2NVPS(params));
        HttpGet httpGet = new HttpGet(ub.build());
        //设置请求头
        httpGet = (HttpGet) setHeaders(httpGet, headers);

        return getResult(httpGet);
    }

    /**
     * 发送POST请求
     * @param url   请求路径
     * @return      请求结果
     * @throws UnsupportedEncodingException
     */
    public static String post(String url) throws UnsupportedEncodingException {
        return post(url, null);
    }

    /**
     * 发送POST请求
     * @param url       请求路径
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     */
    public static String post(String url, Map<String, Object> params) throws UnsupportedEncodingException {
        return post(url, null, params);
    }

    /**
     * 发送POST请求
     * @param url       请求路径
     * @param headers   请求头
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     */
    public static String post(String url, Map<String, Object> headers, Map<String, Object> params) throws UnsupportedEncodingException {
        log.info("请求地址为:{},参数为:{},Heads为:{}",url,params,headers);
        HttpPost httpPost = new HttpPost(url);
        //设置参数
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        //设置请求头
        httpPost = (HttpPost) setHeaders(httpPost, headers);
        return getResult(httpPost);
    }

    /**
     * 发送PUT请求
     * @param url   请求路径
     * @return      请求结果
     * @throws UnsupportedEncodingException
     */
    public String put(String url) throws UnsupportedEncodingException {
        return put(url, null);
    }

    /**
     * 发送PUT请求
     * @param url       请求路径
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     */
    public String put(String url, Map<String, Object> params) throws UnsupportedEncodingException {
        return put(url, null, params);
    }

    /**
     * 发送PUT请求
     * @param url       请求路径
     * @param headers   请求头
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     */
    public String put(String url, Map<String, Object> headers, Map<String, Object> params) throws UnsupportedEncodingException {
        HttpPut httpPut = new HttpPut(url);
        //设置请求参数
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPut.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        //设置请求头
        httpPut = (HttpPut) setHeaders(httpPut, headers);

        return getResult(httpPut);
    }

    /**
     * 发送PATCH请求
     * @param url   请求路径
     * @return      请求结果
     * @throws UnsupportedEncodingException
     */
    public String patch(String url) throws UnsupportedEncodingException {
        return patch(url, null);
    }

    /**
     * 发送PATCH请求
     * @param url       请求路径
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     */
    public String patch(String url, Map<String, Object> params) throws UnsupportedEncodingException {
        return patch(url, null, params);
    }

    /**
     * post请求
     * @param url
     * @param json
     * @return
     */
    public static String doPost(String url, JSONObject json, int rTimeOut, int sTimeOut, Map<String, Object> headers) throws Exception{
        log.info("请求地址为:{},参数为:{},Heads为:{}",url,json,headers);
        DefaultHttpClient client = new DefaultHttpClient();
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, rTimeOut);
        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, sTimeOut);
        HttpPost post = new HttpPost(url);
        for (Map.Entry<String, Object> entry : headers.entrySet()) {
            post.setHeader(entry.getKey(),entry.getValue()+"");
        }
        String response = null;

            StringEntity s = new StringEntity(json.toJSONString(),"utf-8");
            s.setContentEncoding("UTF-8");
            //发送json数据需要设置contentType
            s.setContentType("application/json");
            post.setEntity(s);
            HttpResponse res = client.execute(post);

            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());
                log.info("请求结果为:{}",result);
                return  result;
            }

        return response;
    }

    /**
     * 发送PATCH请求
     * @param url       请求路径
     * @param headers   请求头
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     */
    public String patch(String url, Map<String, Object> headers, Map<String, Object> params) throws UnsupportedEncodingException {
        HttpPatch httpPatch = new HttpPatch(url);
        //设置请求参数
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPatch.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        //设置请求头
        httpPatch = (HttpPatch) setHeaders(httpPatch, headers);

        return getResult(httpPatch);
    }

    /**
     * 发送DELETE请求
     * @param url   请求路径
     * @return      请求结果
     * @throws UnsupportedEncodingException
     */
    public String delete(String url) throws UnsupportedEncodingException, URISyntaxException {
        return delete(url, null);
    }

    /**
     * 发送DELETE请求
     * @param url       请求路径
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public String delete(String url, Map<String, Object> params) throws UnsupportedEncodingException, URISyntaxException {
        return delete(url, null, params);
    }

    /**
     * 发送DELETE请求
     * @param url       请求路径
     * @param headers   请求头
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     */
    public String delete(String url, Map<String, Object> headers, Map<String, Object> params) throws UnsupportedEncodingException, URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        //设置请求参数
        ub.addParameters(covertParams2NVPS(params));
        HttpDelete httpDelete = new HttpDelete(ub.build());
        //设置请求头
        httpDelete = (HttpDelete) setHeaders(httpDelete, headers);

        return getResult(httpDelete);
    }

    /**
     * 发送TRACE请求
     * 回显服务器收到的请求，主要用于测试或诊断。
     * @param url       请求路径
     * @return          请求结果
     * @throws UnsupportedEncodingException
     */
    public String trace(String url) throws UnsupportedEncodingException, URISyntaxException {
        return trace(url, null);
    }

    /**
     * 发送TRACE请求
     * 回显服务器收到的请求，主要用于测试或诊断
     * @param url       请求路径
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     */
    public String trace(String url, Map<String, Object> params) throws UnsupportedEncodingException, URISyntaxException {
        return trace(url, null, params);
    }

    /**
     * 发送TRACE请求
     * 回显服务器收到的请求，主要用于测试或诊断
     * @param url       请求路径
     * @param headers   请求头
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     */
    public String trace(String url, Map<String, Object> headers, Map<String, Object> params) throws UnsupportedEncodingException, URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        //设置请求参数
        ub.setParameters(covertParams2NVPS(params));
        HttpTrace httpTrace = new HttpTrace(ub.build());
        //设置请求头
        httpTrace = (HttpTrace) setHeaders(httpTrace, headers);

        return getResult(httpTrace);
    }

    /**
     * 发送HEAD请求
     * 类似于get请求，只不过返回的响应中没有具体的内容，用于获取报头
     * @param url   请求路径
     * @return      请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public Header[] head(String url) throws UnsupportedEncodingException, URISyntaxException {
        return head(url, null);
    }

    /**
     * 发送HEAD请求
     * 类似于get请求，只不过返回的响应中没有具体的内容，用于获取报头
     * @param url       请求路径
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public Header[] head(String url, Map<String, Object> params) throws UnsupportedEncodingException, URISyntaxException {
        return head(url, null, params);
    }

    /**
     * 发送HEAD请求
     * 类似于get请求，只不过返回的响应中没有具体的内容，用于获取报头
     * @param url       请求路径
     * @param headers   请求头
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public Header[] head(String url, Map<String, Object> headers, Map<String, Object> params) throws UnsupportedEncodingException, URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        //设置请求参数
        ub.setParameters(covertParams2NVPS(params));
        HttpHead httpHead = new HttpHead(ub.build());
        //设置请求头
        httpHead = (HttpHead) setHeaders(httpHead, headers);

        return getHeaders(httpHead);
    }

    /**
     * 发送OPTIONS请求
     * 允许客户端查看服务器的性能
     * @param url   请求路径
     * @return      请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public String options(String url) throws UnsupportedEncodingException, URISyntaxException {
        return options(url, null);
    }

    /**
     * 发送OPTIONS请求
     * 允许客户端查看服务器的性能
     * @param url       请求路径
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public String options(String url, Map<String, Object> params) throws UnsupportedEncodingException, URISyntaxException {
        return options(url, null, params);
    }

    /**
     * 发送OPTIONS请求
     * 允许客户端查看服务器的性能
     * @param url       请求路径
     * @param headers   请求头
     * @param params    请求参数
     * @return          请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public String options(String url, Map<String, Object> headers, Map<String, Object> params) throws UnsupportedEncodingException, URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        //设置参数
        ub.setParameters(covertParams2NVPS(params));
        HttpOptions httpOptions = new HttpOptions(ub.build());
        //设置请求头
        httpOptions = (HttpOptions) setHeaders(httpOptions, headers);

        return getResult(httpOptions);
    }

}