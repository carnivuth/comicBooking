package controller.usersstore;

import controller.interfacce.iPercistance.IUsersStore;
import controller.interfacce.iPercistance.IUsersStoreFactory;

public class MemoryUsersStoreFactory implements IUsersStoreFactory{

    @Override
    public IUsersStore createInstance() {
        return new MemoryUsersStoreController();
    }

}