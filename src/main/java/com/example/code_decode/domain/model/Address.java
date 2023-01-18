package com.example.code_decode.domain.model;

public class Address implements Comparable<Address> {
    public String getStreename() {
        return streename;
    }

    public void setStreename(String streename) {
        this.streename = streename;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streename='" + streename + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }

    public Address(String streename, int pinCode) {
        this.streename = streename;
        this.pinCode = pinCode;
    }

    private String streename;
    private int pinCode;

    @Override
    public int compareTo(Address o) {
        return this.getPinCode() - o.getPinCode();
    }
}
