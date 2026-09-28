import java.util.UUID;

public class Aluno {

    private UUID uuid;
    private String nome;
    private int idade;
    private String endereco;

    //Construtores
    public Aluno() {
        this.uuid = UUID.randomUUID();
    }

    public Aluno(String nome, int idade, String endereco) {
        this.uuid = UUID.randomUUID();
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    //Getters
    public UUID getUuid() {
        return uuid;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    //Setters
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}


//Gustavo Cardoso Muniz e Izadora Santos Silva