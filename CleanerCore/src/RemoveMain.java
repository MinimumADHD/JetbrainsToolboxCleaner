import java.util.Scanner;
import java.io.File;

public class RemoveMain
{
    static boolean ActiveBool = true;
    static Scanner sc = new Scanner(System.in);
    static File FolderRoaming = new File("C:/Users/"+System.getProperty("user.name")+"/AppData/Roaming/JetBrains");
    static File FolderLocal = new File("C:/Users/"+System.getProperty("user.name")+"/AppData/Local/JetBrains");
    static File FolderPF = new File("C:/Program Files/JetBrains");
    public static void main(String[] args)
    {
        String ChoosenOption;
        while (ActiveBool)
        {
            System.out.println("Are you sure you want to continue? Case sensitive (YES/NO)");
            ChoosenOption = sc.nextLine();
            switch (ChoosenOption)
            {
                case "YES":
                {
                    System.out.println("Proceeding....");
                    if (FolderPF.exists())
                    {
                        System.out.println("Found folder: "+FolderPF.toString());
                        System.out.println("Deleting "+FolderPF.toString()+"; "+FolderLocal.toString()+"; "+FolderRoaming.toString());
                        DeleteFolder(FolderLocal);
                        DeleteFolder(FolderRoaming);
                        DeleteFolder(FolderPF);
                        ActiveBool = false;
                        break;
                    }
                    else
                    {
                        System.out.println("Program Files JetBrains folder not found; Deleting only: "+FolderLocal.toString()+"; "+FolderRoaming.toString());
                        DeleteFolder(FolderLocal);
                        DeleteFolder(FolderRoaming);
                        ActiveBool = false;
                        break;
                    }
                }
                case "NO":
                {
                    System.out.println("Cancelling....");
                    ActiveBool = false;
                    return;
                }
                default:
                {
                    System.out.println("Invalid Option.");
                }
            }
        }
    }
    static void DeleteFolder(File ParamFolder)
    {
        String ParamFolderString = ParamFolder.toString();
        ParamFolder.delete();
        System.out.println("Successfully Deleted "+ParamFolderString);
    }
}