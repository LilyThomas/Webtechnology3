/**
 * ListStudentsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package list;

public class ListStudentsServiceLocator extends org.apache.axis.client.Service implements list.ListStudentsService {

    public ListStudentsServiceLocator() {
    }


    public ListStudentsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ListStudentsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ListStudents
    private java.lang.String ListStudents_address = "http://localhost:8080/OpdrachtSOAP2-student/services/ListStudents";

    public java.lang.String getListStudentsAddress() {
        return ListStudents_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ListStudentsWSDDServiceName = "ListStudents";

    public java.lang.String getListStudentsWSDDServiceName() {
        return ListStudentsWSDDServiceName;
    }

    public void setListStudentsWSDDServiceName(java.lang.String name) {
        ListStudentsWSDDServiceName = name;
    }

    public list.ListStudents getListStudents() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ListStudents_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getListStudents(endpoint);
    }

    public list.ListStudents getListStudents(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            list.ListStudentsSoapBindingStub _stub = new list.ListStudentsSoapBindingStub(portAddress, this);
            _stub.setPortName(getListStudentsWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setListStudentsEndpointAddress(java.lang.String address) {
        ListStudents_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (list.ListStudents.class.isAssignableFrom(serviceEndpointInterface)) {
                list.ListStudentsSoapBindingStub _stub = new list.ListStudentsSoapBindingStub(new java.net.URL(ListStudents_address), this);
                _stub.setPortName(getListStudentsWSDDServiceName());
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
        if ("ListStudents".equals(inputPortName)) {
            return getListStudents();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://list", "ListStudentsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://list", "ListStudents"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ListStudents".equals(portName)) {
            setListStudentsEndpointAddress(address);
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
