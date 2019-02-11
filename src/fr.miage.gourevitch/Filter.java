package fr.miage.gourevitch;
import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {

        private String regex;

        public Filter()
        {
            this.regex=".java";
        }
        public Filter(String regex)
        {
            this.regex=regex;
        }

        @Override
        public boolean accept(File directory, String name) {
            File f = new File(directory.getAbsolutePath() + "/" + name);
            return f.isDirectory() || name.endsWith(".java");
        }


}
