package fr.line.loupGarous.Utils.Struct;

public class Copy_Struct
{

    private String World;
    private Integer X;
    private Integer Y;
    private Integer Z;

    public Copy_Struct(String World_Name, Integer x, Integer y, Integer z)
    {
        this.World = World_Name;
        this.X = x;
        this.Y = y;
        this.Z = z;
    }

    public String getWorld()
    {
        return World;
    }
    public Integer getCoord(String coord)
    {
        if (coord.equalsIgnoreCase("x"))
            return X;
        else if (coord.equalsIgnoreCase("y"))
            return Y;
        else if (coord.equalsIgnoreCase("z"))
            return Z;
        return null;
    }

    public void setCoord(String coord, Integer n)
    {
        if (coord.equalsIgnoreCase("x"))
            X = n;
        else if (coord.equalsIgnoreCase("y"))
            Y = n;
        else if (coord.equalsIgnoreCase("z"))
            Z = n;
    }

}
