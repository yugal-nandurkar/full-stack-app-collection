package microteam.root.Shared;

import io.opentelemetry.api.trace.Span;

public class ExampleService {
    public void performOperation() {
        Span span = Span.current();
        try {
            // Some operation that might throw an exception
            throw new RuntimeException("Sample error");
        } catch (Exception ex) {
            ActivityExtensions.setExceptionTags(span, ex);
            throw ex; // Optional: re-throw the exception
        }
    }
}
