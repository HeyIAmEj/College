import entity.Pessoa;

public class Main {
    public static void main(String[] args) throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setFullname("John Doe Roberto Santos");
        pessoa.setBirthday("02/10/1999");
        pessoa.setDocumentoCPF("66127411041");


        System.out.println("Nome: "+pessoa.getName());
        System.out.println("Sobrenome: "+pessoa.getLastname());
        System.out.println("Nome completo: "+pessoa.getFullname());
        System.out.println("Data de Nascimento: "+pessoa.getBirthday());
        System.out.println("Idade: "+pessoa.getIdade());
        System.out.println("CPF: "+pessoa.getDocumentoCPF());
    }
}
