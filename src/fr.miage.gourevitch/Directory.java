package fr.miage.gourevitch;
import java.io.FilenameFilter;
import java.io.File;
import java.util.Objects;


public class Directory {

    /*
    Dans une classe indépendante (externe dans un fichier séparé)
     */
    public void toStringFile(String pathFile) {

        for (File file : Objects.requireNonNull(new File(pathFile).listFiles(new Filter()))) {

            if (file.isDirectory()) {
                System.out.println(file.toString());
                toStringFile(file.getPath());
            } else {
                System.out.println(file.toString());
            }
        }
    }

   /*
   Dans une classe interne nommée
    */
    public void toStringFileInterne(String pathFile) {

        for (File file : Objects.requireNonNull(new File(pathFile).listFiles(new Filtre2()))) {

            if (file.isDirectory()) {
                System.out.println(file.toString());
                toStringFile(file.getPath());
            } else {
                System.out.println(file.toString());
            }

        }

    }

   /*
   Dans une classe interne anonyme (anonymous inner class) en argument de la méthode listFiles() (une « instanciation » d'une interface),
    */
    public void toStringFileAnonyme(String pathFile) {

        for (File file : Objects.requireNonNull(new File(pathFile).listFiles(
                new FilenameFilter() {
                    @Override
                    public boolean accept(File directory, String name) {
                            File f = new File(directory.getAbsolutePath() + "/" + name);
                            return f.isDirectory() || name.endsWith(".java");
                    }
                })))
        {

            if (file.isDirectory()) {
                System.out.println(file.toString());
                toStringFile(file.getPath());
            } else {
                System.out.println(file.toString());
            }

        }

    }

    private class Filtre2 implements FilenameFilter {

        private String regex;

        public Filtre2() {
            this.regex = ".java";
        }

        public Filtre2(String regex) {
            this.regex = regex;
        }

        @Override
        public boolean accept(File directory, String name) {
            return name.contains(regex);
        }


    }
}