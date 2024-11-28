package microteam.root.Shared;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;

public class ActivityExtensions {

    /**
     * Sets exception tags on the provided OpenTelemetry Span.
     *
     * @param span the active span
     * @param exception the exception to record
     */
    public static void setExceptionTags(Span span, Exception exception) {
        if (span == null || exception == null) {
            return;
        }

        // Add exception details as span attributes
        span.setAttribute("exception.message", exception.getMessage());
        span.setAttribute("exception.stacktrace", getStackTraceAsString(exception));
        span.setAttribute("exception.type", exception.getClass().getName());

        // Mark span as an error
        span.setStatus(StatusCode.ERROR);
    }

    /**
     * Converts an exception's stack trace to a string.
     *
     * @param exception the exception
     * @return the stack trace as a string
     */
    private static String getStackTraceAsString(Exception exception) {
        StringBuilder result = new StringBuilder();
        for (StackTraceElement element : exception.getStackTrace()) {
            result.append(element.toString()).append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
