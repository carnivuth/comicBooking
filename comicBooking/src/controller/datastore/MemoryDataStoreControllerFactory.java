package controller.datastore;

import controller.interfacce.iPercistance.IDataStore;
import controller.interfacce.iPercistance.IDataStoreFactory;

public class MemoryDataStoreControllerFactory implements IDataStoreFactory {

    @Override
    public IDataStore createInstance() {
       
        return new MemoryDataStoreController();
    }
    
}
