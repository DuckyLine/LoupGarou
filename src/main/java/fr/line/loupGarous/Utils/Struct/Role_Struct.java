package fr.line.loupGarous.Utils.Struct;

public class Role_Struct
{

    private String role;
    private String description;
    private Integer team;

    public Role_Struct(String name, String description, Integer team)
    {
        this.role = name;
        this.description = description;
        this.team = team;
    }

    public String getRole()
    {
        return role;
    }

    public String getDescription()
    {
        return description;
    }

    public Integer getTeam()
    {
        return team;
    }

}
