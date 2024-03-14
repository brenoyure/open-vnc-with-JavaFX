package br.albatross.open.vnc.services.configurations;

public interface Configuration {

    void saveUser(String username);
    void savePassword(String plainTextPassword);

    String getUser();
    String getPassword();

}