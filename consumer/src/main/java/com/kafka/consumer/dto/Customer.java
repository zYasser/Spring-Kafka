package com.kafka.consumer.dto;


public class Customer {
    private int id;
    private String name ;
    private String email;
    private String contactNo;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
