package upper;

public class ToUpperProxy implements upper.ToUpper {
  private String _endpoint = null;
  private upper.ToUpper toUpper = null;
  
  public ToUpperProxy() {
    _initToUpperProxy();
  }
  
  public ToUpperProxy(String endpoint) {
    _endpoint = endpoint;
    _initToUpperProxy();
  }
  
  private void _initToUpperProxy() {
    try {
      toUpper = (new upper.ToUpperServiceLocator()).getToUpper();
      if (toUpper != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)toUpper)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)toUpper)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (toUpper != null)
      ((javax.xml.rpc.Stub)toUpper)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public upper.ToUpper getToUpper() {
    if (toUpper == null)
      _initToUpperProxy();
    return toUpper;
  }
  
  public java.lang.String toUpper(java.lang.String str) throws java.rmi.RemoteException{
    if (toUpper == null)
      _initToUpperProxy();
    return toUpper.toUpper(str);
  }
  
  
}