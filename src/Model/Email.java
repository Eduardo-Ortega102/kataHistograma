package Model;

public class Email {
    private String address;

    public Email(String addres) {
        this.address = addres;
    }

    public String getAddress() {
        return address;
    }
    
    public String getDomain(){
        return address.split("@")[1];
    }
    
}
