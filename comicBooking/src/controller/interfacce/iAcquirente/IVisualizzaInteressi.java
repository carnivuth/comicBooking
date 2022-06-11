package controller.interfacce.iAcquirente;

import java.util.List;

import model.interessi.Interessi;
import model.user.Acquirente;

public interface IVisualizzaInteressi {
    public Interessi getInteressi(Acquirente a);
}
