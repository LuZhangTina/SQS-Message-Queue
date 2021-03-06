package com.example;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by tina on 2019/2/4.
 */
public class QueueProperties {
    private static final int MAX_TIMEOUT_SECONDS = 43200;
    private static final int MIN_TIMEOUT_SECONDS = 0;
    private static final int DEFAULT_TIMEOUT_SECONDS = 30;

    public static int getMaxVisibilityTimeout() {
        return MAX_TIMEOUT_SECONDS;
    }

    public static int getMinVisibilityTimeout() {
        return MIN_TIMEOUT_SECONDS;
    }

    public static int getDefaultVisibilityTimeout() {
        return DEFAULT_TIMEOUT_SECONDS;
    }

    public static int getMsgVisibilityTimeout(Integer... visibilityTimeout) {
        int msgVisibilityTimeout = getDefaultVisibilityTimeout();
        if (visibilityTimeout.length == 1
                && visibilityTimeout[0] >= QueueProperties.getMinVisibilityTimeout()
                && visibilityTimeout[0] <= QueueProperties.getMaxVisibilityTimeout()) {
            msgVisibilityTimeout = visibilityTimeout[0];
        }

        return msgVisibilityTimeout;
    }

    public static Date createVisibleDate(int visibleTimeout) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, visibleTimeout);
        return calendar.getTime();
    }

    public static String getQueueNameByUrl(String queueUrl) {
        if (queueUrl == null) {
            return null;
        }

        int index = queueUrl.lastIndexOf('/');
        if (index == -1) {
            return null;
        }

        String queueName = queueUrl.substring(index + 1);
        return queueName;
    }
}
