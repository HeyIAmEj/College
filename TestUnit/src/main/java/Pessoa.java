import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String name;
    private String lastname;
    private String fullname;

    private LocalDate birthday;
    private Integer idade;

    private String documentoCPF;


    public Pessoa(String fullname, LocalDate birthday) {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
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

    public void setDocumentoCPF(String documentoCPF) {
        try{
            switch (documentoCPF.length()){
                case 11:
                    // without points
                    break;
                case 14:
                    // with points
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            System.out.println("Invalid CPF input");
        }
        this.documentoCPF = documentoCPF;
    }
}
