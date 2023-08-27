package LLD.DesignPatterns.CompositePattern.FileSystem;

public class Main {
    public static void main(String[] args){
        Directory movieDirectory = new Directory("Movie");
        FileSystem border = new File("Border");
        movieDirectory.add(border);

        Directory comedyMovDirectory = new Directory("ComedyMovie");
        File hulchul = new File("Hulchul");
        comedyMovDirectory.add(hulchul);
        movieDirectory.add(comedyMovDirectory);

        movieDirectory.ls();
    }
}
