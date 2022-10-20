package model.log;

public class EntryAlert extends Entry{

    private String causaAlert;

    public EntryAlert(){}


    public String getCausaAlert() {
        return this.causaAlert;
    }

    public void setCausaAlert(String causaAlert) {
        this.causaAlert = causaAlert;
    }


}