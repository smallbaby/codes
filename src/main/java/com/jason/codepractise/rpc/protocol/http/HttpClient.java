package com.jason.codepractise.rpc.protocol.http;

import com.jason.codepractise.rpc.framework.Invocation;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * author: zhangkai
 * date: 2019-08-31
 * description:
 */
public class HttpClient {
    public String send(String hostname, Integer port, Invocation invocation) {

        try {
            URL url = new URL("http", hostname, port, "/");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            oos.writeObject(invocation);

            oos.flush();
            oos.close();

            return null;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
