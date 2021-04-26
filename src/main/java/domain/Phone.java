package domain;

public class Phone {
    private int phoneID;
    private String phonemodel;
    private String phonecpu;
    private String phonename;

    public Phone(){}

    public Phone(int phoneID, String phonemodel, String phonecpu, String phonename) {
        this.phoneID = phoneID;
        this.phonemodel = phonemodel;
        this.phonecpu = phonecpu;
        this.phonename = phonename;
    }

    public int getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(int phoneID) {
        this.phoneID = phoneID;
    }

    public String getPhonemodel() {
        return phonemodel;
    }

    public void setPhonemodel(String phonemodel) {
        this.phonemodel = phonemodel;
    }

    public String getPhonecpu() {
        return phonecpu;
    }

    public void setPhonecpu(String phonecpu) {
        this.phonecpu = phonecpu;
    }

    public String getPhonename() {
        return phonename;
    }

    public void setPhonename(String phonename) {
        this.phonename = phonename;
    }
}
