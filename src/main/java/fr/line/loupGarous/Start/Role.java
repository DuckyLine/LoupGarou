package fr.line.loupGarous.Start;

import fr.line.loupGarous.Utils.Struct.Role_Struct;

public class Role {

    public static Role_Struct Villageois;
    public static Role_Struct Voyante;
    public static Role_Struct Sorciere;
    public static Role_Struct Garde;
    public static Role_Struct Cupidon;
    public static Role_Struct Chasseur;
    public static Role_Struct LoupGarou;

    public static void Role()
    {
        Villageois = new Role_Struct("Villageois", "Participe activement dans la bonne fêtes du village !", 0);
        Voyante = new Role_Struct("Voyante", "Chaque nuit la voyante peut regarder la carte d'un joueur de son choix !", 0);
        Sorciere = new Role_Struct("Sorcière", "Chaque nuit la sorcière peux choisir entre sa potion de mort ou de soin, attention elles sont épuisable !", 0);
        Garde = new Role_Struct("Garde", "Toute les nuits, le garde peut protéger une personne (lui compris) attention, il ne peut protéger 2 fois la même personne d'affilé !", 0);
        Cupidon = new Role_Struct("Cupidon", "Lors de la première nuit cupidon peut lier d'amour 2 personnes de son choix qui seront prêt à mourir si l'un d'entre eux meurt !", 0);
        Chasseur = new Role_Struct("Chasseur", "Le chasseur est un villageois normal à la différence que si il meurt il aurat le temp de tuer une personne de son choix !", 0);
        LoupGarou = new Role_Struct("Loup Garou", "Un loup garou ce transforme chaque nuit et décide de tuer une personne de son choix !", 1);
    }

}
