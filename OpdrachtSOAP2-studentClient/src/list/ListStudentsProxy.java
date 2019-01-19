package list;

public class ListStudentsProxy implements list.ListStudents {
  private String _endpoint = null;
  private list.ListStudents listStudents = null;
  
  public ListStudentsProxy() {
    _initListStudentsProxy();
  }
  
  public ListStudentsProxy(String endpoint) {
    _endpoint = endpoint;
    _initListStudentsProxy();
  }
  
  private void _initListStudentsProxy() {
    try {
      listStudents = (new list.ListStudentsServiceLocator()).getListStudents();
      if (listStudents != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)listStudents)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)listStudents)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (listStudents != null)
      ((javax.xml.rpc.Stub)listStudents)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public list.ListStudents getListStudents() {
    if (listStudents == null)
      _initListStudentsProxy();
    return listStudents;
  }
  
  public java.lang.String[] selectAll() throws java.rmi.RemoteException{
    if (listStudents == null)
      _initListStudentsProxy();
    return listStudents.selectAll();
  }
  
  
}