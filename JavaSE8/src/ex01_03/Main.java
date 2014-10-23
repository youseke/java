package ex01_03;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

public class Main {

    public static void main(String[] args) {
        for (File s : listFilesWithExtendedName(new File("/"), "vol")) {
            System.out.println(s.getName());
        }
    }

    public static File[] listFilesWithExtendedName(File file, String name) {
        return file.listFiles((File path, String extension) -> extension
                .equals(FilenameUtils.getExtension(path.getName())));
    }

}
