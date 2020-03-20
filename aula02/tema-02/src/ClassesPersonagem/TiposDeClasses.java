package ClassesPersonagem;

public enum TiposDeClasses {
    BARBARO(1,"Bárbaro"),
    CLERIGO(2,"Clérigo"),
    DRUIDA(3,"Druida"),
    FEITICEIRO(4,"Feiticeiro"),
    GUERREIRO(5,"Guerreiro"),
    MAGO(6,"Mago");

    private final int id;
    private final String descricao;

    TiposDeClasses(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public static TiposDeClasses findById(int id){
        for(TiposDeClasses v : values()){
            if(v.getId()==id){
                return v;
            }
        }
        return null;
    }



}
