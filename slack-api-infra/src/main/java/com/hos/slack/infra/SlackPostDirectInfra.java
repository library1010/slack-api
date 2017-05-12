package com.hos.slack.infra;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hos.slack.json.JsonServerMessage;

public class SlackPostDirectInfra {
    private static final Logger LOGGER = LoggerFactory.getLogger(SlackPostDirectInfra.class);

    public void post(JsonServerMessage serverMessage) {
        HttpPost httpPost = new HttpPost(getUrl());
        httpPost.setEntity(new StringEntity(serverMessage.getStringEntity(), ContentType.create("application/json", "UTF-8")));

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            internalRequest(httpPost, httpClient);
        } catch (IOException e) {
            getLogger().error("Problem occurs when get the response, or connect to server to get data.", e);
        }
    }

    private void internalRequest(HttpRequestBase httpRequest, CloseableHttpClient httpClient) {
        try (CloseableHttpResponse response = httpClient.execute(httpRequest)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (!isSuccessStatus(statusCode)) {
                getLogger().error("Cannot send data to " + getUrl() + " server! The receive status code: " + statusCode);
                getLogger().error(response.getEntity().toString());
            }
            readResponseContent(response);
        } catch (IOException e) {
            getLogger().error("Problem occurs when get the response data.", e);
        }
    }

    private void readResponseContent(CloseableHttpResponse response) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
            getLogger().info(reader.lines().collect(joining("\n")));
        } catch (UnsupportedOperationException | IOException e) {
            getLogger().error("Error when reading response content", e);
        }
    }

    private Logger getLogger() {
        return LOGGER;
    }

    protected String getUrl() {
        return "https://hooks.slack.com/services/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";
    }

    private boolean isSuccessStatus(int statusCode) {
        return statusCode / 100 == 2;
    }
}
