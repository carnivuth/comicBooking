package controller.implementazioni.AcquirenteController;



import controller.interfacce.iAcquirente.IVisualizzaInteressi;
import model.interessi.Interessi;
import model.user.Acquirente;

public class VisualizzaInteressiController implements IVisualizzaInteressi{

    @Override
    public Interessi getInteressi(Acquirente a) {
        
        return a.getInteressi();
    }
    
}
