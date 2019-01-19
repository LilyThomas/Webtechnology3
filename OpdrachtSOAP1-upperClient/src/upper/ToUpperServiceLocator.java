/**
 * ToUpperServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package upper;

public class ToUpperServiceLocator extends org.apache.axis.client.Service implements upper.ToUpperService {

    public ToUpperServiceLocator() {
    }


    public ToUpperServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ToUpperServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ToUpper
    private java.lang.String ToUpper_address = "http://localhost:8080/OpdrachtSOAP1-upper/services/ToUpper";

    public java.lang.String getToUpperAddress() {
        return ToUpper_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ToUpperWSDDServiceName = "ToUpper";

    public java.lang.String getToUpperWSDDServiceName() {
        return ToUpperWSDDServiceName;
    }

    public void setToUpperWSDDServiceName(java.lang.String name) {
        ToUpperWSDDServiceName = name;
    }

    public upper.ToUpper getToUpper() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ToUpper_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getToUpper(endpoint);
    }

    public upper.ToUpper getToUpper(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            upper.ToUpperSoapBindingStub _stub = new upper.ToUpperSoapBindingStub(portAddress, this);
            _stub.setPortName(getToUpperWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setToUpperEndpointAddress(java.lang.String address) {
        ToUpper_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (upper.ToUpper.class.isAssignableFrom(serviceEndpointInterface)) {
                upper.ToUpperSoapBindingStub _stub = new upper.ToUpperSoapBindingStub(new java.net.URL(ToUpper_address), this);
                _stub.setPortName(getToUpperWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ToUpper".equals(inputPortName)) {
            return getToUpper();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://upper", "ToUpperService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://upper", "ToUpper"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ToUpper".equals(portName)) {
            setToUpperEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
