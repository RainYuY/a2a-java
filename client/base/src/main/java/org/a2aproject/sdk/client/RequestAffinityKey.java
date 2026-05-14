package org.a2aproject.sdk.client;

import org.a2aproject.sdk.spec.CancelTaskParams;
import org.a2aproject.sdk.spec.DeleteTaskPushNotificationConfigParams;
import org.a2aproject.sdk.spec.GetExtendedAgentCardParams;
import org.a2aproject.sdk.spec.GetTaskPushNotificationConfigParams;
import org.a2aproject.sdk.spec.ListTaskPushNotificationConfigsParams;
import org.a2aproject.sdk.spec.ListTasksParams;
import org.a2aproject.sdk.spec.MessageSendParams;
import org.a2aproject.sdk.spec.TaskIdParams;
import org.a2aproject.sdk.spec.TaskPushNotificationConfig;
import org.a2aproject.sdk.spec.TaskQueryParams;
import org.jspecify.annotations.Nullable;

final class RequestAffinityKey {
    private RequestAffinityKey() {
    }

    static @Nullable String from(@Nullable Object request) {
        if (request instanceof MessageSendParams params) {
            return firstNonBlank(
                    params.message().taskId(),
                    params.message().contextId(),
                    params.message().messageId());
        }
        if (request instanceof TaskQueryParams params) {
            return params.id();
        }
        if (request instanceof CancelTaskParams params) {
            return params.id();
        }
        if (request instanceof TaskIdParams params) {
            return params.id();
        }
        if (request instanceof TaskPushNotificationConfig config) {
            return firstNonBlank(config.taskId(), config.id());
        }
        if (request instanceof GetTaskPushNotificationConfigParams params) {
            return firstNonBlank(params.taskId(), params.id());
        }
        if (request instanceof ListTaskPushNotificationConfigsParams params) {
            return params.id();
        }
        if (request instanceof DeleteTaskPushNotificationConfigParams params) {
            return firstNonBlank(params.taskId(), params.id());
        }
        if (request instanceof ListTasksParams params) {
            return params.contextId();
        }
        if (request instanceof GetExtendedAgentCardParams params) {
            return params.tenant();
        }
        return null;
    }

    private static @Nullable String firstNonBlank(@Nullable String... values) {
        for (String value : values) {
            if (value != null && !value.isBlank()) {
                return value;
            }
        }
        return null;
    }
}
