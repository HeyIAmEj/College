package entity;

import validation.DocumentCPF;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String name;
    private String lastname;
    private String fullname;

    private LocalDate birthday;
    private Integer idade;

    private String documentoCPF;

    public Pessoa() {
    }

    public Pessoa(String fullname, String birthday) {
        setFullname(fullname);
        setBirthday(birthday);
    }

    public Pessoa(String fullname) {
        setFullname(fullname);
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;

        String[] splitted = fullname.split(" ");

        this.name = splitted[0];;
        this.lastname = splitted[splitted.length-1];
    }

    public String getBirthday() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String birthdayStr = birthday.format(formatter);
        return birthdayStr;
    }

    public void setBirthday(String birthdayStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = LocalDate.parse(birthdayStr, formatter);
        this.birthday = birthday;

        LocalDate dataAtual = LocalDate.now();
        this.idade = Period.between(birthday, dataAtual).getYears();
    }

    public Integer getIdade() {
        return idade;
    }

    public String getDocumentoCPF() {
        return documentoCPF;
    }

    public void setDocumentoCPF(String documentoCPF) throws Exception {
        // Recebe CPF sem pontuações
        documentoCPF = documentoCPF
                .replace(".", "")
                .replace("-", "");

        DocumentCPF documentCPF = new DocumentCPF(documentoCPF);
        if (documentCPF.verify()) {
            this.documentoCPF = documentCPF.imprimeCPF(documentoCPF);
        }else{
            throw new Exception("Invalid CPF Input");
        }
    }
}
