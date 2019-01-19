/**
 * ToUpperService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package upper;

public interface ToUpperService extends javax.xml.rpc.Service {
    public java.lang.String getToUpperAddress();

    public upper.ToUpper getToUpper() throws javax.xml.rpc.ServiceException;

    public upper.ToUpper getToUpper(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
