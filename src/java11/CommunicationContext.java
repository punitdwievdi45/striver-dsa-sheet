package java11;
import java.util.Objects;
import java.util.UUID;

import javax.naming.OperationNotSupportedException;

/**
 *
 * @author kavetiraviteja
 *
 *         <pre>
 *       contains meta-data about request like
 *       correlation id and request context
 *         </pre>
 */
public class CommunicationContext implements Cloneable {

    private CommunicationContext() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("cannot create instance of this object");
    }

    private static ThreadLocal<String> correlationId = new ThreadLocal<>();

    public static String getCorrelationId() {
        return correlationId.get();
    }

    public static void setCorrelationId(final String correlation) {
        correlationId.set(correlation);
    }

    public static void cleanup() {
        correlationId.remove();
    }

    @Override
    public CommunicationContext clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("cloning is not possible on this object");
    }

    public static String generateAndGetCorrelationId(){
        if (Objects.isNull(CommunicationContext.getCorrelationId())) {
            CommunicationContext.setCorrelationId(randomNGenerator());
        }
        return CommunicationContext.getCorrelationId();
    }

    private static String randomNGenerator() {
        return UUID.randomUUID().toString();
    }
}