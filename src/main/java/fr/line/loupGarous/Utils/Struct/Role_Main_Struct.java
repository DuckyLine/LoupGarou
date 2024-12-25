package fr.line.loupGarous.Utils.Struct;

public class Role_Main_Struct {

    private Integer Villageois;
    private Integer Voyante;
    private Integer Sorciere;
    private Integer Garde;
    private Integer Cupidon;
    private Integer Chasseur;
    private Integer LoupGarou;

    public Role_Main_Struct()
    {
        this.Villageois = 0;
        this.Voyante = 0;
        this.Sorciere = 0;
        this.Garde = 0;
        this.Cupidon = 0;
        this.Chasseur = 0;
        this.LoupGarou = 0;
    }

    public Integer getRole(String role)
    {
        switch (role)
        {
            case "Villageois":
                return Villageois;
            case "Voyante":
                return Voyante;
            case "Sorciere":
                return Sorciere;
            case "Garde":
                return Garde;
            case "Cupidon":
                return Cupidon;
            case "Chasseur":
                return Chasseur;
            case "LoupGarou":
                return LoupGarou;
        }
        return null;
    }

    public void setRole(String role, Integer n)
    {
        switch (role)
        {
            case "Villageois":
                Villageois = n;
                return;
            case "Voyante":
                Voyante = n;
                return;
            case "Sorciere":
                Sorciere = n;
                return;
            case "Garde":
                Garde = n;
                return;
            case "Cupidon":
                Cupidon = n;
                return;
            case "Chasseur":
                Chasseur = n;
                return;
            case "LoupGarou":
                LoupGarou = n;
        }
    }

}
