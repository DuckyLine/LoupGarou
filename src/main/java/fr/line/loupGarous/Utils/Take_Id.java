package fr.line.loupGarous.Utils;

import fr.line.loupGarous.LoupGarous;

public class Take_Id
{

    public static Integer Party_id(String player_name)
    {
        Integer i = 0;

        while (i < LoupGarous.Game_List.size() && LoupGarous.Game_List.get(i).getHost() != player_name)
            i++;
        return 0;
    }

}
