package controller.implementazioni.AcquirenteController;

import java.util.List;

import controller.interfacce.iAcquirente.IVisualizzaInteressi;
import model.interessi.Interessi;
import model.user.Acquirente;

public class VisualizzaInteressiController implements IVisualizzaInteressi{

    @Override
    public Interessi getInteressi(Acquirente a) {
        // TODO Auto-generated method stub
        return a.getInteressi();
    }
    
}
