package fr.line.loupGarous.Utils.Struct;

import java.util.ArrayList;
import java.util.List;

public class Main_Struct
{

    private String Host;
    private Integer State;
    private List<String> Joueurs;
    private Role_Main_Struct Role;
    private Integer Nb_Player;

    public Main_Struct(String Player_Name)
    {
        this.Host = Player_Name;
        this.State = 0;
        this.Role = new Role_Main_Struct();
        this.Nb_Player = 1;

        this.Joueurs = new ArrayList<>();
        this.Joueurs.add(Player_Name);
    }

    public String getHost()
    {
        return Host;
    }

    public Integer getState()
    {
        return State;
    }
    public Integer getNb_Player()
    {
        return Nb_Player;
    }
    public List<String> getJoueurs()
    {
        return Joueurs;
    }
    public Integer getRole(String role_name)
    {
        return Role.getRole(role_name);
    }

    public void setHost(String host)
    {
        this.Host = host;
    }
    public void setState(Integer state)
    {
        this.State = state;
    }
    public void setNb_Player(Integer nb_Player)
    {
        this.Nb_Player = nb_Player;
    }
    public void addJoueur(String player_name)
    {
        this.Joueurs.add(player_name);
    }
    public void removeJoueur(String player_name)
    {
        this.Joueurs.remove(player_name);
    }
    public void setRole(String name_role, Integer n) {
        Role.setRole(name_role, n);
    }

}
